package com.abd.receive;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyculerAddapter extends RecyclerView.Adapter<RecyculerAddapter.MyViewHolder> {
    List<APImodel> list;
    Context context;

    public RecyculerAddapter(List<APImodel> list, Context context) {
        this.list = list;
        this.context = context;
    }




    @NonNull
    @Override
    public RecyculerAddapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyculerAddapter.MyViewHolder myViewHolder, int i) {




        Log.d("ssss",list.get(i).getArrCityName()[0]);
        myViewHolder.begin.setText("From  "+list.get(i).getArrCityName()[0]);
        myViewHolder.destination.setText("To   "+list.get(i).getArrCityName()[list.get(i).getArrCityName().length-1]);

        Glide.with(context).load(list.get(i).getLogoCover()).into(myViewHolder.country);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView begin,destination;
        ImageView country;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            begin=itemView.findViewById(R.id.txtBegin);
            destination=itemView.findViewById(R.id.txtDes);
            country=itemView.findViewById(R.id.showImage);
        }
    }
}
