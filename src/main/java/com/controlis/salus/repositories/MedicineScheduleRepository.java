package com.controlis.salus.repositories;

import com.controlis.salus.models.MedicineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineScheduleRepository extends JpaRepository<MedicineSchedule, Integer> {
}
