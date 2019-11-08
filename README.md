# Java Laboratory

Main repository of General purpose Java labs

Here are the steps to install a runtime and development environment in Linux Ubuntu 18.04

### 1. JDK vs JRE

__JDK__ is the Java Development Kit. It is used to build programs using the Java programming language. It brings useful tools such as the compiler (javac), the binary disassembler (javap), debugger, among other tools. The JDK even provides application performance evaluation tools, such as VisualVM and Mission Control. All this and more tools. A JDK installation already contains a JRE inside the folders.

__JRE__ is the Java Runtime Environment. It contains the JVM and other tools that allow the execution of Java applications. JRE does not have compilers or tools to develop Java applications, it only has the tools to run them.

### 2. How to install java

Install JRE executing:

```shell
$ sudo apt install default-jre
```

Install JDK executing:

```shell
$ sudo apt install openjdk-11-jdk-headless
```

Finally check executing:

```shell
$ java --version

openjdk 11.0.4 2019-07-16
OpenJDK Runtime Environment (build 11.0.4+11-post-Ubuntu-1ubuntu218.04.3)
OpenJDK 64-Bit Server VM (build 11.0.4+11-post-Ubuntu-1ubuntu218.04.3, mixed mode, sharing)
```