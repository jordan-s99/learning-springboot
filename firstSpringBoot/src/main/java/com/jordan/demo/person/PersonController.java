package com.jordan.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people") // specifying the path as per naming convention
// ^ how to tell spring that this class will be the api layer
public class PersonController {
    // api layer talks to the service class

    private PersonService personService; // personservice is a dependency of personcontroller

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping // need restcontroller when have getmapping
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @PostMapping
    public void registerPerson(@RequestBody Person person) { // take request body and map into person object
        // need to send this to person service
        personService.registerPerson(person);
    }
    // got java to generate all the methods for us - writing method name and then generating

    @DeleteMapping("{id}") // put the path variable in
    public void deletePerson(@PathVariable("id") int id){
        personService.deletePerson(id);
    }

    @PutMapping("{id}")
    public void updatePerson(@PathVariable("id") int id, @RequestBody Person person){
       personService.updatePerson(id, person);

    }
}

// adding a new person through client e.g. through a form submission or something
// POST is to add a new resource
// start with controller (idk if this is mandatory)
