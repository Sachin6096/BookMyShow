package com.example.BookmyShowProject.Transformers;

import com.example.BookmyShowProject.Models.Show;
import com.example.BookmyShowProject.RequestDtos.AddShowRequest;

public class ShowTransformer {

    public static Show convertShowReqToShow(AddShowRequest addShowRequest){

        Show showObj = Show.builder().showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .build();

        return showObj;
    }
}