package com.backend.zoo.service;

import com.backend.zoo.domain.Animal;
import com.backend.zoo.dto.requests.CreateAnimalRequest;

import javax.validation.constraints.NotNull;

public interface AnimalService {

    Iterable<Animal> findAll();
    Animal findById(int id);
    Animal createAnimal(@NotNull CreateAnimalRequest request);
    void deleteAnimal(int id);
    void deleteAllAnimal();
}
