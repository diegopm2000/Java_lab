# Spring postConstruct y preDestroy

Instead of using the init-method and destroy-method, we can use, annotations, based on J2EE JSR-250 (Common Annotations for Java Platform)

```java

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Person {

  private int id;
  private String name;
  private String surname;
  private Country country;

  @PostConstruct
  public void init() {
    System.out.println("Inicialización del Bean Person");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Destrucción del Bean Person");
  }

```

Add the CommonAnnotationBeanPostProcessor to the beans.xml to allow the Common Annotations.

```xml
<bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"></bean>
     
```

And, in the pom.xml, we put the dependency of the javaee-api

```xml
<dependency>
  <groupId>javax</groupId>
  <artifactId>javaee-api</artifactId>
  <version>8.0.1</version>
</dependency>
```