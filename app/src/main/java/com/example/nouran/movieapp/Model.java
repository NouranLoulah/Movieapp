package com.example.nouran.movieapp;

import java.io.Serializable;

/**
 * Created by Nouran on 3/15/2018.
 */

public class Model implements Serializable{
    int movie1;
    String id;
    double vote_average;
    String title;
    String poster_path;
    String backdrop_path;
    String overview;
    String release_date;

    public Model(String id, double vote_average, String title, String poster_path, String backdrop_path, String overview, String release_date) {
        this.id = id;
        this.vote_average = vote_average;
        this.title = title;
        this.poster_path = "http://image.tmdb.org/t/p/w500"+poster_path;
        this.backdrop_path = "http://image.tmdb.org/t/p/w500"+backdrop_path;
        this.overview = overview;
        this.release_date = release_date;
    }

    //from the data base
    public Model(int type,String id, double vote_average, String title, String poster_path, String backdrop_path, String overview, String release_date) {
        this.id = id;
        this.vote_average = vote_average;
        this.title = title;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.release_date = release_date;
    }












}
