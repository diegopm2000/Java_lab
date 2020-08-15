package com.sampleautowired;

import com.sampleautowired.beans.Player;
import com.sampleautowired.interfaces.ITeam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/sampleautowired/xml/beans.xml");

        Player player = (Player) appContext.getBean("messi");
        System.out.println(player.getName() + " - " + player.getTeam().show() + " - " + player.getNumber());

        // ITeam team1 = (ITeam) appContext.getBean("barcelona");
        // System.out.println(team1.show());
        // ITeam team2 = (ITeam) appContext.getBean("juventus");
        // System.out.println(team2.show());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
