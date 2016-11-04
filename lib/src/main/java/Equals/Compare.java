package Equals;

/**
 * Created by lin on 5/8/16.
 */

public class Compare {

    public static void main(String args[]) {


        new Compare().checkString();

        Employee e1 = new Employee();
        Employee e2 = new Employee();


        e1.setName("Vaibhav");
        e2.setName("Vaibhav");

        e1.setRoll(1);
        e2.setRoll(1);

//        e1 = e2;

        if (e1.equals(e2)) {
            System.out.println("Equals check values");
        }
        if (e1 == e2) {
            System.out.println("== check values");
        }

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

    }

    private void checkString() {

        String one = "Hi";
        String two = "Hi";
        String three = new String("Hi");
        String four = new String("Hi");

        if (one.equals(three)) {
            System.out.println("Equals");
        }

        if (one == three) {
            System.out.println("==");
        }

        System.out.println(one.hashCode());
        System.out.println(two.hashCode());
        System.out.println(three.hashCode());
        System.out.println(four.hashCode());
    }

}
