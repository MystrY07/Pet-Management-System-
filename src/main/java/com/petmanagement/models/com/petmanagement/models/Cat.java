package com.petmanagement.models;

// Cat class extending Animal
public class Cat extends Animal {
    
    // Constructor to initialize Cat-specific attributes
    public Cat(String id, String name, int age) {
        super(id, name, age);
    }

    // Implementation of the abstract method from Animal
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
