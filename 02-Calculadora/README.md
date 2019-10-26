# Calculadora en Java

#### Implementación de una calculadora de número enteros en Java 8

Se han usado las siguientes librerías:

- __Slf4j 1.7__ como fachada de log
- __log4j 1.2__ como implementación de log
- __junit 4.12__ como motor de pruebas unitarias
- __hamcrest 1.3__ y __sazamcrest 0.11__ como apoyo a junit para pruebas unitarias

Nota: Se ha configurado __log4j__ usando un fichero __log4j.properties__ dentro de la carpeta resources.

Además se ha añadido la verificación de calidad del código.

### Verificación de calidad del código

Usaremos __maven__, __jacoco__ y __sonarqube__ para verificar la calidad del código.

#### Jacoco y Maven

para tener el porcentaje de cobertura de código de los test. Se usa la herramienta __jacoco__.

http://www.eclemma.org/index.html

Lanzamos los test unitarios con jacoco y maven

```shell
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true
```

NOTA: En el pom.xml es necesario añadir:

En la zona de plugins

```code
<build>
  <plugins>
    ...
    ...
    <plugin>
    	<groupId>org.sonarsource.scanner.maven</groupId>
    	<artifactId>sonar-maven-plugin</artifactId>
    	<version>3.2</version>
    </plugin>
  </plugins>
</build>
```

Al mismo nivel que dependencies

```code
<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<sonar.language>java</sonar.language>
</properties>
<dependencies>
...
</dependencies>
```

#### Sonarqube

Arrancamos el docker de sonarqube 6.2, y ejecutamos el análisis con sonarqube:

```
$ mvn sonar:sonar
```

Si vamos a sonarqube veremos el informe de nuestro proyecto que incluirá el porcentaje de cobertura de los test.
