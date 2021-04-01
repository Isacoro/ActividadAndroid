package com.isabel.actividadandroid.movies.listMovies.contract;

import com.isabel.actividadandroid.beans.Movie;

import java.util.ArrayList;

public interface ListMoviesContract {
    //Método de la vista. Acceso o error.
    interface View{
        void success(ArrayList<Movie> movies);
        void error(String message);
    }

    //Método del presentador. Devolver películas
    interface Presenter{
        void getMovies();
    }

    //Devuelve las películas desde el servidor
    public interface Model{
        //Tiene que mandar el callback (camino de vuelta) que es OnListMoviesListener
        void getMoviesWS(OnListMoviesListener onListMoviesListener);
        //Instancia para el modelo. Me dice si ha ido bien o mal la ejecución
        interface OnListMoviesListener{
            void onFinished(ArrayList<Movie> movie);
            void onFailure(String error);
        }
    }
}

