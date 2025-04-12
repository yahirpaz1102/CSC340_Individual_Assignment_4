package com.Assignment5.MVC.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



//@RestController
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     */
    @GetMapping("/all")
    public Object getAllAnimals(Model model) {
        // return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/1
     */
    @GetMapping("/{animalId}")
    public Object getOneAnimal(@PathVariable int animalId, Model model) {
        // return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.OK);
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", "Animal #" + animalId);
        return "animal-details";
    }

    /**
     * Search animals by name.
     * http://localhost:8080/animals/name?search=Jeff
     */
    @GetMapping("/name")
    public Object getAnimalsByName(@RequestParam(name = "search", defaultValue = "") String search, Model model) {
        model.addAttribute("animalList", service.getAnimalsByName(search));
        model.addAttribute("title", "Search by Name: " + search);
        return "animal-list";
    }

    /**
     * Search animals by specie.
     * http://localhost:8080/animals/specie/Giraffe
     */
    @GetMapping("/specie/{specie}")
    public Object getAnimalsBySpecie(@PathVariable String specie, Model model) {
        model.addAttribute("animalList", service.getAnimalsBySpecie(specie));
        model.addAttribute("title", "Animals by Specie: " + specie);
        return "animal-list";
    }

    /**
     * Search animals by age.
     * http://localhost:8080/animals/age?age=5
     */
    @GetMapping("/age")
    public Object getAnimalsByAge(@RequestParam(name = "age", defaultValue = "0") double age, Model model) {
        model.addAttribute("animalList", service.getAnimalsByAge(age));
        model.addAttribute("title", "Animals older than " + age);
        return "animal-list";
    }

    /**
     * Show the view for creating a new animal.
     * http://localhost:8080/animals/createForm
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("title", "Create New Animal");
        return "animal-create";
    }

    /**
     * Create a new animal (POST).
     * http://localhost:8080/animals/new
     */
    @PostMapping("/new")
    public Object addNewAnimal(Animal animal) {
        service.addNewAnimal(animal);
        // return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.CREATED);
        return "redirect:/animals/all";
    }

    /**
     * Show the view to update an animal.
     * http://localhost:8080/animals/update/1
     */
    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", "Update Animal");
        return "animal-update";
    }

    /**
     * Update an existing animal (POST).
     * http://localhost:8080/animals/update/1
     */
    @PostMapping("/update/{animalId}")
    public Object updateAnimal(@PathVariable int animalId, Animal animal) {
        service.updateAnimal(animalId, animal);
        // return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.CREATED);
        return "redirect:/animals/" + animalId;
    }

    /**
     * Delete an animal (GET).
     * http://localhost:8080/animals/delete/1
     */
    @GetMapping("/delete/{animalId}")
    public Object deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        // return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
        return "redirect:/animals/all";
    }
}

