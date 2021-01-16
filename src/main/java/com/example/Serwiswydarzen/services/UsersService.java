package com.example.Serwiswydarzen.services;

import com.example.Serwiswydarzen.dao.RoleRepository;
import com.example.Serwiswydarzen.dao.UserRepository;
import com.example.Serwiswydarzen.dtos.NewUserForm;
import com.example.Serwiswydarzen.entities.Role;
import com.example.Serwiswydarzen.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;




    public UsersService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        this.roleRepository = roleRepository;
    }

//    public RegisteredUserDto registerUser(String email, String nickname, String password){
//        final User user = new User();
//        user.setEmail(email);
//        user.setNickname(nickname);
//        user.setPassword(passwordEncoder.encode(password));
//      //  user.addRole(role);
//
//        userRepository.save(user);
//
//        return null;
//
//
//
//    }

    public void saveNewUser(NewUserForm newUserForm) {

//    final String roleName ="ROLE_USER";
//    final Role role = roleRepository.findNameByName(roleName)
//            .orElse(roleRepository.save(new Role(roleName)));

    final User user =new User();
    user.setEmail(newUserForm.getEmail());
    user.setNickname(newUserForm.getNickname());
    user.setPassword(passwordEncoder.encode(newUserForm.getPassword()));
   // user.addRole(role);


    userRepository.save(user);
    }
}
