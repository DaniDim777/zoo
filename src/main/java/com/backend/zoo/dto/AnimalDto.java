package com.backend.zoo.dto;

import com.backend.zoo.common.AnimalKind;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto {

    String name;
    AnimalKind animalKind;
    Boolean isPredator;
}
