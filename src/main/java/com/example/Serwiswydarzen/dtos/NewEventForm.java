package com.example.Serwiswydarzen.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class NewEventForm {

    @NotNull
    @NotBlank(message = "Title can not null and can not have white singht.")
    private String eventTitle;
    @DateTimeFormat
    private LocalDateTime eventDateFrom;
    @Deprecated
    private LocalDateTime eventDateTo;
    @NotNull
    @Size(min = 20)
    private String eventBody;

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public LocalDateTime getEventDateFrom() {
        return eventDateFrom;
    }

    public void setEventDateFrom(LocalDateTime eventDateFrom) {
        this.eventDateFrom = eventDateFrom;
    }

    public LocalDateTime getEventDateTo() {
        return eventDateTo;
    }

    public void setEventDateTo(LocalDateTime eventDateTo) {
        this.eventDateTo = eventDateTo;
    }

    public String getEventBody() {
        return eventBody;
    }

    public void setEventBody(String eventBody) {
        this.eventBody = eventBody;
    }


    @Override
    public String toString() {
        return "NewEventForm{" +
                "eventTitle='" + eventTitle + '\'' +
                ", eventDateFrom=" + eventDateFrom +
                ", eventDateTo=" + eventDateTo +
                ", eventBody='" + eventBody + '\'' +
                '}';
    }
}
