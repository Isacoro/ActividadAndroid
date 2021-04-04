package com.isabel.actividadandroid.movies.filtroMovies.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.Nullable;

import com.isabel.actividadandroid.BuildConfig;
import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.beans.MovieApiResult;
import com.isabel.actividadandroid.movies.filtroMovies.contract.FiltroMovieContract;
import com.isabel.actividadandroid.retrofit.ApiClient;
import com.isabel.actividadandroid.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FiltroMovieModel implements FiltroMovieContract.Model {

    @Override
    public void getMoviesWS(Context context, final OnMovieListener onMovieListener, String language) {
        ApiClient apiClient = new ApiClient(context);

        final Call<MovieApiResult> request = apiClient.getMoviesLanguage(language);

        request.enqueue(new Callback<MovieApiResult>() {
            @Override
            public void onResponse(Call<MovieApiResult> call, Response<MovieApiResult> response) {
                if (response != null && response.body() != null){
                    onMovieListener.onFinished(new ArrayList<Movie>(response.body().getResults()));
                }
            }

            @Override
            public void onFailure(@Nullable Call<MovieApiResult> call,@Nullable Throwable t) {
                t.printStackTrace();
                onMovieListener.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
