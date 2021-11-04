package com.jordan.dog;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Repository // the class that interacts with the database
public class DogDataAccessService implements DogDAO {

    private List<Dog> dogs = new ArrayList<>();

    public DogDataAccessService(){
        dogs.add(new Dog(1, "Barley", 2, "Cockapoo", "tennis ball"));
        dogs.add(new Dog(2, "Willow", 1, "Cockapoo", "pink dinosaur"));
        dogs.add(new Dog(3, "Patrick", 2, "Chihuahua", "teething chew"));
    }

    @Override
    public List<Dog> selectAllDogs() {
        return dogs;
    }

    @Override
    public Optional selectDogById(int id) {
        Optional<Dog> doggos = selectAllDogs()
             .stream()
                .filter(d -> d.getId() == id)
                .findFirst();
        return Optional.of(id);
    }

    @Override
    public void insertDog(Dog dog) {
         dogs.add(dog);
    }

    @Override
    public void deleteDog(int id) {
        Optional<Dog> doggoDelete = selectAllDogs()
                .stream()
                .filter(d -> d.getId() == id)
                .findFirst();
    doggoDelete.ifPresent(d -> dogs.remove(d));
    }

    @Override
    public void updateDog(Dog dog) {

    }
}
