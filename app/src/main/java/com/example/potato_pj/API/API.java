package com.example.potato_pj.API;

import com.google.gson.annotations.SerializedName;

public class API {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("img")
    private String img;

    @SerializedName("description")
    private String description;

    @SerializedName("director")
    private String director;

    @SerializedName("actor")
    private String actor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
    @Override
    public String toString(){
        return "{" +
                "id=" + id +
                ", title=" +title +
                ", img=" + img +
                ", description=" + description +
                ", director= " + director +
                ", actor=" + actor +
                "}";
    }
}
