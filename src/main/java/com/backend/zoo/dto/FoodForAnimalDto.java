package com.backend.zoo.dto;

import com.backend.zoo.common.FoodMeasure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodForAnimalDto {

    String name;
    int currentQuantity;
    int consumptionPerDay;
    Integer animal_id;
    FoodMeasure foodMeasure;
}
