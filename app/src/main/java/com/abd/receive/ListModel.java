package com.abd.receive;

import android.widget.ImageView;

public class ListModel {
    String begin,dest;
    String imgUrl;

    public ListModel(String begin, String dest,String imgUrl) {
        this.begin = begin;
        this.dest = dest;
        this.imgUrl = imgUrl;
    }

    public String getBegin() {
        return begin;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

   /* public ImageView getCountry() {
        return country;
    }

    public void setCountry(ImageView country) {
        this.country = country;
    }*/
}
