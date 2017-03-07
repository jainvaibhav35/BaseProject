package com.mail;

/**
 * Created by lin on 23/9/16.
 */

public class StaticOverloading {

    public static void fun(int a) {

        System.out.print("Value is " + a);

    }

    public static void main(String arg[]) {

        new StaticOverloading().fun();
        new StaticOverloading().fun(1);
    }

    public void fun() {
        System.out.print("Value is ");
    }
}
