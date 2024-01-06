package com.example.BookmyShowProject.Models;

import com.example.BookmyShowProject.Enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true)
    private String movieName;

    private LocalDate releaseDate;

    private Double rating;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();
}
