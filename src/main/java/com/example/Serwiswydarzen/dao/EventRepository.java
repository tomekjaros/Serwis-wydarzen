package com.example.Serwiswydarzen.dao;

import com.example.Serwiswydarzen.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
