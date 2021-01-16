package com.example.Serwiswydarzen.controlles;


import com.example.Serwiswydarzen.dtos.NewEventForm;
import com.example.Serwiswydarzen.services.EventService;
import com.example.Serwiswydarzen.services.UserContexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class EventController {



    private EventService eventService;
    private UserContexService userContexService;

    public EventController(UserContexService userContexService, EventService eventService) {
        this.userContexService = userContexService;
        this.eventService = eventService;
    }

    @GetMapping("/addevent")
    public String addEvent (Model model){
        model.addAttribute("loggedAs",userContexService.getCurrentlyLoggerUser());

        final NewEventForm newEventForm = new NewEventForm();
        newEventForm.setEventTitle("Title");
        newEventForm.setEventBody("New event.............");
        model.addAttribute("newEventForm",newEventForm);

        return "addevent";
    }

    @PostMapping("/addevent")
    public String handleAddEvent (@ModelAttribute @Valid NewEventForm newEventForm,
                                  BindingResult bindingResult, Model model){
            log.info("New POST: {}",newEventForm);
            log.info("New POST ERRORS:{}", bindingResult.getAllErrors());

        model.addAttribute("loggedAs",userContexService.getCurrentlyLoggerUser());

            if(bindingResult.hasErrors()) {
                return "addevent";
            }
            eventService.saveNewEvent(newEventForm);
    return "homePageStart";
            }
    }

