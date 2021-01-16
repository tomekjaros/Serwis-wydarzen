package com.example.Serwiswydarzen.controlles;

import com.example.Serwiswydarzen.services.EventService;
import com.example.Serwiswydarzen.services.UserContexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
    private final UserContexService userContexService;
    private final EventService eventService;

    public HomePage(UserContexService userContexService, EventService eventService) {
        this.userContexService = userContexService;
        this.eventService = eventService;
    }


    @GetMapping("/")
    public String showHomePage (Model model){
        model.addAttribute("loggedAs",userContexService.getCurrentlyLoggerUser());
        model.addAttribute("events",eventService.getAllEventsSortedByNew());

        return "homePageStart";
    }
}
