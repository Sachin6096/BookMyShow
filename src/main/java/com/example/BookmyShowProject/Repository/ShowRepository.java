package com.example.BookmyShowProject.Repository;

import com.example.BookmyShowProject.Models.Movie;
import com.example.BookmyShowProject.Models.Show;
import com.example.BookmyShowProject.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show,Integer> {

    Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);
}
