package com.example.BookmyShowProject.Services;

import com.example.BookmyShowProject.Models.Movie;
import com.example.BookmyShowProject.Repository.MovieRepository;
import com.example.BookmyShowProject.RequestDtos.AddMovieRequest;
import com.example.BookmyShowProject.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest addMovieRequest) throws Exception
    {
        Movie movie = MovieTransformer.converAddRequestToMovie(addMovieRequest);
        movieRepository.save(movie);

        return "Movie has been successfully saved!";
    }
}
