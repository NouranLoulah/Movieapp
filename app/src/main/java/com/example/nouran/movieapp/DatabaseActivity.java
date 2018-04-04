package com.example.nouran.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {
    ArrayList<Model> data;
    //  ProgressBar progress;
    TextView text;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_database);
        RecyclerView myrecycle = findViewById(R.id.recycleview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        myrecycle.setLayoutManager(layoutManager);
//        progress=view.findViewById(R.id.progress);
        text =findViewById(R.id.text);
        data=new ArrayList<>();


        adapter = new MyRecyclerViewAdapter(data,myrecycle.getContext());
        myrecycle.setAdapter(adapter);

        final DatabaseHandlerMovies database = new DatabaseHandlerMovies(this);

        ArrayList<Model> dataMovies=new ArrayList<>();
        data.addAll(database.getAllMovies());
        adapter.notifyDataSetChanged();
//        sentrequest();



    }

}
