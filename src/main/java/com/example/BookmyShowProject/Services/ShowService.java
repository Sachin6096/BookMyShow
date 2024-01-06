package com.example.BookmyShowProject.Services;

import com.example.BookmyShowProject.Enums.SeatType;
import com.example.BookmyShowProject.Models.*;
import com.example.BookmyShowProject.Repository.MovieRepository;
import com.example.BookmyShowProject.Repository.ShowRepository;
import com.example.BookmyShowProject.Repository.TheaterRepository;
import com.example.BookmyShowProject.RequestDtos.AddShowRequest;
import com.example.BookmyShowProject.RequestDtos.AddShowSheatRequest;
import com.example.BookmyShowProject.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;



    public String addShow(AddShowRequest addShowRequest){

        //Goal is to set the attributes of the Show Entity and save it to db.

        Show show = ShowTransformer.convertShowReqToShow(addShowRequest);
        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());

        Optional<Theater> optionalTheater = theaterRepository.findById(addShowRequest.getTheaterId());
        Theater theater = optionalTheater.get();

        //Setting the FK values
        show.setMovie(movie);
        show.setTheater(theater);

        //Setting the bidirectional mapping
        theater.getShowList().add(show);
        movie.getShowList().add(show);

        show = showRepository.save(show);

        return "Show has been saved to the DB with showId "+show.getShowId();

    }

    public String createShowSeats(AddShowSheatRequest addShowRequest) {

       Show show = showRepository.findById(addShowRequest.getShowId()).get();
       Theater theater = show.getTheater();
       List<TheaterSeat> theaterSeatList = theater.getSeatList();
       List<ShowSeats> showSeatsList = new ArrayList<>();

       for(TheaterSeat theaterSeat: theaterSeatList)
       {
            ShowSeats showSeats = ShowSeats.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .show(show).build();

            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC))
            {
                showSeats.setPrice(addShowRequest.getPriceOfClassicSeats());
            }
            else{
                showSeats.setPrice(addShowRequest.getPriceOfPremiumSeats());
            }

            showSeatsList.add(showSeats);
       }

       show.setShowSeats(showSeatsList);

       showRepository.save(show);


        return "Seats has been added";

    }
}
