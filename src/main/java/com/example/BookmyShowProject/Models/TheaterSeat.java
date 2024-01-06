package com.example.BookmyShowProject.Models;

import com.example.BookmyShowProject.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theaterSeat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;

}
