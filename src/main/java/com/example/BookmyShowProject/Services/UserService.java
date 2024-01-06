package com.example.BookmyShowProject.Services;

import com.example.BookmyShowProject.Models.User;
import com.example.BookmyShowProject.Repository.UserRepository;
import com.example.BookmyShowProject.RequestDtos.AddUserRequest;
import com.example.BookmyShowProject.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserRequest userRequest)
    {
        User user = UserTransformer.convertAddUserReqToUserEntity(userRequest);
        userRepository.save(user);
        return "User added Successfully!";
    }
}
