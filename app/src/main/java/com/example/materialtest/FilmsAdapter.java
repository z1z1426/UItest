package com.example.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.materialtest.Films;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder>{
    private List<Films>mFilmsList;
    private Context mContext;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView filmImage;
        TextView filmName;
        public  ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            filmImage=(ImageView)view.findViewById(R.id.film_image);
            filmName=(TextView)view.findViewById(R.id.film_name);
        }
    }
    public FilmsAdapter(List<Films> filmsList){
        mFilmsList=filmsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.films_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Films films=mFilmsList.get(position);
                Intent intent=new Intent(mContext,FilmsActivity.class);
                intent.putExtra(FilmsActivity.FILM_NAME,films.getName());
                intent.putExtra(FilmsActivity.FILM_IMAGE_ID,films.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Films films=mFilmsList.get(position);
        holder.filmName.setText(films.getName());
        Glide.with(mContext).load(films.getImageId()).into(holder.filmImage);
    }

    @Override
    public int getItemCount() {
        return mFilmsList.size();
    }
}
