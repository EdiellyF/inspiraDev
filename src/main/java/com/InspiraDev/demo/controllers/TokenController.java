package com.InspiraDev.demo.controllers;


import com.InspiraDev.demo.controllers.dto.LoginRequest;
import com.InspiraDev.demo.controllers.dto.LoginResponse;
import com.InspiraDev.demo.models.User;
import com.InspiraDev.demo.repositories.IUserRepository;
import com.InspiraDev.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;


//classe responsavel por permitir, retornar o token para o usuario, usada na hora do login/autenticacao
@RestController
public class TokenController {
    private final JwtEncoder jwtEncoder;

    private final UserService userService;


    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public TokenController(final JwtEncoder jwtEncoder, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody final LoginRequest loginRequest) {
       var user = userService.findByUsername(loginRequest.username());

       if(user.isEmpty() || !user.get().isLoginCorrect(loginRequest, bCryptPasswordEncoder)){
           throw new BadCredentialsException("Username or password is invalid");
       }

       var now = Instant.now();
       var expiresIn = 300L;

       var claims =  JwtClaimsSet.builder()
               .issuer("mybackend")
               .subject(user.get().getId().toString())
               .expiresAt(now.plusSeconds(expiresIn))
               .issuedAt(now)
               .build();

       var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

       return  ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
    }
}
