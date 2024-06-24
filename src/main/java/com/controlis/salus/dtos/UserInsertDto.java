package com.controlis.salus.dto;

import com.controlis.salus.models.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String completeName;
    private String birthDate;
    private UserType type;
    private Set<String> roles;
}
