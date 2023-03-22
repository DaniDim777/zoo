package com.backend.zoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalWithFoodDto {

    String name;
    List<FoodForAnimalDto> foods;
}
