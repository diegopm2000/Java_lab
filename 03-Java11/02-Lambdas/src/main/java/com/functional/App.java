package com.functional;

import com.functional.lambdas.Lambda;

public class App 
{
    public static void main( String[] args )
    {
        Lambda lam = new Lambda();
        lam.test("ODD");
        // lam.test("EVEN");

        lam.sum();
    }
}
