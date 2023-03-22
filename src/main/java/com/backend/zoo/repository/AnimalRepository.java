package com.backend.zoo.repository;

import com.backend.zoo.domain.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

    Animal findById(int id);
}
