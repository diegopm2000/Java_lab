# Maven Helloworld

Project Helloworld in Maven & Java 11.

### 1. Creating the Maven Project

The project was created from Maven Projects, clicking on "+" icon and using the quickstart archetype.
Finally, changed the java version from 1.7 created by default to 11

### 2. Compilint the Project

Go to the pom.xml file and execute:

```shell
$ mvn compile

[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.helloworld:helloworldmaven >-------------------
[INFO] Building helloworldmaven 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ helloworldmaven ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/diego/workdir/proyectos-GitHub/laboratories/java_lab/02-HelloworldMaven/helloworldmaven/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ helloworldmaven ---
[INFO] Nothing to compile - all classes are up to date
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.613 s
[INFO] Finished at: 2020-04-19T18:37:03+02:00
[INFO] ------------------------------------------------------------------------
```

### 2. Executing the project

Using IntelliJ Idea, go to App.java and run the file

### 3. Execute the test

The project comes with a minimal test. You can execute it going to AppTest.java and running the test.
