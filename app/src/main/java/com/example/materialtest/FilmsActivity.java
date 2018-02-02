package com.example.materialtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class FilmsActivity extends AppCompatActivity {
    public static final String FILM_NAME="film_name";
    public static final String FILM_IMAGE_ID="film_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);
        Intent intent=getIntent();
        String filmName=intent.getStringExtra(FILM_NAME);
        int filmImageId=intent.getIntExtra(FILM_IMAGE_ID,0);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView filmImageView=(ImageView)findViewById(R.id.film_image_view);
        TextView filmContentText=(TextView)findViewById(R.id.film_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(filmName);
        Glide.with(this).load(filmImageId).into(filmImageView);
        String filmContent=generateFilmContent(filmName);
        filmContentText.setText(filmContent);
    }

    private String generateFilmContent(String filmName) {
        StringBuilder filmContent=new StringBuilder();
        for(int i=0;i<500;i++){
            filmContent.append(filmName);
        }
        return filmContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
