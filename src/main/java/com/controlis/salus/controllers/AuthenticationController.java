package com.controlis.salus.controllers;

import com.controlis.salus.dtos.LoginRequestDto;
import com.controlis.salus.dtos.UserInsertDto;
import com.controlis.salus.dtos.UserReturnDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.controlis.salus.services.AuthenticationService;

record LoginResponseDto(
        String token
) { }

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDto login(@RequestBody @Valid LoginRequestDto authenticationDto) {
        return new LoginResponseDto(authenticationService.login(authenticationDto));
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public UserReturnDto register(@RequestBody @Valid UserInsertDto dto) {
        return authenticationService.register(dto);
    }
}