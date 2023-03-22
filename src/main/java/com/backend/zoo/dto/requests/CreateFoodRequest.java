package com.backend.zoo.dto.requests;

import com.backend.zoo.common.FoodMeasure;
import com.backend.zoo.common.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodRequest {

    @NotBlank(message = "Can not be empty")
    @Size(min = 2, max = 12)
    String name;

    @NotNull
    FoodType foodType;

    @NotNull
    int currentQuantity;

    @NotNull
    FoodMeasure foodMeasure;
}
