package com.controlis.salus.dtos;

import lombok.Builder;

@Builder
public record AppointmentReturnDto(
    Integer id;
    Integer doctorId;
    Integer patientId;
    Integer availabilityId;
    String local;
) {

}
