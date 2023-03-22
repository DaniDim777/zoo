package com.backend.zoo.mapper;

import com.backend.zoo.domain.Animal;
import com.backend.zoo.domain.Food;
import com.backend.zoo.dto.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ZooMapper {

    AnimalDto ANIMAL_TO_DTO(Animal animal);
    Iterable<AnimalDto> ANIMAL_TO_DTO_ITERABLE(Iterable<Animal> animals);

    FoodDto FOOD_TO_DTO(Food food);
    Iterable<FoodDto> FOOD_TO_DTO_ITERABLE(Iterable<Food> foods);

    AnimalWithFoodDto ANIMAL_WITH_FOOD_DTO(Animal animal);
    Iterable<AnimalWithFoodDto> ANIMAL_WITH_FOOD_DTO_ITERABLE(Iterable<Animal> animals);

    FoodForAnimalDto FOOD_FOR_ANIMAL_DTO(Food food);
    Iterable<FoodForAnimalDto> FOOD_FOR_ANIMAL_DTO_ITERABLE(Iterable<Food> foods);
}
