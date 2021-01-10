package com.example.Serwiswydarzen.services;

import com.example.Serwiswydarzen.dao.UserRepository;
import com.example.Serwiswydarzen.dtos.RegisteredUserDto;
import com.example.Serwiswydarzen.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public UsersService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisteredUserDto registerUser(String email, String nickname, String password){
        final User user = new User();
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        return null;



    }
}
