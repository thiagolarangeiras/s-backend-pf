package com.controlis.salus.dtos;

import com.controlis.salus.models.enums.UserType;
import java.util.Date;

public record UserReturnDto(
        Integer id,
        String username,
        String email,
        String completeName,
        Date birthDate,
        UserType type
) { }