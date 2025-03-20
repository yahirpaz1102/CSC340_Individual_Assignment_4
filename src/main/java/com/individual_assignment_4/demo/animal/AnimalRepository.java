package com.individual_assignment_4.demo.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions for Animal.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {


    List<Animal> getAnimalsBySpecie(String specie);


    @Query(value = "select * from animals a where a.age >= ?1", nativeQuery = true)
    List<Animal> getAnimalsByAge(double age);


    @Query(value = "select * from animals a where a.name like %?1%", nativeQuery = true)
    List<Animal> getAnimalsByName(String name);
}

