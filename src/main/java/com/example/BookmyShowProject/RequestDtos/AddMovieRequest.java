package com.example.BookmyShowProject.RequestDtos;

import com.example.BookmyShowProject.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {

    private String movieName;

    private LocalDate releaseDate;

    private Double rating;

    private Genre genre;
}
