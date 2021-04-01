package com.isabel.actividadandroid.movies.listMovies.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


    private String [] elegir = {" ", "Aleman", "Coreano", "Español", "Francés", "Inglés"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);

        listMoviesPresenter = new ListMoviesPresenter(this);
        listMoviesPresenter.getMovies();

        cargaSpinner();
    }

    //Implemento los métodos de ListMoviesContract
    @Override
    public void success(ArrayList<Movie> movies) {
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
                String idIdioma = null;
                Intent navegar = new Intent(getBaseContext(), FiltroMoviesView.class);

                switch(idioma){
                    case " ":
                        return;
                    case "Alemán":
                        idIdioma = "de";
                        navegar.putExtra("idIdioma", idIdioma);
                        break;
                    case "Coreano":
                        idIdioma = "ko";
                        navegar.putExtra("idIdioma", idIdioma);
                        break;
                    case "Español":
                        idIdioma = "es";
                        navegar.putExtra("idIdioma", idIdioma);
                        break;
                    case "Francés":
                        idIdioma = "fr";
                        navegar.putExtra("idIdioma", idIdioma);
                        break;
                    case "Inglés":
                        idIdioma = "en";
                        navegar.putExtra("idIdioma", idIdioma);
                        break;
                    default:
                        break;
                }
                Toast.makeText(parent.getContext(), idioma, Toast.LENGTH_SHORT).show();
                startActivity(navegar);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Selecciona un idioma", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

