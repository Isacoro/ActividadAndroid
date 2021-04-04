package com.isabel.actividadandroid.movies.filtroMovies.contract;

import android.content.Context;

import com.isabel.actividadandroid.beans.Movie;

import java.util.ArrayList;

public interface FiltroMovieContract{

    //Método de la vista. Acceso o error.
    interface View{
        void success(ArrayList<Movie> listaFiltroMovies);
        void error(String message);
    }

    //Método del presentador. Devolver películas
    interface Presenter{
        void getMovies(Context context, String idioma);
    }

    //Devuelve las películas desde el servidor
    public interface Model{
        //Tiene que mandar el callback (camino de vuelta) que es OnListMoviesListener
        void getMoviesWS(Context context, OnMovieListener onMovieListener, String idioma);

        //Instancia para el modelo. Me dice si ha ido bien o mal la ejecución
        interface OnMovieListener{
            void onFinished(ArrayList<Movie> movies);
            void onFailure(String error);
        }
    }
}
