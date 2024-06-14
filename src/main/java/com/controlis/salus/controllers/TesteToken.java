package com.controlis.salus.controllers;

import com.controlis.salus.dtos.LoginRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TesteToken {
    @GetMapping("/teste")
    @ResponseStatus(HttpStatus.OK)
    public String login() {
        return "Autenticado!";
    }
}
