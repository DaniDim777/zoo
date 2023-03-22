package com.backend.zoo.domain;

import com.backend.zoo.common.AnimalKind;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"animals\"")
public class Animal {

    @Id
    @Column(name = "\"animal_id\"", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_sequence")
    @SequenceGenerator(name = "animal_sequence", sequenceName = "hibernate_sequence_animal", allocationSize = 1)
    private int id;

    @NotBlank
    @Column(name = "\"animal_name\"", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "\"animal_kind\"", nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalKind animalKind;

    @NotNull
    @Column(name = "\"predator\"", nullable = false)
    private Boolean isPredator;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id")
    private List<Food> foods;

    public Animal(@NotBlank String name, @NotNull AnimalKind animalKind, @NotNull Boolean isPredator) {
        this.name = name;
        this.animalKind = animalKind;
        this.isPredator = isPredator;
    }
}
