package com.example.Serwiswydarzen.dao;


import com.example.Serwiswydarzen.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {


    List<Event> findByTitleContaining(String titleLike);



}
