# Spring Boot MVC + Thymeleaft

Example of Spring Boot with JPA

## 1. Add Spring JPA and postgresql dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

The postgresql library is integrated in Soring

## 2. Configuration

application.properties file

```properties
server.port = 8080

spring.jpa.database = POSTGRESQL
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
spring.datasource.driver-class-name = org.postgresql.Driver
spring.datasource.url = jdbc:postgresql://localhost/demo
spring.datasource.username = postgres
spring.datasource.password = password
spring.jpa.properties.hibernate.jdbc.log.non_contextual_creation=true
```

## 3. Creation of the table Person at app starting

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

2020-08-16 20:43:17.079  INFO 54746 --- [           main] com.example.demoweb.DemowebApplication   : Starting DemowebApplication using Java 11.0.8 on Budgie20-dev with PID 54746 (/home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-06-SpringData/target/classes started by diego in /home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-06-SpringData)
2020-08-16 20:43:17.109  INFO 54746 --- [           main] com.example.demoweb.DemowebApplication   : No active profile set, falling back to default profiles: default
2020-08-16 20:43:18.036  INFO 54746 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFERRED mode.
2020-08-16 20:43:18.099  INFO 54746 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 53 ms. Found 1 JPA repository interfaces.
2020-08-16 20:43:18.780  INFO 54746 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-08-16 20:43:18.792  INFO 54746 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-08-16 20:43:18.792  INFO 54746 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.37]
2020-08-16 20:43:18.890  INFO 54746 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-08-16 20:43:18.891  INFO 54746 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1691 ms
2020-08-16 20:43:19.153  INFO 54746 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-08-16 20:43:19.216  INFO 54746 --- [         task-1] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2020-08-16 20:43:19.269  INFO 54746 --- [         task-1] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.20.Final
2020-08-16 20:43:19.284  WARN 54746 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2020-08-16 20:43:19.424  INFO 54746 --- [         task-1] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2020-08-16 20:43:19.536  INFO 54746 --- [         task-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-08-16 20:43:19.687  INFO 54746 --- [         task-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-08-16 20:43:19.706  INFO 54746 --- [         task-1] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL95Dialect
2020-08-16 20:43:20.020  INFO 54746 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-08-16 20:43:20.023  INFO 54746 --- [           main] DeferredRepositoryInitializationListener : Triggering deferred initialization of Spring Data repositories…
Hibernate: create table person (id_person int4 not null, name varchar(50), primary key (id_person))
2020-08-16 20:43:20.446  INFO 54746 --- [         task-1] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2020-08-16 20:43:20.455  INFO 54746 --- [         task-1] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2020-08-16 20:43:20.665  INFO 54746 --- [           main] DeferredRepositoryInitializationListener : Spring Data repositories initialized!
2020-08-16 20:43:20.675  INFO 54746 --- [           main] com.example.demoweb.DemowebApplication   : Started DemowebApplication in 4.805 seconds (JVM running for 5.717)
```





