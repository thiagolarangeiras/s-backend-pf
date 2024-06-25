package com.controlis.salus.models;

import com.controlis.salus.dtos.MedicineInsertDto;
import com.controlis.salus.dtos.MedicineReturnDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    //Mappers
    public static MedicineReturnDto convertEntityToDto(Medicine medicine) {
        return new MedicineReturnDto(medicine.getId(), medicine.getName());
    }

    public static Medicine convertDtoToEntity(MedicineInsertDto dto) {
        return Medicine.builder()
                .name(dto.name())
                .build();
    }
}