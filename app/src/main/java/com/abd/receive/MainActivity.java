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

    private List<APImodel>listModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    Log.d("Tag",response.message()+" "+response.code());
                    return;
                }
                List<APImodel>mod=response.body();
                for(APImodel model:mod){
                    model.getArrCityName();
                    model.getLogoCover();
                    listModels.add(model);
                    adapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<List<APImodel>> call, Throwable t) {
                Log.d("Tag",t.getMessage());
            }
        });
    }

}
