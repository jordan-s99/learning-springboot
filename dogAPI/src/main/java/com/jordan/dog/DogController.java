package com.jordan.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DogController {

    private DogService dogService;
    // is a dependency of controller

    @Autowired // is automatic dependency injection
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping // to make a get request
    public List<Dog> getAllDogs() {
        return dogService.getDogs();
    }

//    @GetMapping("{id}")
//    public Dog getDogById(@PathVariable("id") Integer id) {
//        return dogService.getDog(id);
//    }

    @PostMapping
    public void registerDog(@RequestBody Dog dog) {
        dogService.registerDog(dog);
    }

    @DeleteMapping("{id}")
    public void deleteDog(@PathVariable("id") int id) {
        dogService.deleteDog(id);
    }

    @PutMapping({"id"})
    public void updateDog(@PathVariable("id") int id, @RequestBody Dog dog){
        dogService.updateDog(id, dog);
    }
}
