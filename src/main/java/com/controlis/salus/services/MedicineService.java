package com.controlis.salus.services;

import com.controlis.salus.dtos.MedicineInsertDto;
import com.controlis.salus.dtos.MedicineReturnDto;
import com.controlis.salus.models.Medicine;
import com.controlis.salus.repositories.MedicineRepository;
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

    public List<MedicineReturnDto> getAllMedicines(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return medicineRepository.findAll(pageable).stream()
                .map(Medicine::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public MedicineReturnDto getMedicineById(Integer id) {
        return medicineRepository.findById(id)
                .map(Medicine::convertEntityToDto)
                .orElse(null);
    }

    public MedicineReturnDto saveMedicine(MedicineInsertDto dto) {
        Medicine medicine = Medicine.convertDtoToEntity(dto);
        medicine = medicineRepository.save(medicine);
        return Medicine.convertEntityToDto(medicine);
    }

    public MedicineReturnDto updateMedicine(Integer id, MedicineInsertDto dto) {
        Medicine medicine = Medicine.convertDtoToEntity(dto);
        medicine.setId(id);
        medicine = medicineRepository.save(medicine);
        return Medicine.convertEntityToDto(medicine);
    }

    public void deleteMedicine(Integer id) {
        medicineRepository.deleteById(id);
    }
}
