package com.controlis.salus.controller;

import com.controlis.salus.dto.MedicineDTO;
import com.controlis.salus.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamento")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping
    public ResponseEntity<MedicineDTO> createMedicine(@RequestBody MedicineDTO medicineDTO) {
        return ResponseEntity.ok(medicineService.saveMedicine(medicineDTO));
    }

    @GetMapping
    public ResponseEntity<List<MedicineDTO>> getAllMedicines(
            @RequestParam int page,
            @RequestParam int count) {
        return ResponseEntity.ok(medicineService.getAllMedicines(page, count));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDTO> getMedicineById(@PathVariable Integer id) {
        return ResponseEntity.ok(medicineService.getMedicineById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedicineDTO> updateMedicine(
            @PathVariable Integer id, @RequestBody MedicineDTO medicineDTO) {
        return ResponseEntity.ok(medicineService.updateMedicine(id, medicineDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Integer id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }
}
