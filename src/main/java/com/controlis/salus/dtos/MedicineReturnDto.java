package com.controlis.salus.dtos;

import lombok.Builder;

@Builder
public record MedicineReturnDto(
        Integer id,
        String name
) { }