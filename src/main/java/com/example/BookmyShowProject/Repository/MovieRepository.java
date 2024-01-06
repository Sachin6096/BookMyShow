package com.example.BookmyShowProject.Repository;

import com.example.BookmyShowProject.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieName);
}
