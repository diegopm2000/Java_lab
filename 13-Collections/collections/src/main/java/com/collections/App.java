package com.collections;

import com.collections.beans.City;
import com.collections.beans.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/collections/xml/beans.xml");
        
        Person myPerson = (Person) appContext.getBean("person");

        String citynames = "";
        for (City city: myPerson.getCountry().getCities()) {
            citynames += city.getName() + "-";
        }

        System.out.println("* id: " + myPerson.getId() + ", name: " + myPerson.getName() + ", surname: " + myPerson.getSurname() + ", country: " + myPerson.getCountry().getName() + ", cities: " + citynames);

        ((ConfigurableApplicationContext) appContext).close();
    }
}
