package com.example.nouran.movieapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;




public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    ArrayList<Model> contents;
    Context context;


    public MyRecyclerViewAdapter(ArrayList<Model> contents,Context context) {
        this.contents = contents;
        this.context=context;
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,
                parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, final int position) {
        final Model movie = contents.get(position);

        holder.title.setText(movie.title);
        holder.release.setText(movie.release_date);

        Glide.with(context.getApplicationContext()).
                load(contents.get(position).poster_path).
                into(holder.image);


        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,DetailsActivity.class);

                i.putExtra("data",movie);

                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return contents.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title,release;


        public ViewHolder(View itemView) {
            super(itemView);


             image= itemView.findViewById(R.id.image);
             title= itemView.findViewById(R.id.title);
             release=itemView.findViewById(R.id.release);



        }
    }
}

