package com.example.Serwiswydarzen.dao;

import com.example.Serwiswydarzen.entities.EventComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventCommentRepository extends JpaRepository<EventComment,Long> {
}
