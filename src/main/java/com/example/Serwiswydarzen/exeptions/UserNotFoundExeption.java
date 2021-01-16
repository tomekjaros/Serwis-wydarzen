package com.example.Serwiswydarzen.exeptions;

public class UserNotFoundExeption extends RuntimeException {

    private String username;

    public UserNotFoundExeption(String nickname) {this.username=username;}

    @Override
    public String getMessage() {
        return String.format("User identified by %s couln't be found,",username);
    }

    public String getUsername(){return  username;}
}

