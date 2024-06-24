package com.controlis.salus.service;

import com.controlis.salus.dto.MedicineDTO;
import com.controlis.salus.models.Medicine;
import com.controlis.salus.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<MedicineDTO> getAllMedicines(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return medicineRepository.findAll(pageable).stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public MedicineDTO getMedicineById(Integer id) {
        return medicineRepository.findById(id)
                .map(this::convertEntityToDTO)
                .orElse(null);
    }

    public MedicineDTO saveMedicine(MedicineDTO medicineDTO) {
        Medicine medicine = convertDTOToEntity(medicineDTO);
        medicine = medicineRepository.save(medicine);
        return convertEntityToDTO(medicine);
    }

    public MedicineDTO updateMedicine(Integer id, MedicineDTO medicineDTO) {
        Medicine medicine = convertDTOToEntity(medicineDTO);
        medicine.setId(id);
        medicine = medicineRepository.save(medicine);
        return convertEntityToDTO(medicine);
    }

    public void deleteMedicine(Integer id) {
        medicineRepository.deleteById(id);
    }

    private MedicineDTO convertEntityToDTO(Medicine medicine) {
        return MedicineDTO.builder()
                .id(medicine.getId())
                .userId(medicine.getUserId())
                .name(medicine.getName())
                .build();
    }

    private Medicine convertDTOToEntity(MedicineDTO medicineDTO) {
        return Medicine.builder()
                .id(medicineDTO.getId())
                .userId(medicineDTO.getUserId())
                .name(medicineDTO.getName())
                .build();
    }
}
