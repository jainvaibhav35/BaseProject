package tryInterface;

/**
 * Created by lin on 11/8/16.
 */

public class TryInterface implements B.ABC {


    @Override
    public void fun() {
        System.out.println("Callback");
    }
}
