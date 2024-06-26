package com.controlis.salus.services;

import com.controlis.salus.dtos.AvailabilityInsertDto;
import com.controlis.salus.dtos.AvailabilityReturnDto;
import com.controlis.salus.models.Availability;
import com.controlis.salus.repositories.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<AvailabilityReturnDto> getAll(int page, int count, Integer medicId) {
        Pageable pageable = PageRequest.of(page, count);
        return availabilityRepository.findAll(pageable).stream()
                .map(Availability::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public AvailabilityReturnDto save(AvailabilityInsertDto dto) {
        Availability availability = Availability.convertDtoToEntity(dto);
        int maxAutoIncrementField = availabilityRepository.findAll()
                .stream()
                .mapToInt(Availability::getWeekDayTimeId)
                .max()
                .orElse(0);

        availability.setWeekDayTimeId(maxAutoIncrementField + 1);
        availability = availabilityRepository.save(availability);
        return Availability.convertEntityToDto(availability);
    }

    public void delete(Integer id) {
        availabilityRepository.deleteById(id);
    }
}
