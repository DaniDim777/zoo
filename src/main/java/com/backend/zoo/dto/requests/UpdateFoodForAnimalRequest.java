package com.backend.zoo.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFoodForAnimalRequest {

    Integer animal_id;
}
