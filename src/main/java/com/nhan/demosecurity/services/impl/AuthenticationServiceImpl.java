package com.nhan.demosecurity.services.impl;

import com.nhan.demosecurity.domain.Customer;
import com.nhan.demosecurity.dto.JwtAuthenticationResponse;
import com.nhan.demosecurity.dto.RefreshTokenRequest;
import com.nhan.demosecurity.dto.SignUpRequest;
import com.nhan.demosecurity.entities.Role;
import com.nhan.demosecurity.entities.User;
import com.nhan.demosecurity.repository.CustomerRepository;
import com.nhan.demosecurity.repository.UserRepository;
import com.nhan.demosecurity.services.AuthenticationService;
import com.nhan.demosecurity.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.nhan.demosecurity.dto.SignInRequest;

import java.util.HashMap;
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public User signUp(SignUpRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setAddress("");
        User savedUser = userRepository.save(user);

        // create new customer
        Customer customer = new Customer();
        customer.setFirstName(signUpRequest.getFirstName());
        customer.setLastName(signUpRequest.getLastName());
        customer.setEmail(signUpRequest.getEmail());

        customer.setCustomerId(savedUser.getId());
        customer.setPhoneNumber(signUpRequest.getPhoneNumber());
        customerRepository.save(customer);
       return savedUser;
    }

    public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
         var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new IllegalArgumentException("Invalid token"));
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
          var jwt =jwtService.generateToken(user);

          JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }
}
