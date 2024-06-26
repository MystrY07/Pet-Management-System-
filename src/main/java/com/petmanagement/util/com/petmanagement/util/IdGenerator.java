package com.petmanagement.util;

import java.util.UUID;

// Utility class for generating unique IDs
public class IdGenerator {
    // Method to generate a unique ID
    public static String generateId() {
        return UUID.randomUUID().toString(); // Return a new UUID as a string
    }
}
