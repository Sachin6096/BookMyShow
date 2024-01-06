package com.example.BookmyShowProject.Services;

import com.example.BookmyShowProject.Models.*;
import com.example.BookmyShowProject.Repository.*;
import com.example.BookmyShowProject.RequestDtos.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;
    public String boookTickets(BookTicketRequest bookTicketRequest) {

        Show show = findRightShow(bookTicketRequest);

        List<ShowSeats> showSeatsList = show.getShowSeats();

        //finding the requested seats and marking them unavailable
        int totalPrice = 0;
        for(ShowSeats showSeats : showSeatsList) {
            if (bookTicketRequest.getRequestedSeatNo().contains(showSeats.getSeatNo())) {
                showSeats.setAvailable(false);
                totalPrice = totalPrice + showSeats.getPrice();
            }
        }

        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        Ticket ticket = Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .theaterAddress(show.getTheater().getAddress())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .user(user)
                .bookedSeats(bookTicketRequest.getRequestedSeatNo().toString())
                .totalPrice(totalPrice)
                .show(show)
                .build();

        show.getTicketList().add(ticket);
        user.getTickets().add(ticket);

        ticketRepository.save(ticket);
        return "Ticket has been booked successfully!";




    }

    private Show findRightShow(BookTicketRequest bookTicketRequest) {

        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Theater theater =theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(),
                                                                bookTicketRequest.getShowTime(),
                                                                movie,theater);

        return show;
    }
}
