# Spring Bean Post Processor

Using the Bean Post Processor

We have created this Bean:

```java
package com.beanpostprocessor.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class SampleBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("After of the initialization: " + beanName);
    return bean;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("Before of the initialization: " + beanName);
    return bean;
  }

}
```

with a reference in the beans.xml

```xml
...
<bean class="com.beanpostprocessor.beans.SampleBeanPostProcessor"></bean>
...
```

This processor will be executed before the init method and after of the destroy method of the beans.

Example of execution:

```shell
Before of the initialization: city
After of the initialization: city
Before of the initialization: country
After of the initialization: country
Before of the initialization: person
BEFORE
After of the initialization: person
id: 1, name: Andrew, surname: Ryan, country: Rapture
AFTER
```

