# Spring Placeholder

Adding configuration from files using placeholder

## 1. Configuration in beans.xml

```xml
<context:property-placeholder location="classpath:application.properties"/>

<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="${driver}"/>
    <property name="url" value="${url}"/>
    <property name="username" value="${username}"/>
    <property name="password" value="${password}"/>
</bean>
```

## 2. Properteis file

Located at resources folder

```properties
username = sample_user
password = password
url = jdbc:mysql://localhost:3306/sample_db
driver = com.mysql.cj.jdbc.Driver
```