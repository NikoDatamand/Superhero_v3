package com.kea.superhero_v3.services;

import com.kea.superhero_v3.SuperheroV3Application;
import com.kea.superhero_v3.models.Superhero;
import com.kea.superhero_v3.repositories.Database;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    private Database superheroDatabase = new Database();

    //Create
    public void addSuperhero(String name, int age, String superpower){
        superheroDatabase.addSuperhero(name, age, superpower);
    }

    //Read
    public ArrayList<Superhero> getSuperheroes(){
        return superheroDatabase.getArrayList();
    }

    public Superhero getSuperhero(String search){
        return superheroDatabase.searchSuperhero(search);
    }

    public Database getSuperheroDatabase() {
        return superheroDatabase;
    }

    //Update
    public void setSuperhero (String search, String newName, int newAge, String newSuperpower) {
        superheroDatabase.setSuperhero(search, newName, newAge, newSuperpower);
    }

    //Delete
    public void deleteSuperhero(String search){
        superheroDatabase.deleteSuperhero(search);
    }
}
