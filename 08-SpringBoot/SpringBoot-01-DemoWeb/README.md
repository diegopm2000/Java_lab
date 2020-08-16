# Spring Boot DemoWeb

A demo of a minimal SpringBoot project created using the Spring Initializer:

```url
https://start.spring.io/
```

We need to add the Web dependency to get a minimal tomcat webserver as shows the diagram:

![SpringBoot DemoWeb](SpringBootDemoWeb.png)

## Starting the application

We can start the application as usual and we will get:

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

2020-08-16 18:22:14.611  INFO 43133 --- [           main] com.example.demoweb.DemowebApplication   : Starting DemowebApplication using Java 11.0.8 on Budgie20-dev with PID 43133 (/home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-01-DemoWeb/target/classes started by diego in /home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-01-DemoWeb)
2020-08-16 18:22:14.615  INFO 43133 --- [           main] com.example.demoweb.DemowebApplication   : No active profile set, falling back to default profiles: default
2020-08-16 18:22:15.946  INFO 43133 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-08-16 18:22:15.962  INFO 43133 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-08-16 18:22:15.963  INFO 43133 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.37]
2020-08-16 18:22:16.051  INFO 43133 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-08-16 18:22:16.051  INFO 43133 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1296 ms
2020-08-16 18:22:16.278  INFO 43133 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-08-16 18:22:16.472  INFO 43133 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-08-16 18:22:16.484  INFO 43133 --- [           main] com.example.demoweb.DemowebApplication   : Started DemowebApplication in 2.805 seconds (JVM running for 3.693)
```

And finally testing it in the browser:

![SpringBoot Test](SpringBootTest.png)

By default, Tomcat uses the 8080 port, but we can change it in the application.properties file:

```properties
server.port = 8090
```

Adding a dependency called devtools in the pom.xml, we will obtain the auto restart of the server during the development.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```