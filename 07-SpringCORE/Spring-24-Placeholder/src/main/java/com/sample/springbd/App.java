package com.sample.springbd;

import com.sample.beans.Mark;
import com.sample.beans.Player;
import com.sample.service.ServicePlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        Mark mark = new Mark();
        mark.setId(2);
        mark.setName("Mark 2");

        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/sample/xml/beans.xml");

        ServicePlayer sp = (ServicePlayer) appContext.getBean("servicePlayerImpl");
        Player player1 = (Player) appContext.getBean("player1");

        try {
            sp.register(player1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
