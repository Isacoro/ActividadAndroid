package com.isabel.actividadandroid.movies.listMovies.model;

import android.content.Context;

import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.beans.MovieApiResult;
import com.isabel.actividadandroid.movies.listMovies.contract.ListMoviesContract;
import com.isabel.actividadandroid.retrofit.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMoviesModel implements ListMoviesContract.Model{


    @Override
    public void getMoviesWS(Context context, OnListMoviesListener onListMoviesListener) {
        ApiClient apiClient = new ApiClient(context);

        final Call<MovieApiResult> request = apiClient.getMovies();

        request.enqueue(new Callback<MovieApiResult>(){

            @Override
            public void onResponse(Call<MovieApiResult> call, Response<MovieApiResult> response) {
                if (response != null && response.body() != null) {
                    onListMoviesListener.onFinished(new ArrayList<Movie>(response.body().getResults()));
                }
            }

            @Override
            public void onFailure(Call<MovieApiResult> call, Throwable t) {
                t.printStackTrace();
                onListMoviesListener.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
