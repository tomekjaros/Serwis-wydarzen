package com.example.Serwiswydarzen.services;

import com.example.Serwiswydarzen.dao.EventCommentRepository;

import com.example.Serwiswydarzen.dao.EventRepository;
import com.example.Serwiswydarzen.dao.UserRepository;
import com.example.Serwiswydarzen.dtos.EventInfoDto;
import com.example.Serwiswydarzen.dtos.EventShortInfoDto;
import com.example.Serwiswydarzen.dtos.NewEventForm;
import com.example.Serwiswydarzen.entities.Event;
import com.example.Serwiswydarzen.entities.EventComment;
import com.example.Serwiswydarzen.entities.User;
import com.example.Serwiswydarzen.exeptions.EventNotFoundExeption;
import com.example.Serwiswydarzen.exeptions.UserNotFoundExeption;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final UserContexService userContexService;
    private final EventCommentRepository eventCommentRepository;

    public EventService(UserRepository userRepository, EventRepository eventRepository, UserContexService userContexService, EventCommentRepository eventCommentRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.userContexService = userContexService;
        this.eventCommentRepository = eventCommentRepository;
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

    public List<EventShortInfoDto> getEventsSearch( String q) {

        return eventRepository
                .findByTitleContaining(q)
                .stream()
                .map(event -> new EventShortInfoDto(
                        event.getId(),
                        event.getTitle(),
                        event.getDateForm(),
                        event.getDateTo(),
                        event.getBody()))
                .collect(Collectors.toList());

    }

    public Optional<EventInfoDto> getSingleEventInfo(Long eventId) {

        return eventRepository.findById(eventId)
                .map(event -> new EventInfoDto(
                        event.getId(),
                        event.getTitle(),
                        event.getDateForm(),
                        event.getDateTo(),
                        event.getBody()));

    }

    public Object addNewComent(Long eventId, String commentText, String nickname) {

    final Event event =eventRepository.findById(eventId)
                .orElseThrow((() -> new EventNotFoundExeption(eventId)));
    final User user= userRepository.findEmailByEmail(nickname)
                .orElseThrow((() -> new UserNotFoundExeption(nickname)));


                final EventComment eventComment = new EventComment();
                eventComment.setCommnetText(commentText);
                eventComment.setCommentartorNickname(nickname);
                eventComment.setEvent(event);
                eventComment.setUser(user);
                eventCommentRepository.save(eventComment);
        return null;
    }
}



