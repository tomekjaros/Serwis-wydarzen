package com.example.Serwiswydarzen.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewUserForm {

    @NotNull
    @Email
    private String email;

    @NotNull
    @NotBlank(message = "Nickaname nie moze byc puste, ani zawierac pustych zanków")
    @Size(max = 50)
    private  String nickname;

    @Size(min = 8, max = 30)
    private  String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NewUserForm{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

