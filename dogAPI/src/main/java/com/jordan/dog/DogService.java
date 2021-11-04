package com.jordan.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogService {

    private DogDAO dogDAO;
    // because in the diagram, this depends on the layer below- the dogDataAccessService( which imeplements DAO so just do that)

    // make constructor for this class
    @Autowired
    public DogService(DogDAO dogDAO) {
        this.dogDAO = dogDAO;
    }
    // so these are calling on the methods we wrote in DogDataAccessService
    public List<Dog> getDogs() {
        return dogDAO.selectAllDogs();
    }

    public void registerDog(Dog dog) {
        dogDAO.insertDog(dog);
    }

    public void deleteDog(int id) {
        dogDAO.deleteDog(id);
    }


    public void updateDog(int id, Dog dog) {
        if (dogDAO.selectAllDogs().contains(id) == true) {
        // this  might have to go in DogDataAccessService ...
        // would i have to use setters for each value of the dog object?
        // id, name, age, breed, favouriteToy
        } else {
            throw new IllegalStateException(
                    "dog with id " + id + " does not exist"
            );
        }
    }

}
