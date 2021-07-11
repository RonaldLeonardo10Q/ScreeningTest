package com.example.screeningtest1;

public class EventModel {
    int image;
    String nama,date,desc;

    public EventModel(String nama, String date,String desc,int img) {
        this.nama = nama;
        this.date = date;
        this.desc = desc;
        image = img;
    }

    public EventModel() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
