package com.example.nouran.movieapp;

/**
 * Created by Nouran on 3/19/2018.
 */

public class account_model {


    public account_model(String email,String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;

    }

    public account_model() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String name;
    String email;
    String password;




}
