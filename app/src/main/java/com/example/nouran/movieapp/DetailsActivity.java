package com.example.nouran.movieapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    ImageView cover, poster;
    RatingBar rate;
    TextView title, review, date;
    FloatingActionButton favourit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_image);
        favourit = findViewById(R.id.favourit);
        cover = findViewById(R.id.coverIV);
        poster = findViewById(R.id.posterIV);
        title = findViewById(R.id.titleTV);
        review = findViewById(R.id.reviewTV);
        date = findViewById(R.id.dateTV);
        rate = findViewById(R.id.rate);


        final Model x = (Model) getIntent().getSerializableExtra("data");
        if (x == null)
            return;

        Glide.with(this).
                load(x.backdrop_path).
                into(cover);
        Glide.with(this).
                load(x.poster_path).
                into(poster);
        title.setText(x.title);
        review.setText(x.overview);
        date.setText(x.release_date);
        rate.setRating((float) x.vote_average);


        final DatabaseHandlerMovies database = new DatabaseHandlerMovies(this);

       ArrayList<Model> dataMovies=new ArrayList<>();
       dataMovies.addAll(database.getAllMovies());


        final boolean[] flag = {false};
       for (int i=0;i<dataMovies.size();i++){
           if (x.id.equals(dataMovies.get(i).id)){
               flag[0] =true;
           }
       }

       if (flag[0])
           favourit.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));

        favourit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag[0]){
                    database.deleteMovie(x);
                    flag[0] =false;
                    favourit.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
                }else {
                    database.addMovie(x);
                    flag[0] =true;
                    favourit.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
                }

            }
        });

//        if (x==1)

//        poster=findViewById(R.id.poster);
//        rating=findViewById(R.id.rating);
//        trailer=findViewById(R.id.trailer);


    }

    public void back(View view) {
        finish();
    }
}
