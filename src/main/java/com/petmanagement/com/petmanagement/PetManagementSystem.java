package com.petmanagement;

import com.petmanagement.models.*;
import com.petmanagement.services.PetService;
import com.petmanagement.util.IdGenerator;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Main class to run the Pet Management System
public class PetManagementSystem {
    public static void main(String[] args) {
        PetService petService = new PetService(); // Create an instance of PetService

        // Using ExecutorService for concurrency
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Runnable task to add a Dog
        executor.execute(() -> {
            String id = IdGenerator.generateId(); // Generate unique ID
            Dog dog = new Dog(id, "Bonk", 3); // Create new Dog instance
            petService.addPet(dog); // Add dog to the service
            System.out.println("Added: " + dog.getName());
        });

        // Runnable task to add a Cat
        executor.execute(() -> {
            String id = IdGenerator.generateId(); // Generate unique ID
            Cat cat = new Cat(id, "Bobol", 2); // Create new Cat instance
            petService.addPet(cat); // Add cat to the service
            System.out.println("Added: " + cat.getName());
        });

        executor.shutdown(); // Shut down the executor

        // Wait for executor to finish tasks
        while (!executor.isTerminated()) {
            // Loop until all tasks are finished
        }

        // List all pets after the tasks are complete
        List<Animal> pets = petService.listPets();
        pets.stream().forEach(pet -> {
            System.out.println("Pet ID: " + pet.getId() + ", Name: " + pet.getName() + ", Age: " + pet.getAge());
            pet.makeSound(); // Make the pet sound
        });
    }
}
