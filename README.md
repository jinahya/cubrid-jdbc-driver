# cubrid-jdbc-driver

Publishes [CUBRID JDBC Drivers](http://ftp.cubrid.org/CUBRID_Drivers/JDBC_Driver/) to the [Maven Central Repository](https://central.sonatype.com/), built from CUBRID's **unmodified** sources.

CUBRID hosts its drivers on its own [Maven repository](https://maven.cubrid.org/) (`cubrid:cubrid-jdbc`), which requires extra repository configuration and has no sources or javadoc jars. CUBRID itself publishes only `11.3.2.0053` to the Central, as [`org.cubrid:cubrid-jdbc`](https://central.sonatype.com/artifact/org.cubrid/cubrid-jdbc). This repository covers every other version for which CUBRID provides sources.

## Usage

The version is CUBRID's version, as is.

```xml
<dependency>
  <groupId>io.github.jinahya</groupId>
  <artifactId>cubrid-jdbc-driver</artifactId>
  <version>11.3.2.0053</version>
</dependency>
```

```groovy
implementation 'io.github.jinahya:cubrid-jdbc-driver:11.3.2.0053'
```

Each version comes with `-sources.jar` and `-javadoc.jar`, and requires Java 8 or later.

## Versions

Each version on [maven.cubrid.org](https://maven.cubrid.org/cubrid/cubrid-jdbc/) whose source jar (`JDBC-<version>-cubrid-src.jar`) is on [ftp.cubrid.org](http://ftp.cubrid.org/CUBRID_Drivers/JDBC_Driver/) is a module under [`drivers/`](drivers). 143 versions in total.

| Line | # | Versions |
|---|---|---|
| 8.4 | 48 | `8.4.1.3024`, `8.4.1.4001`, `8.4.1.5002`, `8.4.1.6004`, `8.4.1.7007`, `8.4.1.12002`, `8.4.1.21001`, `8.4.1.23002`, `8.4.1.24002`, `8.4.1.25004`, `8.4.1.28003`, `8.4.1.29001`, `8.4.1.30011`, `8.4.1.31007`, `8.4.1.32003`, `8.4.1.33006`, `8.4.1.34002`, `8.4.1.35003`, `8.4.3.0150`, `8.4.3.1005`, `8.4.3.3001`, `8.4.3.4002`, `8.4.3.5001`, `8.4.3.6001`, `8.4.3.7001`, `8.4.3.8002`, `8.4.3.9001`, `8.4.3.10001`, `8.4.3.11001`, `8.4.4.0227`, `8.4.4.1001`, `8.4.4.3003`, `8.4.4.4007`, `8.4.4.5002`, `8.4.4.6001`, `8.4.4.7004`, `8.4.4.8004`, `8.4.4.9008`, `8.4.4.10001`, `8.4.4.11004`, `8.4.4.12003`, `8.4.4.13002`, `8.4.4.14008`, `8.4.4.15002`, `8.4.4.16002`, `8.4.4.17007`, `8.4.4.18002`, `8.4.4.19002` |
| 9.0 | 1 | `9.0.0.0478` |
| 9.1 | 1 | `9.1.0.0212` |
| 9.2 | 27 | `9.2.0.0155`, `9.2.1.0020`, `9.2.3.0005`, `9.2.5.0001`, `9.2.6.0002`, `9.2.9.0002`, `9.2.10.0001`, `9.2.11.0005`, `9.2.12.0006`, `9.2.13.0003`, `9.2.14.0004`, `9.2.15.0002`, `9.2.16.0003`, `9.2.17.0002`, `9.2.18.0004`, `9.2.19.0003`, `9.2.20.0003`, `9.2.21.0005`, `9.2.22.0003`, `9.2.23.0002`, `9.2.24.0002`, `9.2.25.0003`, `9.2.26.0004`, `9.2.27.0010`, `9.2.28.0004`, `9.2.29.0001`, `9.2.30.0004` |
| 9.3 | 10 | `9.3.0.0206`, `9.3.1.0005`, `9.3.2.0016`, `9.3.3.0014`, `9.3.4.0002`, `9.3.5.0002`, `9.3.6.0002`, `9.3.7.0008`, `9.3.8.0003`, `9.3.9.0002` |
| 10.0 | 1 | `10.0.0.1376` |
| 10.1 | 9 | `10.1.0.7663`, `10.1.1.7691`, `10.1.2.7694`, `10.1.3.7765`, `10.1.4.7800`, `10.1.5.7809`, `10.1.6.7817`, `10.1.7.7819`, `10.1.8.7823` |
| 10.2 | 19 | `10.2.0.8797`, `10.2.1.8849`, `10.2.2.8874`, `10.2.3.8881`, `10.2.4.8884`, `10.2.5.8886`, `10.2.6.8891`, `10.2.7.8896`, `10.2.8.8904`, `10.2.10.8925`, `10.2.11.8944`, `10.2.12.8947`, `10.2.13.8952`, `10.2.14.8955`, `10.2.15.8978`, `10.2.16.8997`, `10.2.17.9008`, `10.2.18.9024`, `10.2.19.9052` |
| 11.0 | 18 | `11.0.0.0248`, `11.0.1.0286`, `11.0.2.0291`, `11.0.3.0293`, `11.0.4.0297`, `11.0.5.0299`, `11.0.6.0313`, `11.0.7.0317`, `11.0.8.0319`, `11.0.9.0331`, `11.0.10.0341`, `11.0.11.0365`, `11.0.12.0375`, `11.0.13.0378`, `11.0.14.0388`, `11.0.15.0402`, `11.0.16.0419`, `11.0.17.0452` |
| 11.1 | 3 | `11.1.0.0027`, `11.1.1.0028`, `11.1.1.0030` |
| 11.2 | 3 | `11.2.0.0035`, `11.2.1.0038`, `11.2.1.0040` |
| 11.3 | 3 | `11.3.0.0047`, `11.3.1.0050`, `11.3.2.0053` |

Not available, for lack of sources:

* No source jar on the ftp: `8.2.0`, `8.2.1`, `8.2.2`, `8.3.0`, `8.3.1`, `8.4.0`, `8.4.1.2032`, `8.4.1.11001`, `8.4.1.13001`, `8.4.1.27002`, `9.2.4.0002`, `9.2.7.0006`, `9.2.8.0003`, `11.0.13.0379`
* The source jar has no sources (compiled classes only): `8.4.3.2003`, `9.2.2.0003`

## How it is built

### Sources are never modified

`drivers/<version>/src/main/{java,resources}` are extracted byte-for-byte from `JDBC-<version>-cubrid-src.jar`, whose URL and SHA-256 are recorded in each module's `pom.xml`. That includes encodings and line endings ([`.gitattributes`](.gitattributes) disables EOL conversion).

* All sources are ASCII or UTF-8. A few Korean comments in CUBRID's sources were already irreversibly replaced with `U+FFFD` (`�`) on CUBRID's side, and are kept as they are; this affects comments only.
* `11.1.0.0027`'s source jar puts its sources under `jdbc/`; the module points `sourceDirectory` at it instead of moving files. That jar also lacks `sql-error-codes.xml`, so the artifact does too; and it contains sources of `java.sql`/`javax.sql` stubs, which are compiled and included as CUBRID's own binary does (harmless; the JDK's classes always take precedence).
* CUBRID's own binaries of some old versions (`8.4.1.3024` – `9.2.1.0020`) bundle compiled `java.sql` stubs (`NClob`, `RowId`, ...) that are not in the sources. They are not needed with Java 8+, and are not included.

### Java release

CUBRID's binaries target Java 5 (and Java 6 since `11.1.1.0028`), and CUBRID's poms carry no build information. Each module's `maven.compiler.release` is detected as the lowest release, minimum `8`, that its sources compile with. Currently it is `8` for every version.

## Building

Requires JDK 25 and Maven 3.9.x (`central-publishing-maven-plugin` does not support Maven 4).

```shell
mvn clean verify                                 # all versions
mvn clean verify -pl drivers/11.3.2.0053         # a single version
mvn -P central-releases -Dgpg.skip clean verify  # also with -sources.jar and -javadoc.jar
```

## Publishing

The parent, [`io.github.jinahya:jinahya-parent`](https://central.sonatype.com/artifact/io.github.jinahya/jinahya-parent), provides the `central-releases` profile (signing, sources, javadoc, `central-publishing-maven-plugin`).

```shell
mvn -P central-releases clean deploy -pl drivers/11.3.2.0053  # a single version
mvn -P central-releases clean deploy                          # every version not yet published
```

Module poms are flattened (no parent) before being published, and the aggregator (`cubrid-jdbc-driver-parent`) is not published. Versions already on the Central are skipped (`ignorePublishedComponents`).

## Adding a new version

```shell
JAVA_HOME=<jdk-25> scripts/add-version.sh <version>...
```

[`scripts/add-version.sh`](scripts/add-version.sh) downloads the source jar, extracts it unmodified into `drivers/<version>`, detects the encoding, the source root and the lowest compilable release, writes the module's `pom.xml`, and regenerates `<modules>` of the root `pom.xml`.

## Previously published artifacts

Versions published before, as `com.github.jinahya:cubrid-jdbc-driver-<version>` (with their own versions such as `1.0.0`), remain on the Central but are no longer maintained; their branches and tags are kept in this repository. Use `io.github.jinahya:cubrid-jdbc-driver` instead.
