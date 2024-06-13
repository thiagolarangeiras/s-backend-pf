package com.controlis.salus.repositories;

import com.controlis.salus.models.MedicineIntake;
import com.controlis.salus.models.MedicineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineIntakeRepository extends JpaRepository<MedicineIntake, Integer> {
}
