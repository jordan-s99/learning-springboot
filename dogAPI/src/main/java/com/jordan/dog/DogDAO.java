package com.jordan.dog;

import java.util.List;
import java.util.Optional;

public interface DogDAO {
    List<Dog> selectAllDogs();
    Optional<Dog> selectDogById(int id);
    void insertDog(Dog dog);
    void deleteDog(int id);
     void updateDog(Dog dog);
}
