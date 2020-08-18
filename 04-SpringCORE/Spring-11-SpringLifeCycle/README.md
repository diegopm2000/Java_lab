# Spring Life Cycle of Beans

We can use the properties __init-method__ and __destroy-method__ to define methods that will be executed in the instantation and the destruction of the bean

```xml
<bean id="person" class="com.springlifecycle.beans.Person" autowire="byName" init-method="init" destroy-method="destroy">
      <property name="id" value="1"></property>
      <property name="name" value="Andrew"></property>
      <property name="surname" value="Ryan"></property>
    </bean>
```

Additionally we can use the __default-init-method__ in the head of the beans.xml globally

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans.xsd 
    http://www.springframework.org/schema/context 
    http://www.springframework.org/schema/context/spring-context.xsd"
    default-init-method="init" default-destroy-method="destroy">

...    

```