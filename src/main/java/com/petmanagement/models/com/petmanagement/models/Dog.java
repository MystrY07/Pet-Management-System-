package com.petmanagement.models;

// Dog class extending Animal
public class Dog extends Animal {
    public Dog() {}

    // Constructor to initialize Dog-specific attributes
    public Dog(String id, String name, int age) {
        super(id, name, age);
    }

    // Implementation of the abstract method from Animal
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
