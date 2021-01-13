package com.example.Serwiswydarzen.services;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserContexService {
    public String getCurrentlyLoggerUser(){
      final   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if(authentication instanceof AnonymousAuthenticationToken){
          return null;
      }

      return authentication.getName();
    }
}
