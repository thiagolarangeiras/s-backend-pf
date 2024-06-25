package com.controlis.salus.dtos;

import com.controlis.salus.models.enums.UserType;
import lombok.Builder;

import java.util.Date;

@Builder
public record UserInsertDto(
        String username,
        String email,
        String password,
        String completeName,
        Date birthDate,
        UserType type
) { }
