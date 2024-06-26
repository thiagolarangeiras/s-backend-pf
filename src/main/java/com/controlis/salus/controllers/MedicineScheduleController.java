package com.controlis.salus.controllers;

import com.controlis.salus.dtos.MedicineInsertDto;
import com.controlis.salus.dtos.MedicineReturnDto;
import com.controlis.salus.dtos.MedicineScheduleInsertDto;
import com.controlis.salus.dtos.MedicineScheduleReturnDto;
import com.controlis.salus.services.MedicineScheduleService;
import com.controlis.salus.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescricao")
public class MedicineScheduleController {
    @Autowired
    private MedicineScheduleService medicineScheduleService;

    @PostMapping
    public ResponseEntity<MedicineScheduleReturnDto> create(@RequestBody MedicineScheduleInsertDto dto) {
        return ResponseEntity.ok(medicineScheduleService.save(dto));
    }

    @GetMapping("paciente/{id-paciente}")
    public ResponseEntity<List<MedicineScheduleReturnDto>> getAll(
            @PathVariable("id-paciente") Integer patientId,
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(medicineScheduleService.getAll(patientId, page, count));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineScheduleReturnDto> get(@PathVariable Integer id) {
        return ResponseEntity.ok(medicineScheduleService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineScheduleReturnDto> update(
            @PathVariable Integer id, @RequestBody MedicineScheduleInsertDto dto) {
        return ResponseEntity.ok(medicineScheduleService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicineScheduleReturnDto> delete(@PathVariable Integer id) {
        medicineScheduleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}