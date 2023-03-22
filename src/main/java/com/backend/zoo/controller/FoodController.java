package com.backend.zoo.controller;

import com.backend.zoo.dto.FoodDto;
import com.backend.zoo.dto.FoodForAnimalDto;
import com.backend.zoo.dto.requests.CreateFoodRequest;
import com.backend.zoo.dto.requests.UpdateFoodConsumptionRequest;
import com.backend.zoo.dto.requests.UpdateFoodForAnimalRequest;
import com.backend.zoo.dto.requests.UpdateFoodQuantityRequest;
import com.backend.zoo.mapper.ZooMapper;
import com.backend.zoo.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;
    private final ZooMapper zooMapper;

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public FoodDto getFood(@PathVariable("id") final int id) {
        return zooMapper.FOOD_TO_DTO(foodService.findById(id));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<FoodDto> getFoods() {
        return zooMapper.FOOD_TO_DTO_ITERABLE(foodService.findAll());
    }

    public Iterable<FoodForAnimalDto> getNewVisionFood() {
        return zooMapper.FOOD_FOR_ANIMAL_DTO_ITERABLE(foodService.findAll());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FoodDto createFood(@Valid @RequestBody final CreateFoodRequest request) {
        return zooMapper.FOOD_TO_DTO(foodService.createFood(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable("id") final int id) {
        foodService.deleteFood(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllFoods() {
        foodService.deleteAllFoods();
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public FoodDto updateFoodQuantity(@Valid @RequestBody final UpdateFoodQuantityRequest request,
                                      @PathVariable("id") int id) {
        return zooMapper.FOOD_TO_DTO(foodService.updateFoodQuantity(request, id));
    }

    @PutMapping("/cons/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public FoodForAnimalDto updateFoodConsumption(@Valid @RequestBody final UpdateFoodConsumptionRequest request,
                                                  @PathVariable("id") int id) {
        return zooMapper.FOOD_FOR_ANIMAL_DTO(foodService.updateFoodConsumption(request, id));
    }

    @PutMapping("/animal/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public FoodForAnimalDto updateFoodConsumption(@Valid @RequestBody final UpdateFoodForAnimalRequest request,
                                         @PathVariable("id") int id) {
        return zooMapper.FOOD_FOR_ANIMAL_DTO(foodService.updateFoodForAnimal(request, id));
    }
}
