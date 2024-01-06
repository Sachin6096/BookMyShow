package com.example.BookmyShowProject.Services;

import com.example.BookmyShowProject.Enums.SeatType;
import com.example.BookmyShowProject.Models.Theater;
import com.example.BookmyShowProject.Models.TheaterSeat;
import com.example.BookmyShowProject.Repository.TheaterRepository;
import com.example.BookmyShowProject.RequestDtos.AddTheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheater(AddTheaterRequest addTheaterRequest) {

        Theater theater = Theater.builder()
                .name(addTheaterRequest.getName())
                .address(addTheaterRequest.getAddress())
                .city(addTheaterRequest.getCity()).build();


        createTheaterSeats(theater,addTheaterRequest);

        return "Theater ans its seats has been successfully added!";

    }

    public void createTheaterSeats(Theater theater,AddTheaterRequest addTheaterRequest)
    {
        int classicSeats = addTheaterRequest.getNoOfClassicSeats();
        int premiumSeats = addTheaterRequest.getNoOfPremiumSeats();
        int seatsPerRow = addTheaterRequest.getSeatsPerRow();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();
        int row = 0;
        char ch = 'A';

        for(int i = 1; i <= classicSeats;i++)
        {
            if(i%seatsPerRow == 1)
            {
                row++;
                ch= 'A';
            }
            String seatNo = row + "" + ch;
            ch++;
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater).build();

            theaterSeatList.add(theaterSeat);
        }

        ch = 'A';
        for(int i = 1; i <= premiumSeats;i++)
        {
            if(i % seatsPerRow == 1)
            {
                row++;
                ch = 'A';
            }
            String seatNo = row + "" + ch;
            ch++;
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater).build();

            theaterSeatList.add(theaterSeat);
        }

        //bi-directional mapping
        theater.setSeatList(theaterSeatList);
        theaterRepository.save(theater);

    }
}
