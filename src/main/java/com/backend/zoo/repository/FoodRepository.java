package com.backend.zoo.repository;

import com.backend.zoo.domain.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer> {

    Food findById(int id);
}
