package com.sample;

import com.sample.beans.Barcelona;
import com.sample.beans.Juventus;
import com.sample.beans.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elija un equipo: 1 - Barcelona, 2 - Juventus");
        int response = sc.nextInt();

        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/sample/xml/beans.xml");
        Player player = (Player) appContext.getBean("player1");

        switch (response) {
            case 1:
                player.setTeam(new Barcelona());
                break;
            case 2:
                player.setTeam(new Juventus());
                break;
            default:
                break;
        }

        System.out.println(player.getName() + " - " + player.getTeam().show() + " - " + player.getShirt().getNumber()+ " - " + player.getShirt().getMark().getName());

        ((ConfigurableApplicationContext) appContext).close();
    }
}
