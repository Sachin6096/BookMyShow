package com.example.BookmyShowProject.Transformers;

import com.example.BookmyShowProject.Models.User;
import com.example.BookmyShowProject.RequestDtos.AddUserRequest;

public class UserTransformer {

    public static User convertAddUserReqToUserEntity(AddUserRequest addUserRequest){

        User userObj = User.builder()
                .age(addUserRequest.getAge())
                .name(addUserRequest.getName())
                .emailId(addUserRequest.getEmailId())
                .mobNo(addUserRequest.getMobNo()).build();

        return userObj;
    }
}
