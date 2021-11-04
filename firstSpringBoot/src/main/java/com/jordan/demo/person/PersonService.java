package com.jordan.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // for readability - making it speciic (instead of just calling it a @component - is the same thing)
// it tells spring to create an instance of this class (as a bean)
// so if want to use personservice in another class - pass it in the constructor and use @Autowired
// depending on one instance instead of many
public class PersonService {

    // @component creates a bean of type personservice

    // service layer is responsible for business logic

    private PersonDataAccessService personDataAccessService;

    @Autowired
    public PersonService(PersonDataAccessService personDataAccessService) {
        this.personDataAccessService = personDataAccessService;
    }

    public List<Person> getPeople(){
        return personDataAccessService.selectAllPeople();
    };

    public void registerPerson(Person person) {
        // business logic happens here (if any)
        personDataAccessService.insertPerson(person);
    }

    public void deletePerson(int id){
        // business logic
        // would also have exception handling here too
        personDataAccessService.deletePerson(id);
    }

    public void updatePerson(int id, Person person) {
        personDataAccessService.updatePerson(id, person);
    }
}

// if hundreds of classes depend on person service, you don't want to have to instantiate it all those times - inefficient use of memory in heap
// = have 1 person service and let spring manage that instance for you
// @Autowired = it finds the bean for you (used in PersonController here)
// singleton