package com.example.Serwiswydarzen.dao;

import com.example.Serwiswydarzen.entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByEmail(String email);
    //User findUserByByEmail(String user);


}
