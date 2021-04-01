package com.isabel.actividadandroid.movies.filtroMovies.presenter;

import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.movies.filtroMovies.contract.FiltroMovieContract;
import com.isabel.actividadandroid.movies.filtroMovies.model.FiltroMovieModel;

import java.util.ArrayList;

public class FiltroMoviePresenter implements FiltroMovieContract.Presenter {

    private FiltroMovieContract.View filtroVista;
    private FiltroMovieModel filtroMovieModel;
    private String idioma;

    public FiltroMoviePresenter (FiltroMovieContract.View vista, String idioma){
        this.filtroVista = vista;
        this.idioma = idioma;
        this.filtroMovieModel = new FiltroMovieModel(idioma);
    }


    @Override
    public void getMovies(String idIdioma) {
        filtroMovieModel.getMoviesWS(new FiltroMovieContract.Model.OnMovieListener() {
            @Override
            public void onFinished(ArrayList<Movie> movies) {
                filtroVista.success(movies);
            }

            @Override
            public void onFailure(String error) {
                filtroVista.error("Error al traer los datos");
            }
        },idioma);
    }
}
