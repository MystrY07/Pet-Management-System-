package com.petmanagement.models;

// Abstract class representing a general Animal
public abstract class Animal {
    private String id; // Unique identifier for each animal
    private String name; // Name of the animal
    private int age; // Age of the animal

    // Constructor to initialize Animal attributes
    public Animal(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Age
    public int getAge() {
        return age;
    }

    // Abstract method to be implemented by subclasses
    public abstract void makeSound();
}
