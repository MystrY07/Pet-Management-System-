package com.petmanagement.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Abstract class representing a general Animal
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "cat")
})
public abstract class Animal {
    private String id; // Unique identifier for each animal
    private String name; // Name of the animal
    private int age; // Age of the animal

    public Animal() {}

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
