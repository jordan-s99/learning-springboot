package com.jordan.demo.person;

import java.util.List;
import java.util.Objects;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private List<String> favouriteFood;


    // for the json conversion to happen, we need our getters and setters - they're essential!
    // @JsonIgnore - can make it ignore a property

    public Person(Integer id, String name, Integer age, List<String> favouriteFood) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(List<String> favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(favouriteFood, person.favouriteFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, favouriteFood);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", favouriteFood=" + favouriteFood +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
