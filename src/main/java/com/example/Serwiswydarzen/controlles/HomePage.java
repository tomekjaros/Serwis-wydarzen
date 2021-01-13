package com.example.Serwiswydarzen.controlles;

import com.example.Serwiswydarzen.services.UserContexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
    private final UserContexService userContexService;

    public HomePage(UserContexService userContexService) {
        this.userContexService = userContexService;
    }


    @GetMapping("/")
    public String showHomePage (Model model){
        model.addAttribute("loggedAs",userContexService.getCurrentlyLoggerUser());

        return "homePageStart";
    }
}
