package com.example.engidiom.DB;

import java.util.List;

public class IdiomCard {


    private String arrr;
    private String sDescription;
    private  String urls;
    private int image;

    public IdiomCard( String arrr, String sDescription, String urls, int image) {

        this.arrr = arrr;
        this.sDescription = sDescription;
        this.urls = urls;
        this.image = image;
    }



    public String getArrr() {
        return arrr;
    }

    public void setArrr(String arrr) {
        this.arrr = arrr;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "IdiomCard{" +

                ", arrr='" + arrr + '\'' +
                ", sDescription='" + sDescription + '\'' +
                ", urls='" + urls + '\'' +
                ", image=" + image +
                '}';
    }
}
