package com.backend.zoo.service;

import com.backend.zoo.domain.Animal;
import com.backend.zoo.dto.requests.CreateAnimalRequest;
import com.backend.zoo.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public Iterable<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findById(int id) {
        return animalRepository.findById(id);
    }

    @Transactional
    @Override
    public Animal createAnimal(@NotNull CreateAnimalRequest request) {
        Animal animal = animalRepository.save(new Animal(request.getName(),
                request.getAnimalKind(), request.getIsPredator()));
        return animal;
    }

    @Transactional
    @Override
    public void deleteAnimal(int id) {
        Animal animal = animalRepository.findById(id);
        animalRepository.delete(animal);

    }

    @Transactional
    @Override
    public void deleteAllAnimal() {
        animalRepository.deleteAll();
    }

}
