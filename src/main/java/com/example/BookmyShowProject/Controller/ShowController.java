package com.example.BookmyShowProject.Controller;

import com.example.BookmyShowProject.RequestDtos.AddShowRequest;
import com.example.BookmyShowProject.RequestDtos.AddShowSheatRequest;
import com.example.BookmyShowProject.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest) {

        String result = showService.addShow(addShowRequest);
        return result;
    }

    @PostMapping("/createShowSeats")
    private String createShowSeats(@RequestBody AddShowSheatRequest addShowSheatRequest){

        String result = showService.createShowSeats(addShowSheatRequest);
        return result;
    }
}
