package com.example.materialtest;

public class Films {
    private String name;
    private int imageId;
    public Films(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
