package kiwi;

/**
 * Created by lin on 16/1/17.
 */

public class A implements B.tryInterface, Interface {

    public static void main(String... args) {
        new A().fun();
    }

    @Override
    public void fun() {
        if (new A() instanceof B.tryInterface) {
            System.out.print("Yes");
        }
    }


}
