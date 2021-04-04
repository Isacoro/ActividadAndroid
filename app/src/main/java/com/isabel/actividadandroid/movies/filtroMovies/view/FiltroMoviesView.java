package com.isabel.actividadandroid.movies.filtroMovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
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

    private ProgressBar progressBar;

    private String [] elegir = {"Elegir idioma", "Aleman", "Coreano", "Español", "Francés", "Inglés"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_movies_view);

        progressBar = findViewById(R.id.activity_ProgressBar);
        progressBar.setVisibility(View.VISIBLE);

        cargaSpinner();

        Intent navegar = this.getIntent();
        String language = navegar.getStringExtra("language");

        filtroMoviePresenter = new FiltroMoviePresenter(this);
        filtroMoviePresenter.getMovies(this, language);
    }

    @Override
    public void success(ArrayList<Movie> movies) {
        progressBar.setVisibility(View.GONE);

        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

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
                        language = "de-DE";
                        navegar.putExtra("language", language);
                        break;
                    case "Coreano":
                        language = "ko-KO";
                        navegar.putExtra("language", language);
                        break;
                    case "Español":
                        language = "es-ES";
                        navegar.putExtra("language", language);
                        break;
                    case "Francés":
                        language = "fr-FR";
                        navegar.putExtra("language", language);
                        break;
                    case "Inglés":
                        language = "en-EN";
                        navegar.putExtra("language", language);
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