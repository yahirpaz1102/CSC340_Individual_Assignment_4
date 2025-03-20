package com.individual_assignment_4.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Centralizes data access to the Animal Database.
 */
@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    /**
     * Fetch all Animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Fetch a unique Animal.
     *
     * @param animalId the unique Animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all animals whose specie matches the search term.
     *
     * @param specie the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsBySpecie(String specie) {
        return animalRepository.getAnimalsBySpecie(specie);
    }

    /**
     * Fetch all animals older than the given age.
     *
     * @param age the minimum age.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByAge(double age) {
        return animalRepository.getAnimalsByAge(age);
    }

    /**
     * Fetch all animals with a name that contains the given string.
     *
     * @param name the search name.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByName(String name) {
        return animalRepository.getAnimalsByName(name);
    }

    /**
     * Add a new Animal to the database.
     *
     * @param animal the new Animal to add.
     */
    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    /**
     * Update an existing Animal.
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new Animal details.
     */
    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setSpecie(animal.getSpecie());
        existing.setAge(animal.getAge());


        animalRepository.save(existing);
    }

    /**
     * Delete a unique Animal.
     *
     * @param animalId the unique Animal Id.
     */
    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}

