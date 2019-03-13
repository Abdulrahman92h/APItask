package com.abd.receive;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userid") int userId);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);


    @GET("/api/orders/oneway")
    Call<List<APImodel>> getModel(
            @Query("from") String from,
            @Query("to") String to,
            @Query("data") String data,
            @Query("adt") String adt,
            @Query("type") String type,
            @Query("chd") String chd);

}
