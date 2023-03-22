package com.backend.zoo.controller;

import com.backend.zoo.dto.AnimalDto;
import com.backend.zoo.dto.AnimalWithFoodDto;
import com.backend.zoo.dto.requests.CreateAnimalRequest;
import com.backend.zoo.mapper.ZooMapper;
import com.backend.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;
    private final ZooMapper zooMapper;

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public AnimalDto getAnimal(@PathVariable("id") final int id) {
        return zooMapper.ANIMAL_TO_DTO(animalService.findById(id));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<AnimalDto> getAnimals() {
        return zooMapper.ANIMAL_TO_DTO_ITERABLE(animalService.findAll());
    }

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<AnimalWithFoodDto> getAnimalsWithFoods() {
        return zooMapper.ANIMAL_WITH_FOOD_DTO_ITERABLE(animalService.findAll());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AnimalDto createAnimal(@Valid @RequestBody final CreateAnimalRequest request) {
        return zooMapper.ANIMAL_TO_DTO(animalService.createAnimal(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAnimal(@PathVariable("id") final int id) {
        animalService.deleteAnimal(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllAnimals() {
        animalService.deleteAllAnimal();
    }
}
