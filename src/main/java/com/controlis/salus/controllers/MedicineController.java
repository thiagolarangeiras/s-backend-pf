package com.controlis.salus.controllers;

import com.controlis.salus.dtos.MedicineInsertDto;
import com.controlis.salus.dtos.MedicineReturnDto;
import com.controlis.salus.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping
    public ResponseEntity<MedicineReturnDto> createMedicine(@RequestBody MedicineInsertDto dto) {
        return ResponseEntity.ok(medicineService.saveMedicine(dto));
    }

    @GetMapping
    public ResponseEntity<List<MedicineReturnDto>> getAllMedicines(
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(medicineService.getAllMedicines(page, count));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineReturnDto> getMedicineById(@PathVariable Integer id) {
        return ResponseEntity.ok(medicineService.getMedicineById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedicineReturnDto> updateMedicine(
            @PathVariable Integer id, @RequestBody MedicineInsertDto dto) {
        return ResponseEntity.ok(medicineService.updateMedicine(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicineReturnDto> deleteMedicine(@PathVariable Integer id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }
}
