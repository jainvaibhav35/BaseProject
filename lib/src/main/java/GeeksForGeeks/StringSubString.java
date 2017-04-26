package GeeksForGeeks;

/**
 * Created by lin on 30/8/16.
 */

public class StringSubString {

    String mainStr = "GeeksForGeeks";
    String strToBeMatched = "Gks";
    int noOfOccurence = 0;
    int strToBeMatchedCounter = 0;


    char strCharArray[] = mainStr.toCharArray();
    char subStrCharArray[] = strToBeMatched.toCharArray();

    public void compare() {
        for (int i = 0; i < strCharArray.length; i++) {
            if (strCharArray[i] == subStrCharArray[strToBeMatchedCounter]){

            }
        }
    }
}
