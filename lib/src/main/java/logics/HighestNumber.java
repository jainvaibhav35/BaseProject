package logics;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lin on 4/11/16.
 */

public class HighestNumber {


    private static String resultant = "";
    ArrayList<Integer> numberList = new ArrayList<Integer>();
    ArrayList<Integer> InputnumberList = new ArrayList<Integer>();

    public static void main(String args[]) {

        HighestNumber hn = new HighestNumber();
        hn.createInputList();
        hn.createLargest();
        System.out.print("Resultant is " + resultant);
    }

    public void createLargest() {

        for (int i = 9; i >= 1; i--) {
            for (int j = 0; j < InputnumberList.size(); j++) {
                if ((InputnumberList.get(j) + "").contains(i + "")) {
                    numberList.add(InputnumberList.get(j));
                }
            }
            InputnumberList.removeAll(numberList);
            findHighestthenMerge();
            if (numberList != null) {
                numberList.clear();
            }
        }
    }

    private void findHighestthenMerge() {

        Collections.sort(numberList);
        for (int i = numberList.size() - 1; i >= 0; i--) {
            resultant += numberList.get(i);
        }

    }

    public void createInputList() {
        InputnumberList.add(999);
        InputnumberList.add(2);
        InputnumberList.add(4);
        InputnumberList.add(88);
        InputnumberList.add(78);
        InputnumberList.add(99);
        InputnumberList.add(9);
    }
}
