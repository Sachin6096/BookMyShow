package com.example.BookmyShowProject.Repository;

import com.example.BookmyShowProject.Models.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeats,Integer> {
}
