package com.controlis.salus.dtos;

import lombok.Builder;

@Builder
public record MedicineInsertDto(
        String name
) { }
