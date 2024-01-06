package com.example.BookmyShowProject.Repository;

import com.example.BookmyShowProject.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
