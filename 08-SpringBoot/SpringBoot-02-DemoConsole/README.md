# Spring Boot DemoConsole

A demo of a minimal SpringBoot project created using the Spring Initializer:

```url
https://start.spring.io/
```

In this case, we do not add the Web module

## 1. Starting the application

We can start the application as usual and we will get:

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

2020-08-16 19:02:10.644  INFO 46604 --- [           main] c.e.democonsole.DemoconsoleApplication   : Starting DemoconsoleApplication using Java 11.0.8 on Budgie20-dev with PID 46604 (/home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-02-DemoConsole/target/classes started by diego in /home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-02-DemoConsole)
2020-08-16 19:02:10.647  INFO 46604 --- [           main] c.e.democonsole.DemoconsoleApplication   : No active profile set, falling back to default profiles: default
2020-08-16 19:02:11.387  INFO 46604 --- [           main] c.e.democonsole.DemoconsoleApplication   : Started DemoconsoleApplication in 1.278 seconds (JVM running for 2.151)

Process finished with exit code 0
```

## 2. Adding the implementation of the CommandLineRunner and the method run in DemoconsoleApplication.java

```java
package com.example.democonsole;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoconsoleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoconsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HelloWorld SpringBoot Console!");
	}
}
```

And then, running the application again:

```shell
 .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

2020-08-16 19:06:15.885  INFO 46942 --- [           main] c.e.democonsole.DemoconsoleApplication   : Starting DemoconsoleApplication using Java 11.0.8 on Budgie20-dev with PID 46942 (/home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-02-DemoConsole/target/classes started by diego in /home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-02-DemoConsole)
2020-08-16 19:06:15.889  INFO 46942 --- [           main] c.e.democonsole.DemoconsoleApplication   : No active profile set, falling back to default profiles: default
2020-08-16 19:06:16.501  INFO 46942 --- [           main] c.e.democonsole.DemoconsoleApplication   : Started DemoconsoleApplication in 1.156 seconds (JVM running for 1.773)
HelloWorld SpringBoot Console!

Process finished with exit ode 0
```

## 3. Adding a Logger

```java
package com.example.democonsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoconsoleApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(DemoconsoleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoconsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("HelloWorld SpringBoot Console!");
	}
}
```

```shell
.   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

2020-08-16 19:10:03.755  INFO 47068 --- [           main] c.e.democonsole.DemoconsoleApplication   : Starting DemoconsoleApplication using Java 11.0.8 on Budgie20-dev with PID 47068 (/home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-02-DemoConsole/target/classes started by diego in /home/diego/workdir/GitHub-Personal/Laboratories/java_lab/08-SpringBoot/SpringBoot-02-DemoConsole)
2020-08-16 19:10:03.761  INFO 47068 --- [           main] c.e.democonsole.DemoconsoleApplication   : No active profile set, falling back to default profiles: default
2020-08-16 19:10:04.378  INFO 47068 --- [           main] c.e.democonsole.DemoconsoleApplication   : Started DemoconsoleApplication in 1.075 seconds (JVM running for 1.634)
2020-08-16 19:10:04.385  INFO 47068 --- [           main] c.e.democonsole.DemoconsoleApplication   : HelloWorld SpringBoot Console!

Process finished with exit code 0

```