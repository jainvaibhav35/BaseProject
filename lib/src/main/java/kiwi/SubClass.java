package kiwi;

import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.omg.PortableInterceptor.Interceptor;

/**
 * Created by lin on 16/1/17.
 */

public class SubClass extends SuperClass implements Interface {
    @Override
    public void fun() {

    }

    public static void main(String args[]){

        SuperClass sc = new SubClass();

        SuperClass sc1 = new SubSubClass();

//        Interface i1 = new Interface();

//        Interface i2 = new SuperClass();

        Interface i3 = new SubClass();

        Interface i4 = new SubSubClass();

//        SubClass sc = new Interface();


    }
}
