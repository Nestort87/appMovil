package com.example.entregareto.models;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;

public class User extends Application {
    public String   name;
    public String   surName;
    public String   imageProfile;
    public String   email;
    public Long     phone;
    public String   password;
    public String   gender;
    public int      age;


    public User() {
        this.name           = "";
        this.surName        = "";
        this.imageProfile   = "";
        this.email          = "";
        this.phone          = 0L;
        this.password       = "";
        this.gender         = "";
        this.age            = 0;

    }

    public User(String name, String surName, String imageProfile, String email, Long phone, String password, String gender, int age) {
        this.name           = name;
        this.surName        = surName;
        this.imageProfile   = imageProfile;
        this.email          = email;
        this.phone          = phone;
        this.password       = password;
        this.gender         = gender;
        this.age            = age;

    }

    public void setDefaultData(){
        this.name           = "";
        this.surName        = "";
        this.imageProfile   = "";
        this.email          = "";
        this.phone          = 0L;
        this.password       = "";
        this.gender         = "";
        this.age            = 0;

    }

    public void copyData(User newData){
        this.name           = newData.name;
        this.surName        = newData.surName;
        this.imageProfile   = newData.imageProfile;
        this.email          = newData.email;
        this.phone          = newData.phone;
        this.password       = newData.password;
        this.gender         = newData.gender;
        this.age            = newData.age;

    }

    public String objetcToJSON (){
        Log.e("msg", "Se ha ingresado a JSON  " );

        String jsonData = new Gson().toJson(this);
        Log.e("msg", "User to json: " + jsonData);

        return jsonData;

    }

}
