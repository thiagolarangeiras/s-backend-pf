package com.controlis.salus.models;

import com.controlis.salus.dtos.MedicineScheduleInsertDto;
import com.controlis.salus.dtos.MedicineScheduleReturnDto;
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

    private Integer patientId;
    private Integer doctorId;
    private Integer medicineId;
    private Time timeBetweenIntakes;
    private Integer amountToTake;

    private LocalDateTime startDate;


    public static MedicineScheduleReturnDto convertEntityToDto(MedicineSchedule schedule) {
        return new MedicineScheduleReturnDto(
                schedule.getId(),
                schedule.getPatientId(),
                schedule.getDoctorId(),
                schedule.getMedicineId(),
                schedule.getTimeBetweenIntakes(),
                schedule.getAmountToTake(),
                schedule.getStartDate()
        );
    }

    public static MedicineSchedule convertDtoToEntity(MedicineScheduleInsertDto dto) {
        return MedicineSchedule.builder()
                .patientId(dto.patientId())
                .doctorId(dto.doctorId())
                .medicineId(dto.medicineId())
                .timeBetweenIntakes(dto.timeBetweenIntakes())
                .amountToTake(dto.amountToTake())
                .startDate(LocalDateTime.now())
                .build();
    }
}