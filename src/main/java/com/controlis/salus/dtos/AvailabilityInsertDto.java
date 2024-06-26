package com.controlis.salus.dtos;

import com.controlis.salus.models.enums.WeekDay;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AvailabilityInsertDto(
        Integer medicId,
        WeekDay weekDay,
        String dateTime
) { }