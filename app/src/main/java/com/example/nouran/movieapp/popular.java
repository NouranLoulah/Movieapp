package com.example.nouran.movieapp;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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
import java.util.List;

/**
 * Created by Nouran on 3/15/2018.
 */

public class popular extends Fragment {
    ArrayList<Model> data;
//    ProgressBar progress;
    TextView text;
    MyRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular,
                container, false);

        RecyclerView myrecycle = view.findViewById(R.id.recycleview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        myrecycle.setLayoutManager(layoutManager);
//        progress=view.findViewById(R.id.progress);
        text =view.findViewById(R.id.text);
         data=new ArrayList<>();


        adapter = new MyRecyclerViewAdapter(data,getContext());
        myrecycle.setAdapter(adapter);

        sentrequest();


        return view ;
    }
    public  void sentrequest(){

        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url ="http://api.themoviedb.org/3/discover/movie??sort_by=POPULARITY.desc&api_key=50bce7edbac33ed4f4c7757ee875026d";
//        progress.setVisibility(View.VISIBLE);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
//                        progress.setVisibility(View.GONE);

                        // Display the first 500 characters of the response string.
//                        text.setText("Response is: "+ response.substring(0,500));
                        extractJson(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                progress.setVisibility(View.GONE);
                text.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
    private void extractJson(String response){
        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray results = jsonResponse.getJSONArray("results");


            for (int i =0;i<results.length();i++){

                JSONObject object=results.getJSONObject(i);

                String id=object.getString("id");
                double vote_average=object.getDouble("vote_average");
                String title=object.getString("title");
                String poster_path=object.getString("poster_path");
                String backdrop_path=object.getString("backdrop_path");
                String overview=object.getString("overview");
                String release_date=object.getString("release_date");



                Model movie = new Model(id,vote_average,
                        title,poster_path,backdrop_path,overview,release_date);

                data.add(movie);
            }
            adapter.notifyDataSetChanged();




        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
