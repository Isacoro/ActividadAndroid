package com.isabel.actividadandroid.movies.listMovies.view;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.isabel.actividadandroid.R;
import com.isabel.actividadandroid.adapter.MovieAdapter;
import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.movies.filtroMovies.view.FiltroMoviesView;
import com.isabel.actividadandroid.movies.listMovies.contract.ListMoviesContract;
import com.isabel.actividadandroid.movies.listMovies.presenter.ListMoviesPresenter;

import java.util.ArrayList;

public class ListMoviesActivity extends AppCompatActivity implements ListMoviesContract.View {

    //Instancio a:
    private ListMoviesPresenter listMoviesPresenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;

    private ProgressBar progressBar;


    private String [] elegir = {"Elegir idioma", "Alemán", "Coreano", "Español", "Francés", "Inglés"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);

        progressBar = findViewById(R.id.activity_ProgressBar);
        progressBar.setVisibility(View.VISIBLE);

        listMoviesPresenter = new ListMoviesPresenter(this);
        listMoviesPresenter.getMovies(this);

        cargaSpinner();
    }



    //Implemento los métodos de ListMoviesContract
    @Override
    public void success(ArrayList<Movie> movies) {
        progressBar.setVisibility(View.GONE);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        //Declaro el adaptador
        MovieAdapter adapter = new MovieAdapter(movies);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    private void cargaSpinner() {
        Spinner spinner = findViewById(R.id.spinnerFiltro);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, elegir);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelected(false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String idioma = parent.getItemAtPosition(position).toString();
                String language;
                Intent navegar = new Intent(getBaseContext(), FiltroMoviesView.class);

                switch(idioma){
                    case "Elegir idioma":
                        return;
                    case "Alemán":
                        language = "de";
                        navegar.putExtra("original_language", language);
                        break;
                    case "Coreano":
                        language = "ko";
                        navegar.putExtra("original_language", language);
                        break;
                    case "Español":
                        language = "es";
                        navegar.putExtra("original_language", language);
                        break;
                    case "Francés":
                        language = "fr";
                        navegar.putExtra("original_language", language);
                        break;
                    case "Inglés":
                        language = "en";
                        navegar.putExtra("original_language", language);
                        break;
                    default:
                        break;
                }
                Toast.makeText(parent.getContext(), idioma, Toast.LENGTH_LONG).show();
                startActivity(navegar);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Selecciona un idioma", Toast.LENGTH_LONG).show();
            }
        });
    }
}

