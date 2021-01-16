package com.example.Serwiswydarzen.dao;

import com.example.Serwiswydarzen.entities.Role;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findNameByName(String role);
}
