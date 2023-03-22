package com.backend.zoo.service;

import com.backend.zoo.domain.Food;
import com.backend.zoo.dto.requests.CreateFoodRequest;
import com.backend.zoo.dto.requests.UpdateFoodConsumptionRequest;
import com.backend.zoo.dto.requests.UpdateFoodForAnimalRequest;
import com.backend.zoo.dto.requests.UpdateFoodQuantityRequest;

import javax.validation.constraints.NotNull;

public interface FoodService {

    Iterable<Food> findAll();
    Food findById(int id);
    Food createFood(@NotNull CreateFoodRequest request);
    void deleteFood(int id);
    void deleteAllFoods();
    Food updateFoodQuantity(@NotNull UpdateFoodQuantityRequest request, int id);
    Food updateFoodConsumption(@NotNull UpdateFoodConsumptionRequest request, int id);
    Food updateFoodForAnimal(@NotNull UpdateFoodForAnimalRequest request, int id);
}
