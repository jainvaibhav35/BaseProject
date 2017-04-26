package logics;

/**
 * Created by lin on 29/8/16.
 */

public class MergeLogic {

    int i = 0, k = 0, j = 0;


    public static void main(String args[]) {


        int arr[] = {1, 2, 4, 7, 9, 10, 13};
        int arr1[] = {1, 3, 5, 7, 8, 9, 14, 15};

        int c[] = new int[arr.length + arr1.length];


        if (arr1.length > arr.length) {
            new MergeLogic().merge(arr1, arr, c);
        } else if (arr1.length < arr.length) {
            new MergeLogic().merge(arr, arr1, c);
        } else if (arr1.length == arr.length) {
            new MergeLogic().merge(arr, arr1, c);
        }
    }

    void merge(int Largearr[], int Smallarr[], int c[]) {

        while (i < Largearr.length) {

            if (!(j > Smallarr.length - 1) && !(i > Largearr.length - 1
            )) {

                if (Largearr[i] < Smallarr[j]) {
                    c[k] = Largearr[i];
                    k++;
                    i++;
                } else if (Largearr[i] > Smallarr[j]) {
                    c[k] = Smallarr[j];
                    k++;
                    j++;
                } else if (Largearr[i] == Smallarr[j]) {
                    c[k] = Smallarr[j];
                    k++;
                    j++;
                    i++;
                }
            } else {
                if (j > Smallarr.length - 1) {
                    c[k] = Largearr[i];
                    k++;
                    i++;
                } else {
                    c[k] = Smallarr[j];
                    k++;
                    j++;
                }
            }
        }

        for (int l = 0; l < c.length - 1; l++) {
            System.out.println(c[l]);
        }
    }
}
