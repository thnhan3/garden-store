package com.nhan.demosecurity.services;

import com.nhan.demosecurity.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {

    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
