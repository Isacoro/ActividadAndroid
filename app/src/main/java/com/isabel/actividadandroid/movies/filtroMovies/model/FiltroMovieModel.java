package com.isabel.actividadandroid.movies.filtroMovies.model;

import android.os.AsyncTask;

import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.movies.filtroMovies.contract.FiltroMovieContract;
import com.isabel.actividadandroid.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FiltroMovieModel implements FiltroMovieContract.Model {

    private String URL = "https://api.themoviedb.org/3/movie/popular?api_key=efccdf33f1effa49b2cd1e82a48f2c21&language=es-ES&page=1";

    private ArrayList<Movie> listaFiltroMovies;
    private OnMovieListener onMovieListener;
    private String idioma;

   public FiltroMovieModel(String idioma){
       this.idioma = idioma;
   }

    @Override
    public void getMoviesWS(OnMovieListener onMovieListener, String idioma) {
        this.onMovieListener = onMovieListener;
        this.idioma = idioma;

        TrabajandoEnApi hilo = new TrabajandoEnApi(idioma);
        hilo.execute();
    }


    class TrabajandoEnApi extends AsyncTask<String, Integer, Boolean> {
        private String idioma;

        //Constructor
        public TrabajandoEnApi(String idioma){
            this.idioma = idioma;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            //Comunicarme con el servidor
            Post post = new Post();

            //Traemos los datos en JSONObject
            try {
                JSONObject objectMovies = post.getServerDataGetObject(URL + idioma);
                JSONArray listMovies = objectMovies.getJSONArray("results");
                listaFiltroMovies = Movie.getArrayListFromJSON(listMovies);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean respuesta) {
            if(respuesta){
                if(listaFiltroMovies != null && listaFiltroMovies.size()>0){
                    onMovieListener.onFinished(listaFiltroMovies);
                }else{
                    onMovieListener.onFailure("Error al traer los datos del servidor");
                }
            }
        }
    }
}
