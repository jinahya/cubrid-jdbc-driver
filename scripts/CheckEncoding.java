import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Verifies that every file under the given directories is strictly decodable in the given encoding.
 * <p>
 * Run by the build (see the {@code check-encoding} profile of the root pom) as a single-file source program:
 * <pre>java scripts/CheckEncoding.java &lt;encoding&gt; &lt;directory&gt;...</pre>
 * <ul>
 *   <li>Fails if a file contains a malformed or unmappable byte sequence for the encoding.</li>
 *   <li>Fails if a file starts with a byte order mark.</li>
 *   <li>Fails if an {@code .xml} file declares an encoding other than the encoding (or {@code US-ASCII} with
 *       ASCII-only content).</li>
 *   <li>Reports, without failing, files containing {@code U+FFFD}; CUBRID's sources have some, already replaced on
 *       CUBRID's side, in comments.</li>
 * </ul>
 * Missing directories are ignored. Nothing is modified.
 */
public class CheckEncoding {

    private static final Pattern XML_DECLARED_ENCODING =
            Pattern.compile("\\A<\\?xml[^>]*?\\bencoding\\s*=\\s*[\"']([A-Za-z0-9._:-]+)[\"']");

    public static void main(final String... args) throws IOException {
        if (args.length < 2) {
            System.err.println("usage: java CheckEncoding.java <encoding> <directory>...");
            System.exit(2);
        }
        final Charset charset = Charset.forName(args[0]);
        final List<String> errors = new ArrayList<>();
        final List<String> replacements = new ArrayList<>();
        int checked = 0;
        for (int i = 1; i < args.length; i++) {
            final Path directory = Path.of(args[i]);
            if (!Files.isDirectory(directory)) {
                continue;
            }
            final List<Path> files;
            try (Stream<Path> stream = Files.walk(directory)) {
                files = stream.filter(Files::isRegularFile).sorted().toList();
            }
            for (final Path file : files) {
                checked++;
                final byte[] bytes = Files.readAllBytes(file);
                if (startsWithBom(bytes)) {
                    errors.add(file + ": starts with a byte order mark");
                }
                final String text;
                try {
                    text = charset.newDecoder()
                            .onMalformedInput(CodingErrorAction.REPORT)
                            .onUnmappableCharacter(CodingErrorAction.REPORT)
                            .decode(ByteBuffer.wrap(bytes))
                            .toString();
                } catch (final CharacterCodingException cce) {
                    errors.add(file + ": not decodable as " + charset.name() + " (" + cce + ")");
                    continue;
                }
                if (file.getFileName().toString().endsWith(".xml")) {
                    final Matcher matcher = XML_DECLARED_ENCODING.matcher(text);
                    if (matcher.find()) {
                        final Charset declared = Charset.forName(matcher.group(1));
                        final boolean ascii = text.chars().allMatch(c -> c < 0x80);
                        if (!declared.equals(charset) && !(ascii && declared.equals(Charset.forName("US-ASCII")))) {
                            errors.add(file + ": declares encoding " + declared.name() + ", not " + charset.name());
                        }
                    }
                }
                final long count = text.chars().filter(c -> c == '\uFFFD').count();
                if (count > 0) {
                    replacements.add(file + ": " + count + " U+FFFD");
                }
            }
        }
        replacements.forEach(r -> System.out.println("[check-encoding] (info) " + r));
        if (!errors.isEmpty()) {
            errors.forEach(e -> System.err.println("[check-encoding] " + e));
            System.err.println("[check-encoding] " + errors.size() + " error(s) in " + checked + " file(s)");
            System.exit(1);
        }
        System.out.println("[check-encoding] " + checked + " file(s) OK as " + charset.name() + "; "
                           + replacements.size() + " with U+FFFD");
    }

    private static boolean startsWithBom(final byte[] b) {
        return (b.length >= 3 && (b[0] & 0xFF) == 0xEF && (b[1] & 0xFF) == 0xBB && (b[2] & 0xFF) == 0xBF)
               || (b.length >= 2 && (((b[0] & 0xFF) == 0xFE && (b[1] & 0xFF) == 0xFF)
                                     || ((b[0] & 0xFF) == 0xFF && (b[1] & 0xFF) == 0xFE)));
    }
}
