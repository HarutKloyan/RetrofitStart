package com.example.retrofitstart;


public class Item {
    int id;
    int albumId;
    String title;
    String url;

    public Item(){

    }
    public Item(int id, int albumId, String title, String url) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
    }
}
