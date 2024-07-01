package com.petmanagement.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petmanagement.models.Animal;
import com.petmanagement.models.Cat;
import com.petmanagement.models.Dog;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PetStorage {
    private static final String FILE_PATH = "pets.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Method to save pets to a file
    public static void savePets(Map<String, Animal> pets) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), pets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load pets from a file
    public static Map<String, Animal> loadPets() {
        try {
            if (!new File(FILE_PATH).exists()) {
                return new HashMap<>();
            }
            Map<String, Animal> pets = objectMapper.readValue(new File(FILE_PATH), new TypeReference<Map<String, Animal>>() {});
            return pets;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
