package logics;

/**
 * Created by lin on 13/1/17.
 */

public class Pattern {

    int arr[] = {2, 3, 6, 4, 7};
    int highestNumber = 7;
    int a = 8 ;

    public static void main(String[] args) {

        new Pattern().fun2();

    }

    private void fun() {
        System.out.println("Start time is " + System.currentTimeMillis());
        for (int i = 0; highestNumber > 0; i++) {

            if (arr[i] < highestNumber) {
                System.out.print(" ");
            } else {
                System.out.print("*");
            }

            if (i == arr.length - 1) {
                i = -1;
                highestNumber--;
                System.out.print("\n");
            }
        }
        System.out.println("End time is " + System.currentTimeMillis());
    }


    private void fun2() {
        System.out.println("Start time is " + System.currentTimeMillis());
//        for (;highestNumber > 0; highestNumber--) {
        while (highestNumber > 0) {
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] < highestNumber) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.print("\n");
            highestNumber--;
        }
        System.out.println("End time is " + System.currentTimeMillis());
    }

    public void compare(){
    }

}
