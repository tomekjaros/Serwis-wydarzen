package com.example.Serwiswydarzen.controlles;

import com.example.Serwiswydarzen.services.EventService;
import com.example.Serwiswydarzen.services.UserContexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Slf4j
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
    @GetMapping("/search")
    public String search (@RequestParam String q,
                          Model model){


       model.addAttribute("eventsearchs",eventService.getEventsSearch(q));

        return "search";
    }



}
