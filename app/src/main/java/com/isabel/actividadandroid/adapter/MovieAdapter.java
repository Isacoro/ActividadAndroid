package com.isabel.actividadandroid.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.isabel.actividadandroid.R;
import com.isabel.actividadandroid.beans.Movie;
import com.isabel.actividadandroid.movies.listMovies.view.DetalleMovieView;
import com.isabel.actividadandroid.movies.listMovies.view.ListMoviesActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> listMovies;

    public MovieAdapter(ArrayList<Movie> listMovies){
        this.listMovies = listMovies;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView titulo, puntuacion, sinopsis;


        public MovieViewHolder(@NonNull View view) {
            super(view);

            imagen = view.findViewById(R.id.imgImagen);
            titulo = view.findViewById(R.id.txtTitulo);
            puntuacion = view.findViewById(R.id.txtPuntuacion);
            sinopsis = view.findViewById(R.id.txtDescripcion);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie movie = listMovies.get(position);

        holder.titulo.setText(movie.getTitulo());
        holder.puntuacion.setText(movie.getPuntuacion());

        //Para insertar las imágenes
        String url = "https://image.tmdb.org/t/p/original";
        Picasso.get().load(url + movie.getImagen()).into(holder.imagen);

        holder.itemView.setOnClickListener(v -> {
            Intent navegar = new Intent(v.getContext(), DetalleMovieView.class);
            navegar.putExtra("imagen", movie.getImagen());
            navegar.putExtra("sinopsis", movie.getSinopsis());
            v.getContext().startActivity(navegar);
        });
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }
}
