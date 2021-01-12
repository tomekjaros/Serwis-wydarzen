package com.example.Serwiswydarzen.controlles;

import com.example.Serwiswydarzen.dtos.NewUserForm;
import com.example.Serwiswydarzen.dtos.RegisteredUserDto;
import com.example.Serwiswydarzen.services.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
@Slf4j
@Controller
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/register")
    public String showRegisterForm ( Model model){

        final NewUserForm newUserForm = new NewUserForm();

        newUserForm.setEmail("email");
        newUserForm.setNickname("nickname");
        newUserForm.setPassword("password");
        model.addAttribute("newUserForm", newUserForm);

        return "registerForm";
    }

    @PostMapping("/register")
    public String submitRegisterForm(@ModelAttribute @Valid NewUserForm newUserForm,
                                     BindingResult bindingResult) {

        log.info("New USER :{}",newUserForm);
        log.info("New POST ERROR :{}",bindingResult.getAllErrors());

        if(bindingResult.hasErrors()){
            return "registerForm";
        }
        usersService.saveNewUser(newUserForm);
        return "registeredUserThankyouPage";
    }

    @GetMapping("/login")
    public String showLoginForm (){
        return "loginForm";
    }

    @GetMapping("/login-error")
    public String bedLoginPassword (){
        return "error";
    }

}
