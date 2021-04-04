package com.isabel.actividadandroid.movies.listMovies.presenter;

import android.content.Context;

import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.movies.listMovies.contract.ListMoviesContract;
import com.isabel.actividadandroid.movies.listMovies.model.ListMoviesModel;

import java.util.ArrayList;

public class ListMoviesPresenter implements ListMoviesContract.Presenter {

    private ListMoviesModel listMoviesModel;
    private ListMoviesContract.View vista;

    //Constructor donde sólo le voy a mostrar el método view del contrato
    public ListMoviesPresenter(ListMoviesContract.View vista){
        this.vista = vista;
        this.listMoviesModel = new ListMoviesModel();
    }


    @Override
    public void getMovies(Context context) {
        listMoviesModel.getMoviesWS(context, new ListMoviesContract.Model.OnListMoviesListener() {
            @Override
            public void onFinished(ArrayList<Movie> movies) {
                vista.success(movies);
            }

            @Override
            public void onFailure(String error) {
                vista.error("Error al traer los datos");
            }
        });
    }
}

