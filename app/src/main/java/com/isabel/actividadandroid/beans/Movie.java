package com.isabel.actividadandroid.beans;

import com.google.gson.annotations.SerializedName;

public class Movie {
//    private static final String ID = "id";
//    private static final String TITLE = "title";
//    private static final String OVERVIEW = "overview";
//    private static final String POSTER_PATH = "poster_path";
//    private static final String VOTE_AVERAGE = "vote_average";
//    private static final String ORIGINAL_LANGUAGE = "original_language";


    private int id;
    @SerializedName("title")
    private String titulo;
    @SerializedName("overview")
    private String sinopsis;
    @SerializedName("poster_path")
    private String imagen;
    @SerializedName("vote_average")
    private String puntuacion;
    @SerializedName("original_language")
    private String idioma;


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
        
