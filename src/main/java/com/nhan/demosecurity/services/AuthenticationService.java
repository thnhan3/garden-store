package com.nhan.demosecurity.services;

import com.nhan.demosecurity.dto.JwtAuthenticationResponse;
import com.nhan.demosecurity.dto.RefreshTokenRequest;
import com.nhan.demosecurity.dto.SignInRequest;
import com.nhan.demosecurity.dto.SignUpRequest;
import com.nhan.demosecurity.entities.User;

public interface AuthenticationService {

    User signUp(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signIn(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
