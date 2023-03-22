package com.backend.zoo.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFoodQuantityRequest {

    @NotNull
    int currentQuantity;
}
