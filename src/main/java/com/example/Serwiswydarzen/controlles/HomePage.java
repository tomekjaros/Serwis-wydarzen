package com.example.Serwiswydarzen.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping("/")
    public String showHomePage (Model model){

        return "homePage";
    }
}
