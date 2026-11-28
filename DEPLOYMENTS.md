# Deploying to the Central

The history of deploying the drivers to the [Maven Central Repository](https://central.sonatype.com/artifact/io.github.jinahya/cubrid-jdbc-driver).

## Rules

* **Never deploy every version at once.** The Central has throttled this account for a massive upload before. Deploy one batch at a time, and leave time between batches.
* Each version uploads about 1.1 MB (jar, `-sources.jar`, `-javadoc.jar`, pom; plus signatures and checksums), so a batch of 10 is about 11 MB. All 142 versions are about 154 MB.
* A release on the Central cannot be removed. Before each batch, make sure none of its versions has appeared as [`org.cubrid:cubrid-jdbc`](https://central.sonatype.com/artifact/org.cubrid/cubrid-jdbc); if one has, drop that module instead of deploying it.
* Record every attempt in the [log](#log), including failures, right after it happens.

## Deploying a batch

```shell
# the versions of the batch, from the plan below
versions="11.3.1.0050 11.3.0.0047 ..."
mvn -P central-releases clean deploy -pl "$(echo $versions | tr ' ' '\n' | sed 's|^|drivers/|' | paste -sd, -)"
```

Then:

1. Note the deployment ID that `central-publishing-maven-plugin` prints.
2. Check the deployment on <https://central.sonatype.com/publishing/deployments>, and publish it there if it is not published automatically.
3. Once the versions show up on <https://repo1.maven.org/maven2/io/github/jinahya/cubrid-jdbc-driver/>, mark the batch as deployed in the plan, and add a row to the log.

## Plan

Newest first, 10 versions per batch. Fill in *Deployed* (date) when a batch is published.

| Batch | # | Versions | Deployed |
|---|---|---|---|
| 1 | 10 | `11.3.1.0050`, `11.3.0.0047`, `11.2.1.0040`, `11.2.1.0038`, `11.2.0.0035`, `11.1.1.0030`, `11.1.1.0028`, `11.1.0.0027`, `11.0.17.0452`, `11.0.16.0419` | |
| 2 | 10 | `11.0.15.0402`, `11.0.14.0388`, `11.0.13.0378`, `11.0.12.0375`, `11.0.11.0365`, `11.0.10.0341`, `11.0.9.0331`, `11.0.8.0319`, `11.0.7.0317`, `11.0.6.0313` | |
| 3 | 10 | `11.0.5.0299`, `11.0.4.0297`, `11.0.3.0293`, `11.0.2.0291`, `11.0.1.0286`, `11.0.0.0248`, `10.2.19.9052`, `10.2.18.9024`, `10.2.17.9008`, `10.2.16.8997` | |
| 4 | 10 | `10.2.15.8978`, `10.2.14.8955`, `10.2.13.8952`, `10.2.12.8947`, `10.2.11.8944`, `10.2.10.8925`, `10.2.8.8904`, `10.2.7.8896`, `10.2.6.8891`, `10.2.5.8886` | |
| 5 | 10 | `10.2.4.8884`, `10.2.3.8881`, `10.2.2.8874`, `10.2.1.8849`, `10.2.0.8797`, `10.1.8.7823`, `10.1.7.7819`, `10.1.6.7817`, `10.1.5.7809`, `10.1.4.7800` | |
| 6 | 10 | `10.1.3.7765`, `10.1.2.7694`, `10.1.1.7691`, `10.1.0.7663`, `10.0.0.1376`, `9.3.9.0002`, `9.3.8.0003`, `9.3.7.0008`, `9.3.6.0002`, `9.3.5.0002` | |
| 7 | 10 | `9.3.4.0002`, `9.3.3.0014`, `9.3.2.0016`, `9.3.1.0005`, `9.3.0.0206`, `9.2.30.0004`, `9.2.29.0001`, `9.2.28.0004`, `9.2.27.0010`, `9.2.26.0004` | |
| 8 | 10 | `9.2.25.0003`, `9.2.24.0002`, `9.2.23.0002`, `9.2.22.0003`, `9.2.21.0005`, `9.2.20.0003`, `9.2.19.0003`, `9.2.18.0004`, `9.2.17.0002`, `9.2.16.0003` | |
| 9 | 10 | `9.2.15.0002`, `9.2.14.0004`, `9.2.13.0003`, `9.2.12.0006`, `9.2.11.0005`, `9.2.10.0001`, `9.2.9.0002`, `9.2.6.0002`, `9.2.5.0001`, `9.2.3.0005` | |
| 10 | 10 | `9.2.1.0020`, `9.2.0.0155`, `9.1.0.0212`, `9.0.0.0478`, `8.4.4.19002`, `8.4.4.18002`, `8.4.4.17007`, `8.4.4.16002`, `8.4.4.15002`, `8.4.4.14008` | |
| 11 | 10 | `8.4.4.13002`, `8.4.4.12003`, `8.4.4.11004`, `8.4.4.10001`, `8.4.4.9008`, `8.4.4.8004`, `8.4.4.7004`, `8.4.4.6001`, `8.4.4.5002`, `8.4.4.4007` | |
| 12 | 10 | `8.4.4.3003`, `8.4.4.1001`, `8.4.4.0227`, `8.4.3.11001`, `8.4.3.10001`, `8.4.3.9001`, `8.4.3.8002`, `8.4.3.7001`, `8.4.3.6001`, `8.4.3.5001` | |
| 13 | 10 | `8.4.3.4002`, `8.4.3.3001`, `8.4.3.1005`, `8.4.3.0150`, `8.4.1.35003`, `8.4.1.34002`, `8.4.1.33006`, `8.4.1.32003`, `8.4.1.31007`, `8.4.1.30011` | |
| 14 | 10 | `8.4.1.29001`, `8.4.1.28003`, `8.4.1.25004`, `8.4.1.24002`, `8.4.1.23002`, `8.4.1.21001`, `8.4.1.12002`, `8.4.1.7007`, `8.4.1.6004`, `8.4.1.5002` | |
| 15 | 2 | `8.4.1.4001`, `8.4.1.3024` | `8.4.1.3024`: 2026-11-26 (trial); `8.4.1.4001`: 2026-11-28 |

## Log

One row per attempt, newest last. *Status* is `published`, `failed`, `dropped` or `throttled`; say what happened in *Notes*.

| Date | Batch | Versions | Deployment ID | Status | Notes |
|---|---|---|---|---|---|
| 2026-11-26 | 15 (trial) | `8.4.1.3024` | `b6e35435-f3e7-4be7-bda3-ff1614b267cb` | published | First deployment, a single version to check the process. Bundle 957 KB (jar, sources, javadoc, pom; signatures and checksums). Validated; auto-published (`autoPublish`). Confirmed on repo1 on 2026-11-28. |
| 2026-11-28 | 15 | `8.4.1.4001` | `15980231-69ff-4296-8aa1-0a01bd825175` | published | A single version, the oldest undeployed. Checked first that `org.cubrid:cubrid-jdbc` has only `11.3.2.0053`. Validated; auto-published. Confirmed on repo1 on 2026-11-28. |
