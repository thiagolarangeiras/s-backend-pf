package com.controlis.salus.controllers;

import com.controlis.salus.dtos.AppointmentInsertDto;
import com.controlis.salus.dtos.AppointmentReturnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.controlis.salus.services.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class AppointmentController{

    @Autowired
    private AppointmentService AppointmentService;

    @PostMapping("/{id-medico}") // Agendar consulta
    public ResponseEntity<AppointmentReturnDto> createAppointment(
        @PathVariable("id-medico") Integer doctorId,
        @RequestBody AppointmentInsertDto dto) {
        return ResponseEntity.ok(AppointmentService.save(dto, doctorId));
    }

    @GetMapping("/{id-paciente}")// Listar consultas por paciente
    public ResponseEntity<List<AppointmentReturnDto>> getAllAppointments(
            @PathVariable("id-paciente") Integer patientId,
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(AppointmentService.getAllPatient(page, count, patientId));
    }

    @GetMapping("/{id-medico}") // Listar consulta por médico
    public ResponseEntity<List<AppointmentReturnDto>> getAllAppointments(
            @PathVariable("id-medico") Integer doctorId,
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(AppointmentService.getAllDoctor(page, count, doctorId));
    }

    @PatchMapping("/{id}") // Alterar data/horario da consulta
    public ResponseEntity<AppointmentReturnDto> updateAppointment(
            @PathVariable Integer id,
            @RequestBody AppointmentUpdateDto dto) {
        return ResponseEntity.ok(AppointmentService.update(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<AppointmentReturnDto> deleteAppointment(@PathVariable Integer id) {
        AppointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
