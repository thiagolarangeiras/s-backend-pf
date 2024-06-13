package com.controlis.salus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;


@Entity
@Table(name = "medicine_schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicineSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer userId;
    private Integer medicineId;
    private Time timeBetweenIntakes;
    private int amountToTake;
    private LocalDateTime createDate;
    private LocalDateTime startDate;
}
