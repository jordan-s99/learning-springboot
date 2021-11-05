package com.jordan.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    // in Nelson's he checks for the dog's existence first - and if not, throws exceptions - but mine isn't working!! 


    public Optional<Dog> selectDogById(int id) {
        return dogDAO.selectDogById(id);
//                .orElseThrow(() => new NotFoundException(String.format("Movie with id %s not found", id)));
    }

    public void updateDog(int id, Dog dog) {
//        if (dogDAO.selectAllDogs().contains(id) == true) {
//            // this  might have to go in DogDataAccessService ...
//            // would i have to use setters for each value of the dog object?
//            // id, name, age, breed, favouriteToy
//        } else {
//            throw new IllegalStateException(
//                    "dog with id " + id + " does not exist"
//            );
        }
    }


//    public Dog getDog(Integer id) {
//        return dogDAO.selectDogById(id);
//};
