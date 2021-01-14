package com.example.Serwiswydarzen.services;

import com.example.Serwiswydarzen.dao.EventRepository;
import com.example.Serwiswydarzen.dao.UserRepository;
import com.example.Serwiswydarzen.dtos.NewEventForm;
import com.example.Serwiswydarzen.entities.Event;
import com.example.Serwiswydarzen.entities.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final UserContexService userContexService;

    public EventService(UserRepository userRepository, EventRepository eventRepository, UserContexService userContexService) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.userContexService = userContexService;
    }

    public void saveNewEvent(NewEventForm newEventForm) {
//        final String currentUser =userContexService.getCurrentlyLoggerUser();
//
//        final User user=userRepository.findUserByByEmail(currentUser);

        final Event event=new Event();
        event.setTitle(newEventForm.getEventTitle());
        event.setDateForm(newEventForm.getEventDateFrom());
        event.setDateTo(newEventForm.getEventDateTo());
        event.setBody(newEventForm.getEventBody());
        eventRepository.save(event);
    }
}
