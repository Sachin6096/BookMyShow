package com.example.BookmyShowProject.Controller;

import com.example.BookmyShowProject.Models.User;
import com.example.BookmyShowProject.RequestDtos.AddUserRequest;
import com.example.BookmyShowProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class  UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody AddUserRequest userRequest)
    {
        String response = userService.addUser(userRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
