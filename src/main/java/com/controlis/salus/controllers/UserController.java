package com.controlis.salus.controllers;

import com.controlis.salus.dtos.UserInsertDto;
import com.controlis.salus.dtos.UserReturnDto;
import com.controlis.salus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/medico")
    public ResponseEntity<List<UserReturnDto>> getAllMedicos(
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(userService.getAllMedicos(page, count));
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<UserReturnDto>> getAllPacientes(
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(userService.getAllPacientes(page, count));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UserReturnDto> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<UserReturnDto> updateUser(
            @PathVariable Integer id, @RequestBody UserInsertDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(id);
    }
}
