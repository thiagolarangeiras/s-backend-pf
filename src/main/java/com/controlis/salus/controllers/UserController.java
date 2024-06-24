package com.controlis.salus.controller;

import com.controlis.salus.dto.UserDTO;
import com.controlis.salus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @GetMapping("/medico")
    public ResponseEntity<List<UserDTO>> getAllMedicos(
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(userService.getAllMedicos(page, count));
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<UserDTO>> getAllPacientes(
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(userService.getAllPacientes(page, count));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Integer id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
