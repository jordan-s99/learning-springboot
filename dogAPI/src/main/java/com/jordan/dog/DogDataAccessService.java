package com.jordan.dog;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Repository // the class that interacts with the database
public class DogDataAccessService implements DogDAO {

    private final JdbcTemplate jdbcTemplate;
    private List<Dog> dogs = new ArrayList<>();

    public DogDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        // with this template, we can run sql queries against our database
    }

//    public DogDataAccessService(){
//        dogs.add(new Dog(1, "Barley", 2, "Cockapoo", "tennis ball"));
//        dogs.add(new Dog(2, "Willow", 1, "Cockapoo", "pink dinosaur"));
//        dogs.add(new Dog(3, "Patrick", 2, "Chihuahua", "teething chew"));
//    }

    @Override
    public List<Dog> selectAllDogs() {
        var sql = """
                SELECT * FROM doggos limit 5
                """;
        // good practise to set a limit - useful for huge databases
        return jdbcTemplate.query(sql, new DogRowMapper());
        // the rowmapper function was extracted to a class  - much cleaner
//        return dogs;
    }

    @Override
    public Optional<Dog> selectDogById(int id) {
        var sql = """
                SELECT * FROM doggos WHERE
                 id = ?
                """;
        List<Dog> dogs = jdbcTemplate.query(sql, new DogRowMapper(), id);
        return dogs.stream().findFirst();

        // cleaner version:
        // return jdbcTemplate.query(sql, new DogRowMapper(), id).stream().findFirst();

        // note that .query will throw an error if it doesn't exist - so we don't need to write one ( i think that's what he said)

//        Optional<Dog> doggos = selectAllDogs()
//             .stream()
//                .filter(d -> d.getId() == id)
//                .findFirst();
//        return Optional.of(id);
    }

    @Override
    public int insertDog(Dog dog) {
        String sql = """
                INSERT INTO doggos(name, age, breed, favouritetoy) VALUES (?, ?, ?, ?)
                """;
       return jdbcTemplate.update(sql, dog.name, dog.age, dog.breed, dog.favouriteToy);
        //dogs.add(dog);
        // this is for the post request
    }

    @Override
    public int deleteDog(int id) {
        var sql = """
                DELETE FROM doggos 
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);


//        Optional<Dog> doggoDelete = selectAllDogs()
//                .stream()
//                .filter(d -> d.getId() == id)
//                .findFirst();
//    doggoDelete.ifPresent(d -> dogs.remove(d));

    }

    // any modification ( including delete ) requires .update()

    @Override
    public void updateDog(Dog dog) {

    }
}
