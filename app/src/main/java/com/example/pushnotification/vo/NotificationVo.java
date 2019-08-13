package com.example.pushnotification.vo;

// create pojo class as (modal) . . . ;
public class NotificationVo {
    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private String contenttye;

    //create constructor to pass data . . . ;
    public NotificationVo(int id , String name , String description , String imageUrl , String contenttye){
        this.id= id ;
        this.name = name ;
        this.description = description ;
        this.imageUrl = imageUrl ;
        this.contenttye = contenttye ;
    }


    // create getter to retreive data from another class . . . .;
    public int getId(){
        return this.id ;
    }
    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getContenttye() {
        return contenttye;
    }
}
