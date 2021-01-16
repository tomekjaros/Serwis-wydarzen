package com.example.Serwiswydarzen.exeptions;

public class EventNotFoundExeption extends RuntimeException {

    private Long eventId;

    public EventNotFoundExeption(Long eventId) {
        this.eventId=eventId;


    }

    @Override
    public String getMessage() {
        return String.format("Event not found: %d",eventId);
    }
    public Long getEventId() {return eventId; }
}
