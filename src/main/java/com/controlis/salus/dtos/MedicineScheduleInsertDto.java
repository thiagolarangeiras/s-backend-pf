package com.controlis.salus.dtos;

import java.sql.Time;
import java.time.LocalDateTime;

public record MedicineScheduleInsertDto(
        Integer patientId,
        Integer doctorId,
        Integer medicineId,
        Time timeBetweenIntakes,
        Integer amountToTake
) { }