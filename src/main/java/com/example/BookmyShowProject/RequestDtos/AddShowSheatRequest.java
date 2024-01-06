package com.example.BookmyShowProject.RequestDtos;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AddShowSheatRequest {

    private Integer showId;

    private Integer priceOfClassicSeats;

    private Integer priceOfPremiumSeats;

}
