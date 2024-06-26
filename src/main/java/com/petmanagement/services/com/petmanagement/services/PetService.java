package com.petmanagement.services;

import com.petmanagement.models.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

// Service class to manage pets
public class PetService {
    private final Map<String, Animal> pets = new HashMap<>(); // Store pets using a Map
    private final ReentrantLock lock = new ReentrantLock(); // Lock for thread-safe operations

    // Method to add a pet
    public void addPet(Animal pet) {
        lock.lock(); // Acquire lock
        try {
            pets.put(pet.getId(), pet); // xAdd pet to the map
        } finally {
            lock.unlock(); // Release lock
        }
    }

    // Method to remove a pet
    public void removePet(String id) {
        lock.lock(); // Acquire lock
        try {
            pets.remove(id); // Remove pet from the map
        } finally {
            lock.unlock(); // Release lock
        }
    }

    // Method to get a pet by ID
    public Animal getPet(String id) {
        return pets.get(id); // Return pet from the map
    }

    // Method to list all pets
    public List<Animal> listPets() {
        return new ArrayList<>(pets.values()); // Return list of all pets
    }
}
