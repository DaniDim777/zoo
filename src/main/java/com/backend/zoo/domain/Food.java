package com.backend.zoo.domain;

import com.backend.zoo.common.FoodMeasure;
import com.backend.zoo.common.FoodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"foods\"")
public class Food {

    @Id
    @Column(name = "\"food_id\"", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_sequence")
    @SequenceGenerator(name = "food_sequence", sequenceName = "hibernate_sequence_food", allocationSize = 1)
    private int id;

    @NotBlank
    @Column(name = "\"food_name\"", nullable = false)
    private String name;

    @NotNull
    @Column(name = "\"food_type\"", nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @NotNull
    @Column(name = "\"current_quantity\"", nullable = false)
    private int currentQuantity;

    @NotNull
    @Column(name = "\"measure\"", nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodMeasure foodMeasure;

    private Integer animal_id;

    @Column(name = "\"consumption\"")
    private int consumptionPerDay;

    public Food(@NotBlank String name, @NotNull FoodType foodType, @NotNull int currentQuantity,
                @NotNull FoodMeasure foodMeasure) {
        this.name = name;
        this.foodType = foodType;
        this.currentQuantity = currentQuantity;
        this.foodMeasure = foodMeasure;
    }
}
