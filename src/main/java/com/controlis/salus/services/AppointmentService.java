package com.controlis.salus.services;

import com.controlis.salus.dtos.AppointmentInsertDto;
import com.controlis.salus.dtos.AppointmentReturnDto;
import com.controlis.salus.dtos.AppointmentUpdateDto;
import com.controlis.salus.models.Appointment;
import com.controlis.salus.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository AppointmentRepository;

    public List<AppointmentReturnDto> getAllDoctor (int page, int count, Integer doctorId) {
        Pageable pageable = PageRequest.of(page, count);
        return AppointmentRepository.findByDoctorId(doctorId, pageable)
                .stream()
                .map(Appointment::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<AppointmentReturnDto> getAllPatient (int page, int count, Integer patientId) {
        Pageable pageable = PageRequest.of(page, count);
        return AppointmentRepository.findByPatientId(patientId, pageable)
                .stream()
                .map(Appointment::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public AppointmentReturnDto save(AppointmentInsertDto dto, Integer doctorId) {
        Appointment appointment = Appointment.convertDtoToEntity(dto);
        appointment.setDoctorId(doctorId);
        appointment = AppointmentRepository.save(appointment);
        return Appointment.convertEntityToDto(appointment);
    }

    public AppointmentReturnDto update(Integer id, AppointmentUpdateDto dto) {
        Appointment appointment = AppointmentRepository.findById(id).orElseThrow();
        Appointment.updateEntityFromDto(appointment, dto);
        appointment = AppointmentRepository.save(appointment);
        return Appointment.convertEntityToDto(appointment);
    }

    public void delete(Integer id) {
        AppointmentRepository.deleteById(id);
    }
}