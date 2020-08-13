# Required Annotation

Used to mark attributes as required in our beans

First, in beans.xml we add the next bean annotation, to enable the recognition of the @Required annotation

```xml
<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"></bean>
```

And in our class, in the setMethod of a property, we can use the @Required annotation

```java
public class Player {

    private int number;
    private String name;
    private ITeam team;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ITeam getTeam() {
        return team;
    }

    @Required()
    public void setTeam(ITeam team) {
        this.team = team;
    }
}
```

And, when executing the App:

```shell
ADVERTENCIA: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'messi' defined in class path resource [com/samplerequired/xml/beans.xml]: Initialization of bean failed; nested exception is org.springframework.beans.factory.BeanInitializationException: Property 'team' is required for bean 'messi'
Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'messi' defined in class path resource [com/samplerequired/xml/beans.xml]: Initialization of bean failed; nested exception is org.springframework.beans.factory.BeanInitializationException: Property 'team' is required for bean 'messi'
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:603)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:882)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:878)
```