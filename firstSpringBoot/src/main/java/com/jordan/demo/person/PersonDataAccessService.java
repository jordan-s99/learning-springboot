package com.jordan.demo.person;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository // another example of just being more specific than @component
// this is a class that interacts with a database
public class PersonDataAccessService {

    // this retrieves/accesses the data
    // @Component tells spring to create an instance of this (in main?) the constructor will know how to inject

    // this would be our database - pretend here that it's a database!

    private List<Person> db = new ArrayList<>();

    public PersonDataAccessService() {
        db.add(new Person(1, "Jordan", 22, List.of("pizza")));
        db.add(new Person(2, "Hudson", 8, List.of("ribs")));
    }

    public List<Person> selectAllPeople(){
        return db;
    }

    public void insertPerson(Person person) {
        db.add(person);
    }



    public void deletePerson(int id) {
        Optional<Person> person = selectAllPeople()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        person.ifPresent(p -> db.remove(p));
    }

    public void updatePerson(int id, Person person) {
        // update person
        // person.setName("");
    }
}
