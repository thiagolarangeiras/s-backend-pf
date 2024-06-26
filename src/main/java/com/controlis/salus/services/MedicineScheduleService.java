package com.controlis.salus.services;

import com.controlis.salus.dtos.*;
import com.controlis.salus.models.MedicineSchedule;
import com.controlis.salus.repositories.MedicineScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineScheduleService {

    @Autowired
    private MedicineScheduleRepository medicineScheduleRepository;

    public MedicineScheduleReturnDto save(MedicineScheduleInsertDto dto) {
        MedicineSchedule medicineSchedule = MedicineSchedule.convertDtoToEntity(dto);
        medicineSchedule = medicineScheduleRepository.save(medicineSchedule);
        return MedicineSchedule.convertEntityToDto(medicineSchedule);
    }

    public List<MedicineScheduleReturnDto> getAll(Integer patientId, int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return medicineScheduleRepository.findByPatientId(patientId, pageable).stream()
                .map(MedicineSchedule::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public MedicineScheduleReturnDto get(Integer id) {
        return medicineScheduleRepository.findById(id)
                .map(MedicineSchedule::convertEntityToDto)
                .orElse(null);
    }


    public MedicineScheduleReturnDto update(Integer id, MedicineScheduleInsertDto dto) {
        MedicineSchedule medicineSchedule = MedicineSchedule.convertDtoToEntity(dto);
        medicineSchedule.setId(id);
        medicineSchedule = medicineScheduleRepository.save(medicineSchedule);
        return MedicineSchedule.convertEntityToDto(medicineSchedule);
    }

    public void delete(Integer id) {
        medicineScheduleRepository.deleteById(id);
    }
}