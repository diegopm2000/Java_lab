package com.springreference;

import com.springreference.beans.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/springreference/xml/beans.xml");
        
        // Person myPerson = (Person) appContext.getBean("person");
        
        // Referencing using alias
        // Person myPerson = (Person) appContext.getBean("personBean");
        // Referencing using name of the bean
        Person myPerson = (Person) appContext.getBean("personBeanAlt");


        System.out.println("* id: " + myPerson.getId() + ", name: " + myPerson.getName() + ", surname: " + myPerson.getSurname() + ", country: " + myPerson.getCountry().getName() + ", city: " + myPerson.getCountry().getCity().getName());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
