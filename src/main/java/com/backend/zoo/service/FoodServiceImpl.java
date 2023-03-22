package com.backend.zoo.service;

import com.backend.zoo.domain.Food;
import com.backend.zoo.dto.requests.CreateFoodRequest;
import com.backend.zoo.dto.requests.UpdateFoodConsumptionRequest;
import com.backend.zoo.dto.requests.UpdateFoodForAnimalRequest;
import com.backend.zoo.dto.requests.UpdateFoodQuantityRequest;
import com.backend.zoo.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {

    @PersistenceContext
    private EntityManager entityManager;

    private final FoodRepository foodRepository;

    @Override
    public Iterable<Food> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Food> query = builder.createQuery(Food.class);
        query.select(query.from(Food.class)).distinct(true);
        return entityManager.createQuery(query).setMaxResults(4).getResultList();
    }

    @Override
    public Food findById(int id) {
        return foodRepository.findById(id);
    }

    @Transactional
    @Override
    public Food createFood(@NotNull CreateFoodRequest request) {
        Food food = foodRepository.save(new Food(request.getName(),
                request.getFoodType(), request.getCurrentQuantity(),
                request.getFoodMeasure()));
        return food;
    }

    @Transactional
    @Override
    public void deleteFood(int id) {
        Food food = foodRepository.findById(id);
        foodRepository.delete(food);
    }

    @Transactional
    @Override
    public void deleteAllFoods() {
        foodRepository.deleteAll();
    }

    @Transactional
    @Override
    public Food updateFoodQuantity(@NotNull UpdateFoodQuantityRequest request, int id) {
        Food food = foodRepository.findById(id);
        food.setCurrentQuantity(request.getCurrentQuantity());
        return foodRepository.save(food);
    }

    @Transactional
    @Override
    public Food updateFoodConsumption(@NotNull UpdateFoodConsumptionRequest request, int id) {
        Food food = foodRepository.findById(id);
        food.setConsumptionPerDay(request.getConsumptionPerDay());
        return foodRepository.save(food);
    }

    @Transactional
    @Override
    public Food updateFoodForAnimal(@NotNull UpdateFoodForAnimalRequest request, int id) {
        Food food = foodRepository.findById(id);
        food.setAnimal_id(request.getAnimal_id());
        return foodRepository.save(food);
    }
}
