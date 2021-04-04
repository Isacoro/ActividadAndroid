package com.isabel.actividadandroid.movies.filtroMovies.presenter;

import android.content.Context;

import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.movies.filtroMovies.contract.FiltroMovieContract;
import com.isabel.actividadandroid.movies.filtroMovies.model.FiltroMovieModel;

import java.util.ArrayList;

public class FiltroMoviePresenter implements FiltroMovieContract.Presenter {

    private FiltroMovieContract.View filtroVista;
    private FiltroMovieModel filtroMovieModel;

    public FiltroMoviePresenter (FiltroMovieContract.View vista){
        this.filtroVista = vista;
        this.filtroMovieModel = new FiltroMovieModel();
    }


    @Override
    public void getMovies(Context context, String language) {
        filtroMovieModel.getMoviesWS(context, new FiltroMovieContract.Model.OnMovieListener() {
            @Override
            public void onFinished(ArrayList<Movie> movies) {
                filtroVista.success(movies);
            }

            @Override
            public void onFailure(String error) {
                filtroVista.error("Error al traer los datos");
            }
        },language);
    }
}
