package com.example.Serwiswydarzen.dtos;

import java.time.LocalDate;

public class EventInfoDto {

    private Long id;
    private String title;
    private LocalDate dataFrom;
    private LocalDate dataTo;
    private String body;

    public EventInfoDto(Long id, String title, LocalDate dataFrom, LocalDate dataTo, String body) {
        this.id = id;
        this.title = title;
        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDataFrom() {
        return dataFrom;
    }

    public LocalDate getDataTo() {
        return dataTo;
    }

    public String getBody() {
        return body;
    }


}
