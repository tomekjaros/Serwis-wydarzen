package com.example.Serwiswydarzen.controlles;


import com.example.Serwiswydarzen.dtos.NewEventForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @GetMapping("/addevent")
    public String addEvent (Model model){

        final NewEventForm newEventForm = new NewEventForm();
        newEventForm.setEventTitle("Title");
        newEventForm.setEventBody("New event");
        model.addAttribute("newEventForm",newEventForm);


        return "addevent";

    }
}
