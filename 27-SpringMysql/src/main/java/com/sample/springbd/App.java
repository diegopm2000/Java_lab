package com.sample.springbd;

import com.sample.beans.Mark;
import com.sample.service.ServiceMark;
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

        ServiceMark sm = (ServiceMark) appContext.getBean("serviceMarkImpl");

        try {
            sm.register(mark);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
