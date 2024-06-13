package com.controlis.salus.repositories;

import com.controlis.salus.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
}
