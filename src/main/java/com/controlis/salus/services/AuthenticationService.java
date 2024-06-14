package com.controlis.salus.services;

import com.controlis.salus.dtos.LoginRequestDto;
import com.controlis.salus.dtos.UserInsertDto;
import com.controlis.salus.dtos.UserReturnDto;
import com.controlis.salus.models.User;
import com.controlis.salus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenService tokenService;

    @Transactional(readOnly = true)
    public String login(LoginRequestDto dto) throws AuthenticationException {
        Authentication usernamePassword = new UsernamePasswordAuthenticationToken(
                dto.username(),
                dto.password()
        );
        Authentication auth = authenticationManager.authenticate(usernamePassword);
        User user = (User) auth.getPrincipal();
        return tokenService.generateToken(user.getUsername());
    }

    @Transactional
    public UserReturnDto register(UserInsertDto dto) {
        User user = new User();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.password()));
        user.setCompleteName(dto.completeName());
        user.setBirthDate(dto.birthDate());
        user.setType(dto.type());

        User savedUser = userRepository.save(user);
        return new UserReturnDto(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getCompleteName(),
                savedUser.getBirthDate(),
                savedUser.getType()
        );
    }
}