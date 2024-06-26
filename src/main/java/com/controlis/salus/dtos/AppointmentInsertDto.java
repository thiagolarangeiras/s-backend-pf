package com.controlis.salus.dtos;

import lombok.Builder;

@Builder
public record AppointmentInsertDto(
    Integer patientId,
    Integer availabilityId,
    String local
) {

}
