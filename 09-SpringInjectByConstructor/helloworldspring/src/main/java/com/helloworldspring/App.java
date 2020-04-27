package com.helloworldspring;

import com.helloworldspring.beans.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/helloworldspring/xml/beans.xml");
        
        Person myPerson = (Person) appContext.getBean("person");
        System.out.println(myPerson.getId() + " " + myPerson.getName() + " " + myPerson.getSurname());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
