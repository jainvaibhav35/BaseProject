package com.mail;

/**
 * Created by lin on 29/8/16.
 */

public class B extends OverrideFinal {


    public static void main(String args[]) {
        OverrideFinal of = new B();

    }

    @Override
    void fun() {
        System.out.print("Class B Extends OverrideFinal");
    }

    void fun1() {
        System.out.print("Class B Extends OverrideFinal");
    }
}
