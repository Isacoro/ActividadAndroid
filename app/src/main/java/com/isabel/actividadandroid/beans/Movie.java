package com.isabel.actividadandroid.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Movie {
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String OVERVIEW = "overview";
    private static final String POSTER_PATH = "poster_path";
    private static final String VOTE_AVERAGE = "vote_average";
    private static final String ORIGINAL_LANGUAGE = "original_language";

    private int id;
    private String titulo;
    private String sinopsis;
    private String imagen;
    private String puntuacion;
    private String idioma;


    //ArrayList para la lista de películas
    public static ArrayList<Movie> getArrayListFromJSON(JSONArray listMovies) {
        ArrayList<Movie> lista = null;

        try {
            if (listMovies != null && listMovies.length() > 0) {
                lista = new ArrayList<Movie>();
            }
            for (int i = 0; i < listMovies.length(); i++) {
                JSONObject json_data = listMovies.getJSONObject(i);
                Movie movie = new Movie();

                movie.setId(json_data.getInt(ID));
                movie.setTitulo(json_data.getString(TITLE));
                movie.setSinopsis(json_data.getString(OVERVIEW));
                movie.setImagen(json_data.getString(POSTER_PATH));
                movie.setPuntuacion(json_data.getString(VOTE_AVERAGE));

                lista.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Array list para el filtro de películas
    public static ArrayList<Movie> getArrayFiltroFromJSON(JSONArray listMovies){
        ArrayList<Movie> lista = null;

        try{
            if (listMovies != null && listMovies.length() > 0){
                lista = new ArrayList<Movie>();
            }
            for(int i = 0; i < listMovies.length(); i++){
                JSONObject json_data = listMovies.getJSONObject(i);
                Movie movie = new Movie();

                movie.setId(json_data.getInt(ID));
                movie.setTitulo(json_data.getString(TITLE));
                movie.setSinopsis(json_data.getString(OVERVIEW));
                movie.setImagen(json_data.getString(POSTER_PATH));
                movie.setIdioma(json_data.getString(ORIGINAL_LANGUAGE));

                lista.add(movie);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        return lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
        
