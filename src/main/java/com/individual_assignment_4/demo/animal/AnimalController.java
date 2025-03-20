package com.individual_assignment_4.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public Object getAllAnimals() {
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Object getOneAnimal(@PathVariable int animalId) {
        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.OK);
    }

    /**
     * Get a list of animals by name.
     * http://localhost:8080/animals/name?search=lion
     *
     * @param search the search key.
     * @return list of Animal objects matching the search key.
     */
    @GetMapping("/name")
    public Object getAnimalsByName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getAnimalsByName(search), HttpStatus.OK);
    }

    /**
     * Get a list of animals by specie.
     * http://localhost:8080/animals/specie/whale
     *
     * @param specie the search key.
     * @return a list of Animal objects matching the search key.
     */
    @GetMapping("/specie/{specie}")
    public Object getAnimalsBySpecie(@PathVariable String specie) {
        return new ResponseEntity<>(service.getAnimalsBySpecie(specie), HttpStatus.OK);
    }

    /**
     * Get a list of animals older than a specified age.
     * http://localhost:8080/animals/age?age=5
     *
     * @param age the minimum age.
     * @return list of Animal objects matching the search key.
     */
    @GetMapping("/age")
    public Object getAnimalsByAge(@RequestParam(name = "age", defaultValue = "0") double age) {
        return new ResponseEntity<>(service.getAnimalsByAge(age), HttpStatus.OK);
    }

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new --data '{ "name": "Dave", "specie": "whale", "age": 5}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public Object addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.CREATED);
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/2 --data '{ "animalId": 1, "name": "Mike", "specie": "lizard", "age": 6}'
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new updated Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Object updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.CREATED);
    }

    /**
     * Delete an Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public Object deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }
}

