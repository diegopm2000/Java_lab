package com.helloworldspring;

import com.helloworldspring.beans.World;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/helloworldspring/xml/beans.xml");
        World myWorld = (World) appContext.getBean(World.class);

        System.out.println(myWorld.getGreetings());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
