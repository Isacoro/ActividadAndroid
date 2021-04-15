package com.isabel.actividadandroid.beans;

import com.google.gson.annotations.SerializedName;

public class Movie {

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
    private String language;


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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


}
        
