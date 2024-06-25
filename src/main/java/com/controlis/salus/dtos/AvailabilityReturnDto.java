package com.controlis.salus.dtos;

import com.controlis.salus.models.enums.WeekDay;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AvailabilityReturnDto(
        Integer id,
        Integer weekDayTimeId,
        Integer medicId,
        WeekDay weekDay,
        LocalDateTime dateTime
) { }