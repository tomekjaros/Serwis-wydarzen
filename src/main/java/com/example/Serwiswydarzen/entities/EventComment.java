package com.example.Serwiswydarzen.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "event_comments")
public class EventComment {
    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 500)
    private String commnetText;

    private String commentartorNickname;

    private LocalDate added = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommnetText() {
        return commnetText;
    }

    public void setCommnetText(String commnetText) {
        this.commnetText = commnetText;
    }

    public String getCommentartorNickname() {
        return commentartorNickname;
    }

    public void setCommentartorNickname(String commentartorNickname) {
        this.commentartorNickname = commentartorNickname;
    }

    public LocalDate getAdded() {
        return added;
    }

    public void setAdded(LocalDate added) {
        this.added = added;
    }
}
