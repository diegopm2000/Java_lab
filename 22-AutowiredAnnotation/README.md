# Autowired Annotation

## 1. Basic usage

Mark Autowired in java (by default uses by type)

```java
@Autowired
private ITeam team;
```

And in xml

```xml
<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"></bean>

 <bean id="messi" class="com.sampleautowired.beans.Player">
    <property name="number" value="10"></property>
    <property name="name" value="Lionel Messi"></property>
    <!-- <property name="team" ref="barcelona"></property> -->
</bean>

<bean id="team" class="com.sampleautowired.beans.Barcelona"></bean>
```

We don't need use the ref using Autowired Annotation

## 2. Qualifier usage

You can use a qualifier

```java
@Autowired
@Qualifier("barcelonaqualifier")
private ITeam team;
```

```xml
<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"></bean>

 <bean id="messi" class="com.sampleautowired.beans.Player">
    <property name="number" value="10"></property>
    <property name="name" value="Lionel Messi"></property>
    <!-- <property name="team" ref="barcelona"></property> -->
</bean>

<bean id="team" class="com.sampleautowired.beans.Barcelona">
    <qualifier value="barcelonaqualifier"></qualifier>
</bean>
```

## 3. Alternative of annotations

You can use in xml

```xml
<context:annotation-config/>
```

Instead of 

```xml
<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"></bean>
<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"></bean>
```

or another spring annotations

