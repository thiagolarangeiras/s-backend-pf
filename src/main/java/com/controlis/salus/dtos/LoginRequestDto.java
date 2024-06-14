package com.controlis.salus.dtos;

public record LoginRequestDto(
        String username,
        String password
) { }