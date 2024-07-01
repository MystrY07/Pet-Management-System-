package com.petmanagement.services;

import com.petmanagement.models.Animal;
import com.petmanagement.util.PetStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

// Service class to manage pets
public class PetService {
    private final Map<String, Animal> pets;
    private final ReentrantLock lock = new ReentrantLock();

    public PetService() {
        // Load pets from storage
        this.pets = PetStorage.loadPets();
    }

    // Method to add a pet
    public void addPet(Animal pet) {
        lock.lock();
        try {
            pets.put(pet.getId(), pet);
            PetStorage.savePets(pets); // Save pets to storage
        } finally {
            lock.unlock();
        }
    }

    // Method to remove a pet
    public void removePet(String id) {
        lock.lock();
        try {
            pets.remove(id);
            PetStorage.savePets(pets); // Save pets to storage
        } finally {
            lock.unlock();
        }
    }

    // Method to get a pet by ID
    public Animal getPet(String id) {
        return pets.get(id);
    }

    // Method to list all pets
    public List<Animal> listPets() {
        return new ArrayList<>(pets.values());
    }
}
