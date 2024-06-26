package com.controlis.salus.repositories;

import com.controlis.salus.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository  extends JpaRepository<Appointment, Integer> {
    Page<Appointment> findByDoctorId(Integer doctorId, Pageable pageable);
    Page<Appointment> findByPatientId(Integer patientId, Pageable pageable);
}
