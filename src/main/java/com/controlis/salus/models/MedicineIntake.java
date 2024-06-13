package com.controlis.salus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "medicine_intakes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicineIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer medicineIntakeId;
    private LocalDateTime intakeDateTime;
    private Boolean inTime;
}
