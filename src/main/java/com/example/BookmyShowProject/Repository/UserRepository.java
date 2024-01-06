package com.example.BookmyShowProject.Repository;

import com.example.BookmyShowProject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
