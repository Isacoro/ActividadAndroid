package com.isabel.actividadandroid.movies.listMovies.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.isabel.actividadandroid.R;
import com.isabel.actividadandroid.movies.listMovies.presenter.ListMoviesPresenter;
import com.squareup.picasso.Picasso;

public class DetalleMovieView extends AppCompatActivity {

    private ImageView imagen;
    private TextView sinopsis;

    private FloatingActionButton buttonBack;
    private ListMoviesPresenter listMoviesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_movie_view);

        initComponents();
      //  buttonBack = findViewById(R.id.activityBackToPage);
       /* buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listMoviesPresenter.getMovies();
            }
        });*/

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
    }
}