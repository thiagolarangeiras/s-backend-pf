package com.controlis.salus.dtos;

import com.controlis.salus.models.enums.UserType;

import java.util.Date;

public record UserInsertDto(
        String username,
        String email,
        String password,
        String completeName,
        Date birthDate,
        UserType type
) { }