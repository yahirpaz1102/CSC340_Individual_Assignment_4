package com.individual_assignment_4.demo.animal;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specie;

    private double age;


    public Animal(int animalId, String name, String specie, double age) {
        this.animalId = animalId;
        this.name = name;
        this.specie = specie;
        this.age = age;
    }


    public Animal(String name, String specie, double age) {
        this.name = name;
        this.specie = specie;
        this.age = age;
    }


    public Animal() {
    }


    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}

