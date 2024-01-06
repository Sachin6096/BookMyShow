package com.example.BookmyShowProject.Controller;

import com.example.BookmyShowProject.RequestDtos.BookTicketRequest;
import com.example.BookmyShowProject.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("bookticket")
    public String bookTickets(@RequestBody BookTicketRequest bookTicketRequest)
    {
        String result = ticketService.boookTickets(bookTicketRequest);
        return result;
    }
}
