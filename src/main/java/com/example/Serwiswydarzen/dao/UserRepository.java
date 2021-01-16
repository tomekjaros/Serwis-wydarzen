package com.example.Serwiswydarzen.dao;

import com.example.Serwiswydarzen.entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByEmail(String email);
    Optional<User>  findEmailByEmail(String email);


}
