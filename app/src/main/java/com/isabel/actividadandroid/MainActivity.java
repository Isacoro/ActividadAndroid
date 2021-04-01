package com.isabel.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.isabel.actividadandroid.movies.listMovies.view.ListMoviesActivity;

public class MainActivity extends AppCompatActivity {
    private static final int SCREEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() { // Interface
                    @Override
                    public void run() {
                        // Cargar la 2ª pantalla
                        Intent navegar = new Intent(
                                getBaseContext(), ListMoviesActivity.class);
                        startActivity(navegar);
                    }
                }
                , 4000
        );
    }
}