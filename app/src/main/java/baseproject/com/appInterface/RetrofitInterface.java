package baseproject.com.appInterface;

import baseproject.com.beans.PostRequest.Example;
import baseproject.com.beans.StackOverflowQuestions;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lin on 2/8/16.
 */

public interface RetrofitInterface {

    // Get Request
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags);

    // Post Request
    @FormUrlEncoded
    @POST("/contentaggregate/Services/edition_and_category")
    Call<Example> hitService(@Field("userId") String userId);
}
