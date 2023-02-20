package com.kea.superhero_v3.models;

public class Superhero {

    //Fields
    private String name;
    private int age;
    private String superpower;

    //Constructor
    public Superhero(String name, int age, String superpower) {
        this.name = name;
        this.age = age;
        this.superpower = superpower;
    }

    //GET
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSuperpower() {
        return superpower;
    }

    //SET
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    //ToString
    @Override
    public String toString() {
        return name + " " + age + " " + superpower;
    }
}
