package com.example.BookmyShowProject.RequestDtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AddShowRequest {

    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName; //Movie name is unique : movie Entity is unqiue
    private Integer theaterId;
}