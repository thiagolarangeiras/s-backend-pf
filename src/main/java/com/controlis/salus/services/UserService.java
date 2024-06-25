package com.controlis.salus.services;

import com.controlis.salus.dtos.LoginRequestDto;
import com.controlis.salus.dtos.UserInsertDto;
import com.controlis.salus.dtos.UserReturnDto;
import com.controlis.salus.models.User;
import com.controlis.salus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.controlis.salus.models.enums.UserType;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
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
    public UserReturnDto saveUser(UserInsertDto dto) {
        User user = User.convertDtoToEntity(dto);
        user = userRepository.save(user);
        return User.convertEntityToDto(user);
    }

    public List<UserReturnDto> getAllMedicos(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return userRepository.findAll(pageable).stream()
                .filter(user -> user.getType() == UserType.medic)
                .map(User::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<UserReturnDto> getAllPacientes(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return userRepository.findAll(pageable).stream()
                .filter(user -> user.getType() == UserType.patient)
                .map(User::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public UserReturnDto getUserById(Integer id) {
        return userRepository.findById(id)
                .map(User::convertEntityToDto)
                .orElse(null);
    }

    public UserReturnDto updateUser(Integer id, UserInsertDto dto) {
        User user = User.convertDtoToEntity(dto);
        user.setId(id);
        user = userRepository.save(user);
        return User.convertEntityToDto(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
