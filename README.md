# cubrid-jdbc-driver

> **This repository is in the attic and may be removed.**
>
> CUBRID now publishes its JDBC driver to Maven Central under its own coordinates.
> Use the official artifact instead:
>
> | | |
> |---|---|
> | groupId | `org.cubrid` |
> | artifactId | `cubrid-jdbc` |
> | coordinates | `org.cubrid:cubrid-jdbc` |
> | repository | [repo1.maven.org/maven2/org/cubrid/cubrid-jdbc](https://repo1.maven.org/maven2/org/cubrid/cubrid-jdbc/) |
>
> Maven
>
> ```xml
> <dependency>
>   <groupId>org.cubrid</groupId>
>   <artifactId>cubrid-jdbc</artifactId>
>   <version>11.3.2.0053</version>
> </dependency>
> ```
>
> Gradle
>
> ```groovy
> implementation 'org.cubrid:cubrid-jdbc:11.3.2.0053'
> ```
>
> See [org.cubrid:cubrid-jdbc](https://central.sonatype.com/artifact/org.cubrid/cubrid-jdbc) for available versions.
> No further versions will be published from this repository, and requests for new versions will not be accepted.

## History

This repository was used to upload [CUBRID JDBC Drivers](http://ftp.cubrid.org/CUBRID_Drivers/JDBC_Driver/) to [Maven Central Repository](https://central.sonatype.com/), before CUBRID published them officially.

For versions not (yet) available under `org.cubrid`, you can use the [CUBRID JDBC Maven Repository](https://maven.cubrid.org/).

## Previously published artifacts

Artifacts already published under `com.github.jinahya` remain available on Maven Central (they cannot be removed from there), but are no longer maintained.

```xml
<dependency>
  <groupId>com.github.jinahya</groupId>
  <artifactId>cubrid-jdbc-driver-x.y.z.some</artifactId>
  <version>a.b.c</version>
</dependency>
```

See [the list of those artifacts](https://central.sonatype.com/search?q=g:com.github.jinahya%20cubrid-jdbc-driver).
