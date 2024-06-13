package com.controlis.salus.repositories;

import com.controlis.salus.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository  extends JpaRepository<Appointment, Integer> {
}
