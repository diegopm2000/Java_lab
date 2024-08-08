package com.springlifecycle;

import com.springlifecycle.beans.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("com/springlifecycle/xml/beans.xml");
        
        Person myPerson = (Person) appContext.getBean("person");

        System.out.println("id: " + myPerson.getId() + ", name: " + myPerson.getName() + ", surname: " + myPerson.getSurname() + ", country: " + myPerson.getCountry().getCity().getName());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
