package com.controlis.salus.controllers;

import com.controlis.salus.dtos.AvailabilityInsertDto;
import com.controlis.salus.dtos.AvailabilityReturnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.controlis.salus.services.AvailabilityService;

import java.util.List;

@RestController
@RequestMapping("/disponibilidade")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping
    public ResponseEntity<AvailabilityReturnDto> createAvailability(@RequestBody AvailabilityInsertDto dto) {
        return ResponseEntity.ok(availabilityService.save(dto));
    }

    @GetMapping("{id-medico}")
    public ResponseEntity<List<AvailabilityReturnDto>> getAllAvailabilitys(
            @PathVariable("id-medico") Integer medicId,
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(availabilityService.getAll(page, count, medicId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AvailabilityReturnDto> deleteAvailability(@PathVariable Integer id) {
        availabilityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
