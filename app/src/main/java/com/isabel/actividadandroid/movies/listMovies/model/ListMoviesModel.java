package com.isabel.actividadandroid.movies.listMovies.model;

import android.os.AsyncTask;

import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.movies.listMovies.contract.ListMoviesContract;
import com.isabel.actividadandroid.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListMoviesModel implements ListMoviesContract.Model{

    private String URL = "https://api.themoviedb.org/3/movie/popular?api_key=efccdf33f1effa49b2cd1e82a48f2c21&language=es-ES&page=1";
    private ArrayList<Movie> listaArray;
    OnListMoviesListener onListMoviesListener;


    @Override
    public void getMoviesWS(OnListMoviesListener onListMoviesListener) {
        this.onListMoviesListener = onListMoviesListener;
        TrabajandoEnApi hilo = new TrabajandoEnApi();
        hilo.execute();
    }

    class TrabajandoEnApi extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            //Comunicarme con el servidor
            Post post = new Post();

            //Traemos los datos en JSONObject
            try {
                JSONObject objectMovies = post.getServerDataGetObject(URL);
                JSONArray listMovies = objectMovies.getJSONArray("results");
                listaArray = Movie.getArrayListFromJSON(listMovies);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean respuesta){
            if(respuesta){
                if(listaArray != null && listaArray.size() > 0){
                    onListMoviesListener.onFinished(listaArray);
                }
            }else{
                onListMoviesListener.onFailure("Error al traer los datos del servidor");
            }
        }
    }
}
