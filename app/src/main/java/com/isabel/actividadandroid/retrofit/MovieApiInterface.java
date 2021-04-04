package com.isabel.actividadandroid.retrofit;

import com.isabel.actividadandroid.beans.MovieApiResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiInterface {

    @GET("movie/popular?api_key=efccdf33f1effa49b2cd1e82a48f2c21&language=es-ES&page=1")
    Call<MovieApiResult> getMovies();

    @GET("movie/popular?api_key=efccdf33f1effa49b2cd1e82a48f2c21&language=")
    Call<MovieApiResult> getMoviesLanguage(@Query("with_language") String idioma);
}