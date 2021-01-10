package com.example.Serwiswydarzen.dao;

import com.example.Serwiswydarzen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
