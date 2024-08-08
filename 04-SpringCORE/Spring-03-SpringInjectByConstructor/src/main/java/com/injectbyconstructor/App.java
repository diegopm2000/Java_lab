package com.injectbyconstructor;

import com.injectbyconstructor.beans.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("com/injectbyconstructor/xml/beans.xml");
        
        Person myPerson = (Person) appContext.getBean("person");
        System.out.println(myPerson.getId() + " " + myPerson.getName() + " " + myPerson.getSurname());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
