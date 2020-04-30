package com.springpostconstructpredestroy;

import com.springpostconstructpredestroy.beans.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/springpostconstructpredestroy/xml/beans.xml");
        
        Person myPerson = (Person) appContext.getBean("person");

        System.out.println("id: " + myPerson.getId() + ", name: " + myPerson.getName() + ", surname: " + myPerson.getSurname() + ", country: " + myPerson.getCountry().getCity().getName());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
