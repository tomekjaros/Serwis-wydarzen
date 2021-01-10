package com.example.Serwiswydarzen.controlles;

import com.example.Serwiswydarzen.dtos.RegisteredUserDto;
import com.example.Serwiswydarzen.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/register")
    public String showRegisterForm (){
        return "registerForm";
    }

    @PostMapping("/register")
    public String submitRegisterForm(@RequestParam String email,
                                     @RequestParam String nickname,
                                     @RequestParam String password)
    {
        RegisteredUserDto registeredUserDto = usersService.registerUser(email,nickname,password);

        return "registeredUserThankyouPage";

    }
}
