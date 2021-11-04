package com.jordan.dog;

import java.util.Objects;

public class Dog {

    public Integer id;
    public String name;
    public Integer age;
    public String breed;
    public String favouriteToy;

    public Dog(Integer id, String name, Integer age, String breed, String favouriteToy) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.favouriteToy = favouriteToy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFavouriteToy() {
        return favouriteToy;
    }

    public void setFavouriteToy(String favouriteToy) {
        this.favouriteToy = favouriteToy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(id, dog.id) && Objects.equals(name, dog.name) && Objects.equals(age, dog.age) && Objects.equals(breed, dog.breed) && Objects.equals(favouriteToy, dog.favouriteToy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, breed, favouriteToy);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", favouriteToy='" + favouriteToy + '\'' +
                '}';
    }
}
