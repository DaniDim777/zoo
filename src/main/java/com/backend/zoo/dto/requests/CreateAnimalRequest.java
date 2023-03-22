package com.backend.zoo.dto.requests;

import com.backend.zoo.common.AnimalKind;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAnimalRequest {

    @NotBlank(message = "Can not be empty")
    @Size(min = 2, max = 12)
    String name;

    @NotNull
    AnimalKind animalKind;

    @NotNull
    Boolean isPredator;
}
