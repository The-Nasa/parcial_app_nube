ubuntu@ip-172-31-9-144:~$ docker logs --tail 50 derrepente-backend
        at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122) ~[hibernate-core-6.4.4.Final.jar!/:6.4.4.Final]
        at org.hibernate.internal.NonContextualJdbcConnectionAccess.obtainConnection(NonContextualJdbcConnectionAccess.java:46) ~[hibernate-core-6.4.4.Final.jar!/:6.4.4.Final]
        at org.hibernate.resource.jdbc.internal.LogicalConnectionManagedImpl.acquireConnectionIfNeeded(LogicalConnectionManagedImpl.java:113) ~[hibernate-core-6.4.4.Final.jar!/:6.4.4.Final]
        ... 45 common frames omitted
Caused by: org.postgresql.util.PSQLException: FATAL: (ENOTFOUND) tenant/user postgres.hydxnouyyioyxvemboqi not found
        at org.postgresql.core.v3.ConnectionFactoryImpl.doAuthentication(ConnectionFactoryImpl.java:693) ~[postgresql-42.6.1.jar!/:42.6.1]
        at org.postgresql.core.v3.ConnectionFactoryImpl.tryConnect(ConnectionFactoryImpl.java:203) ~[postgresql-42.6.1.jar!/:42.6.1]
        at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl(ConnectionFactoryImpl.java:258) ~[postgresql-42.6.1.jar!/:42.6.1]
        at org.postgresql.core.ConnectionFactory.openConnection(ConnectionFactory.java:54) ~[postgresql-42.6.1.jar!/:42.6.1]
        at org.postgresql.jdbc.PgConnection.<init>(PgConnection.java:263) ~[postgresql-42.6.1.jar!/:42.6.1]
        at org.postgresql.Driver.makeConnection(Driver.java:443) ~[postgresql-42.6.1.jar!/:42.6.1]
        at org.postgresql.Driver.connect(Driver.java:297) ~[postgresql-42.6.1.jar!/:42.6.1]
        at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:138) ~[HikariCP-5.0.1.jar!/:na]
        at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:359) ~[HikariCP-5.0.1.jar!/:na]
        at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:201) ~[HikariCP-5.0.1.jar!/:na]
        at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:470) ~[HikariCP-5.0.1.jar!/:na]
        at com.zaxxer.hikari.pool.HikariPool$PoolEntryCreator.call(HikariPool.java:733) ~[HikariCP-5.0.1.jar!/:na]
        at com.zaxxer.hikari.pool.HikariPool$PoolEntryCreator.call(HikariPool.java:712) ~[HikariCP-5.0.1.jar!/:na]
        at java.base/java.util.concurrent.FutureTask.run(Unknown Source) ~[na:na]
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source) ~[na:na]
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source) ~[na:na]
        at java.base/java.lang.Thread.run(Unknown Source) ~[na:na]

2026-09-25T23:03:28.575Z  INFO 1 --- [tourist-forecast-backend] [           main] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2026-09-25T23:03:28.578Z  INFO 1 --- [tourist-forecast-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2026-09-25T23:03:32.092Z  INFO 1 --- [tourist-forecast-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.3)

2026-09-25T23:03:34.425Z  INFO 1 --- [tourist-forecast-backend] [           main] c.t.t.TouristForecastApplication         : Starting TouristForecastApplication v1.0.0 using Java 17.0.20 with PID 1 (/app/app.jar started by root in /app)
2026-09-25T23:03:34.429Z  INFO 1 --- [tourist-forecast-backend] [           main] c.t.t.TouristForecastApplication         : The following 1 profile is active: "prod"
2026-09-25T23:03:36.423Z  INFO 1 --- [tourist-forecast-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-09-25T23:03:36.529Z  INFO 1 --- [tourist-forecast-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 90 ms. Found 2 JPA repository interfaces.
2026-09-25T23:03:37.669Z  INFO 1 --- [tourist-forecast-backend] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2026-09-25T23:03:37.688Z  INFO 1 --- [tourist-forecast-backend] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-09-25T23:03:37.689Z  INFO 1 --- [tourist-forecast-backend] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2026-09-25T23:03:37.750Z  INFO 1 --- [tourist-forecast-backend] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2026-09-25T23:03:37.752Z  INFO 1 --- [tourist-forecast-backend] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3139 ms
2026-09-25T23:03:38.085Z  INFO 1 --- [tourist-forecast-backend] [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2026-09-25T23:03:38.190Z  INFO 1 --- [tourist-forecast-backend] [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.4.4.Final
2026-09-25T23:03:38.256Z  INFO 1 --- [tourist-forecast-backend] [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2026-09-25T23:03:38.724Z  INFO 1 --- [tourist-forecast-backend] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2026-09-25T23:03:38.776Z  INFO 1 --- [tourist-forecast-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2026-09-25T23:03:41.122Z  INFO 1 --- [tourist-forecast-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
ubuntu@ip-172-31-9-144:~$ 