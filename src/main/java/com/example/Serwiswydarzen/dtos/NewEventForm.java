package com.example.Serwiswydarzen.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewEventForm {

    @NotNull
    @NotBlank(message = "Title can not null and can not have white singht.")
    private String eventTitle;

    @NotNull(message = "Can not null ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDateFrom;

    @NotNull(message = "Can not null ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDateTo;

    @NotNull
    @Size(min = 20)
    private String eventBody;



    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }


    public LocalDate getEventDateFrom() {
        return eventDateFrom;
    }

    public void setEventDateFrom(LocalDate eventDateFrom) {
        this.eventDateFrom = eventDateFrom;
    }

    public LocalDate getEventDateTo() {
        return eventDateTo;
    }

    public void setEventDateTo(LocalDate eventDateTo) {
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
