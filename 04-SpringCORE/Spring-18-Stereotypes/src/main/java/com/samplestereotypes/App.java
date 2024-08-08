package com.samplestereotypes;

import com.samplestereotypes.beans.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("com/samplestereotypes/xml/beans.xml");

        Player player = (Player) appContext.getBean("messi");
        System.out.println(player.getName() + " - " + player.getTeam().show() + " - " + player.getNumber());

        /*
        ITeam team1 = (ITeam) appContext.getBean("barcelona");
        System.out.println(team1.show());
        ITeam team2 = (ITeam) appContext.getBean("juventus");
        System.out.println(team2.show());
        */

        ((ConfigurableApplicationContext) appContext).close();
    }
}
