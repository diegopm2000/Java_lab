package com.springwithannotations;

import com.springwithannotations.beans.AppConfig;
import com.springwithannotations.beans.World;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        // ApplicationContext appContext = new ClassPathXmlApplicationContext("com/springwithannotations/xml/beans.xml");
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Alternative using the Class
        World myWorld = (World) appContext.getBean(World.class);
        System.out.println(myWorld.getGreetings());

        // Alternative using the xml configuration id of the bean
        World mySecondWorld = (World) appContext.getBean("world");
        System.out.println(mySecondWorld.getGreetings());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
