package com.backend.zoo.dto;

import com.backend.zoo.common.FoodMeasure;
import com.backend.zoo.common.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {

    String name;
    FoodType foodType;
    int currentQuantity;
    Integer animal_id;
    FoodMeasure foodMeasure;
}
