package com.example.gamebase;

import android.content.Context;

import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {

    public static final String GAME_KEY = "game_key";

    public Long id;
    public String name;
    public String imageFileName;
    public String console;
    public String description;
    public Integer price;

    public Game(){

    }

    public Game(Long id, String name, String imageFileName, String console, String description, Integer price){
        this.id = id;
        this.name = name;
        this.imageFileName = imageFileName;
        this.console = console;
        this.description = description;
        this.price = price;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageFileName(){
        return imageFileName;
    }

    public String getConsole(){
        return console;
    }

    public void setConsole(String console){
        this.console = console;
    }

    public String getDescription(String description){
        return description;
    }

    public void setDescription(){
        this.description = description;
    }

    public Integer getPrice(Integer price){
        return price;
    }

    public void setPrice(){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageFileName='" + imageFileName + '\'' +
                ", console='" + console + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }




}
