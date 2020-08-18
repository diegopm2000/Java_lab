package com.newfeatures;

import com.newfeatures.opts.Demo;
import com.newfeatures.opts.Person;

public class App 
{
    public static void main( String[] args )
    {
        Demo d = new Demo();
        Person per = new Person(1, "John Doe");
        d.isEmpty(per);
        d.isPresent(per);
        Person per2 = null;
        d.isEmpty(per2);
        d.isPresent(per2);
    }
}
