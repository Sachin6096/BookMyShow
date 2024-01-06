package com.example.BookmyShowProject.Transformers;

import com.example.BookmyShowProject.Models.Movie;
import com.example.BookmyShowProject.RequestDtos.AddMovieRequest;
import lombok.Data;


public class MovieTransformer {

    public static Movie converAddRequestToMovie(AddMovieRequest addMovieRequest)
    {
        Movie movie = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .rating(addMovieRequest.getRating())
                .releaseDate(addMovieRequest.getReleaseDate())
                .genre(addMovieRequest.getGenre()).build();
        return movie;
    }
}
