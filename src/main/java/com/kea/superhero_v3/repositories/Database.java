package com.kea.superhero_v3.repositories;
import com.kea.superhero_v3.models.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class Database {
    private ArrayList<Superhero> database = new ArrayList();

    public Database(){
        database.add(new Superhero("Taxman", 35, "Pays no taxes"));
        database.add(new Superhero("Bad-Stomach", 55, "Can give you food posioning"));
        database.add(new Superhero("Seven-Days-of-Summer", 28, "Sets your localdate variables in numerous devices to a random date, requiring BIOS restart"));
    }

    public void addSuperhero(String name, int age, String superpower) {
        Superhero superhero = new Superhero(name, age, superpower);
        database.add(superhero);
    }

    public ArrayList<Superhero> getArrayList () {
        return database;
        /*
        for (int i = 0; i < database.size(); i++) {
            System.out.println(database.get(i));
        }
        return " ";*/
    }

    public Superhero searchSuperhero (String search) {
        for (Superhero s : database) {
            if (s.getName().contains(search)) {
                return s;
            }
        }
        return null;
    }

    public int searchSuperheroDelete (String search) {
        int superheroIndex = 0;
        for (Superhero s : database) {
            if (s.getName().contains(search)) {
                superheroIndex = database.indexOf(s);
            }
        }
        return superheroIndex;
    }

    public void setSuperhero (String search, String newName, int newAge, String newSuperpower) {
        for (Superhero s : database) {
            if (s.getName().contains(search)) {
                s.setName(newName);
                s.setAge(newAge);
                s.setSuperpower(newSuperpower);
            }
        }
    }

    public void deleteSuperhero (String search) {
        database.remove(searchSuperheroDelete(search));
    }
}
