package com.abd.receive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;


import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    private JsonPlaceHolder jsonPlaceHolderApi;

    RecyclerView recyclerView;
    private RecyculerAddapter adapter;

    private List<ListModel>listModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // textViewResult = findViewById(R.id.text_view_result);

        listModels=new ArrayList<>();

        adapter=new RecyculerAddapter(listModels,this);

        recyclerView=findViewById(R.id.showData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://favorite-holiday.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolder.class);

        //getPosts();
        //getComments();
       getData();
    }

    private void getData() {
        listModels=new ArrayList<>();
        adapter=new RecyculerAddapter(listModels,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Call<List<APImodel>> call=jsonPlaceHolderApi.getModel("BGW","BEY","2019-02-22","1",
                "e","0");

        call.enqueue(new Callback<List<APImodel>>() {
            @Override
            public void onResponse(Call<List<APImodel>> call, Response<List<APImodel>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    Log.d("TTTTTTTTTTTTTTt",response.message()+"fgg"+response.code());
                    return;
                }
                List<APImodel>mod=response.body();
                for(APImodel model:mod){
                    ListModel listModel=new ListModel(model.getArrCityName()[0],model.getArrCityName()[0],model.getLogoCover());

                   /* textViewResult.append(model.getID()+model.getStops()+model.getDepartingAirportName()+
                            model.getDepCityName()+model.getFlightNumber()+model.getTotalDuration()+model.getLogoCover()+model.getLogoCover()
                    +model.getPrice()+model.getAirlineLogo()+model.getAirlineName()+model.getArrAirportName()
                    +model.getArrCityName()+model.getArrDateAndTime()+model.getArrivalAirportName()+model.getDepDateAndTime()
                    +model.getFlightModel());*/

                   Log.d("sese",model.getArrCityName()[0]);
                    listModels.add(listModel);
                    adapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<List<APImodel>> call, Throwable t) {
                Log.d("TTTTTTTTTTTTTTt",t.getMessage())
;
            }
        });
    }

    private void getPosts() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "1");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(4);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call = jsonPlaceHolderApi
                .getComments(3);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Comment> comments = response.body();

                for (Comment comment : comments) {
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Post ID: " + comment.getPostId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Text: " + comment.getBody() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
