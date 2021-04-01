package com.isabel.actividadandroid.movies.listMovies.presenter;

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


    //Implemento el método Presenter de la interface
    @Override
    public void getMovies() {
        //Le pido que me dé las películas pasándole como dato por dónde
        listMoviesModel.getMoviesWS(new ListMoviesContract.Model.OnListMoviesListener() {

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

