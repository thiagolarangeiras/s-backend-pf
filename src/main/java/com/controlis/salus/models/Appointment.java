package com.controlis.salus.models;

import com.controlis.salus.dtos.AppointmentInsertDto;
import com.controlis.salus.dtos.AppointmentReturnDto;
import com.controlis.salus.dtos.AppointmentUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer doctorId;
    private Integer patientId;
    private Integer availabilityId;
    private String local;

    //Mappers
    public static AppointmentReturnDto convertEntityToDto(Appointment appointment) {
        return new AppointmentReturnDto(
            appointment.getId(),
            appointment.getDoctorId(),
            appointment.getPatientId(),
            appointment.getAvailabilityId(),
            appointment.getLocal()
        );
    }

    public static Appointment convertDtoToEntity(AppointmentInsertDto dto) {
        return Appointment.builder()
                .patientId(dto.patientId())
                .availabilityId(dto.availabilityId())
                .local(dto.local())
                .build();
    }

    public static void updateEntityFromDto(Appointment appointment, AppointmentUpdateDto dto) {
        if (dto.availabilityId() != null) {
            appointment.setAvailabilityId(dto.availabilityId());
        }
    }
}
