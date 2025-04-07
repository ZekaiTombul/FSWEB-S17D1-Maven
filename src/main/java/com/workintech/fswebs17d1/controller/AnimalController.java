package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> getAllAnimals() {
        System.out.println("Developer: " + developerName + ", Course: " + courseName);
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal newAnimal) {
        animals.put(newAnimal.getId(), newAnimal);
        return newAnimal;
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        animals.put(id, updatedAnimal);
        return updatedAnimal;
    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable int id) {
        return animals.remove(id);
    }
}
