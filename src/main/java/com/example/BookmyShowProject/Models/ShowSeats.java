package com.example.BookmyShowProject.Models;

import com.example.BookmyShowProject.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "showSeats")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean isAvailable;

    private boolean isFoodAttached;

    private Integer price;

    @JoinColumn
    @ManyToOne
    private Show show;
}
