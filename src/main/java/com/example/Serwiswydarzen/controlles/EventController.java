package com.example.Serwiswydarzen.controlles;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @GetMapping("/addevent")
    public String addEvent (Model model){


        return "addevent";

    }
}
