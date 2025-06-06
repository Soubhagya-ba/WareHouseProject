package com.example.warehouse.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.Optional;

public class AuthUtilities {
    private AuthUtilities(){
        //it is a utility class
    }

    public static Optional<Authentication> getAuthentication(){
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
    }
    public static Optional<String> getCurrentUsername(){
        return getAuthentication().map(auth->auth.getName());
    }

    public static void setAuthentication(Authentication auth){
        Objects.requireNonNull(auth,"Authentication Cannot Be Null!!");
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
