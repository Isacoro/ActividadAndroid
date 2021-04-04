package com.isabel.actividadandroid.retrofit;

import android.content.Context;

import com.isabel.actividadandroid.BuildConfig;
import com.isabel.actividadandroid.beans.MovieApiResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private Retrofit retrofit;
    private Context context;

    public ApiClient(Context context){
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Nos hace el parseo
                .build();
    }

    public Call<MovieApiResult> getMovies(){
        MovieApiInterface service = retrofit.create(MovieApiInterface.class);
        return service.getMovies();
    }
}
