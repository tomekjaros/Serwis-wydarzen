package com.example.Serwiswydarzen.services;

import com.example.Serwiswydarzen.dao.EventRepository;
import com.example.Serwiswydarzen.dao.UserRepository;
import com.example.Serwiswydarzen.dtos.EventShortInfoDto;
import com.example.Serwiswydarzen.dtos.NewEventForm;
import com.example.Serwiswydarzen.entities.Event;
import com.example.Serwiswydarzen.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
//  final String currentUser =userContexService.getCurrentlyLoggerUser();
////
//   final User user=userRepository.findEmailByEmail(currentUser)
//           .orElse(userRepository.save(new User(currentUser)));

        final Event event=new Event();
        event.setTitle(newEventForm.getEventTitle());
        event.setDateForm(newEventForm.getEventDateFrom());
        event.setDateTo(newEventForm.getEventDateTo());
        event.setBody(newEventForm.getEventBody());
        eventRepository.save(event);
    }

    public List<EventShortInfoDto> getAllEventsSortedByNew() {

        return eventRepository.findAll(Sort.by("dateForm").ascending())
                .stream()
                .filter(event -> event.getDateTo().isAfter(LocalDate.now()))

               .map(event -> new EventShortInfoDto(
                        event.getId(),
                        event.getTitle(),
                        event.getDateForm(),
                        event.getDateTo(),
                        event.getBody()))
                .collect(Collectors.toList());
    }
}
