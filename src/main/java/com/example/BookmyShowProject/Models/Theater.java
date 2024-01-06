package com.example.BookmyShowProject.Models;

import com.example.BookmyShowProject.Enums.City;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theater")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private  String name;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private City city;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> seatList = new ArrayList<>();

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

}
