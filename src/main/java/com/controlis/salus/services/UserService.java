package com.controlis.salus.service;

import com.controlis.salus.dto.UserDTO;
import com.controlis.salus.models.User;
import com.controlis.salus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllMedicos(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return userRepository.findAll(pageable).stream()
                .filter(user -> user.getType() == UserType.MEDICO)
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> getAllPacientes(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return userRepository.findAll(pageable).stream()
                .filter(user -> user.getType() == UserType.PACIENTE)
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id)
                .map(this::convertEntityToDTO)
                .orElse(null);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertDTOToEntity(userDTO);
        user = userRepository.save(user);
        return convertEntityToDTO(user);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        User user = convertDTOToEntity(userDTO);
        user.setId(id);
        user = userRepository.save(user);
        return convertEntityToDTO(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertEntityToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .completeName(user.getCompleteName())
                .birthDate(user.getBirthDate().toString())
                .type(user.getType())
                .roles(user.getRoles())
                .build();
    }

    private User convertDTOToEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .completeName(userDTO.getCompleteName())
                .birthDate(LocalDate.parse(userDTO.getBirthDate()))
                .type(userDTO.getType())
                .roles(userDTO.getRoles())
                .build();
    }
}
