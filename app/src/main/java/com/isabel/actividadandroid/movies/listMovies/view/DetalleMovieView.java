package com.isabel.actividadandroid.movies.listMovies.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.isabel.actividadandroid.R;
import com.isabel.actividadandroid.movies.filtroMovies.contract.FiltroMovieContract;
import com.isabel.actividadandroid.movies.listMovies.presenter.ListMoviesPresenter;
import com.squareup.picasso.Picasso;

public class DetalleMovieView extends AppCompatActivity {

    private ImageView imagen;
    private TextView sinopsis;

    private FloatingActionButton buttonBack, buttonFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_movie_view);

        initComponents();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleMovieView.this, ListMoviesActivity.class);
                startActivity(intent);
            }
        });

        buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonFavorite.setColorFilter(Color.RED);
                buttonFavorite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonFavorite.setColorFilter(Color.WHITE);
                    }
                });
            }
        });

        Intent intent = getIntent();
        String image = intent.getStringExtra("imagen");
        String sinop = intent.getStringExtra("sinopsis");

        sinopsis.setText(sinop);
        String url = "https://image.tmdb.org/t/p/original";
        Picasso.get().load(url + image).into(imagen);
    }

    public void initComponents() {
        imagen = findViewById(R.id.imgImagen);
        sinopsis = findViewById(R.id.txtDescripcion);
        sinopsis.setMovementMethod(new ScrollingMovementMethod());
        buttonBack = findViewById(R.id.activityBackToPage);
        buttonFavorite = findViewById(R.id.activityFavorite);


    }
}