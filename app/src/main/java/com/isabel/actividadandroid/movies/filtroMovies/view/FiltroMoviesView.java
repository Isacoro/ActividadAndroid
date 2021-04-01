package com.isabel.actividadandroid.movies.filtroMovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.isabel.actividadandroid.R;
import com.isabel.actividadandroid.adapter.MovieAdapter;
import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.movies.filtroMovies.contract.FiltroMovieContract;
import com.isabel.actividadandroid.movies.filtroMovies.presenter.FiltroMoviePresenter;

import java.util.ArrayList;

public class FiltroMoviesView extends AppCompatActivity implements FiltroMovieContract.View {

    private FiltroMoviePresenter filtroMoviePresenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_movies_view);

        Intent navegar = this.getIntent();
        String idioma = navegar.getStringExtra("idioma");

        filtroMoviePresenter = new FiltroMoviePresenter(this, idioma);
        filtroMoviePresenter.getMovies(idioma);
    }

    @Override
    public void success(ArrayList<Movie> listaFiltroMovies) {
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        MovieAdapter adapter = new MovieAdapter(listaFiltroMovies);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

    }
}