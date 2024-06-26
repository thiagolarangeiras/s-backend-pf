package com.controlis.salus.dtos;

import lombok.Builder;

@Builder
public record AppointmentUpdateDto(
        Integer availabilityId
) { }
