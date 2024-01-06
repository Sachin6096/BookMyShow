package com.example.BookmyShowProject.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private LocalDate showDate;

    private LocalTime showTime;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeats> showSeats = new ArrayList<>();

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();
}
