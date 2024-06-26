package com.controlis.salus.services;

import com.controlis.salus.dtos.AppointmentInsertDto;
import com.controlis.salus.dtos.AppointmentReturnDto;
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
        return AppointmentRepository.findAllByDoctorId(doctorId, pageable)
                .stream()
                .map(Appointment::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<AppointmentReturnDto> getAllPatient (int page, int count, Integer patientId) {
        Pageable pageable = PageRequest.of(page, count);
        return AppointmentRepository.findAllByPatientId(patientId, pageable)
                .stream()
                .map(Appointment::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public AppointmentReturnDto saveAppointment(AppointmentInsertDto dto) {
        Appointment Appointment = Appointment.convertDtoToEntity(dto);
        Appointment = AppointmentRepository.save(Appointment);
        return Appointment.convertEntityToDto(Appointment);
    }

    public AppointmentReturnDto updateAppointment(Integer id, AppointmentUpdateDto dto) {
        Appointment Appointment = AppointmentRepository.findById(id).orElseThrow();
        Appointment.updateEntityFromDto(dto);
        Appointment = AppointmentRepository.save(Appointment);
        return Appointment.convertEntityToDto(Appointment);
    }

    public void deleteAppointment(Integer id) {
        AppointmentRepository.deleteById(id);
    }
}
