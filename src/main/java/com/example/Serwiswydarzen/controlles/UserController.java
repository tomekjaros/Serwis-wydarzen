package com.example.Serwiswydarzen.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    @GetMapping("/register")
    public String showRegisterForm (){
        return "registerForm";
    }

    @PostMapping("/register")
    public String submitRegisterForm(@RequestParam String email,
                                     @RequestParam String nickname,
                                     @RequestParam String password){

        return "registeredUserThankyouPage";

    }
}
