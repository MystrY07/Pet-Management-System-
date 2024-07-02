package com.petmanagement;

import com.petmanagement.models.Cat;
import com.petmanagement.models.Dog;
import com.petmanagement.models.Animal;
import com.petmanagement.services.PetService;
import com.petmanagement.util.IdGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PetManagementGUI {
    private PetService petService;
    private JFrame frame;
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> typeComboBox;
    private JTextArea outputArea;

    public PetManagementGUI() {
        petService = new PetService();
        initialize();
    }

    private void initialize() {
        // Setup the main frame
        frame = new JFrame("Pet Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Add components to input panel
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Type:"));
        typeComboBox = new JComboBox<>(new String[]{"Dog", "Cat"});
        inputPanel.add(typeComboBox);

        JButton addButton = new JButton("Add Pet");
        inputPanel.add(addButton);

        JButton listButton = new JButton("List Pets");
        inputPanel.add(listButton);

        // Add input panel to frame
        frame.add(inputPanel, BorderLayout.NORTH);

        // Create output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPet();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPets();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    private void addPet() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String type = (String) typeComboBox.getSelectedItem();
        String id = IdGenerator.generateId();

        Animal pet;
        if ("Dog".equals(type)) {
            pet = new Dog(id, name, age);
        } else {
            pet = new Cat(id, name, age);
        }

        petService.addPet(pet);
        outputArea.append("Added: " + pet.getName() + "\n");
    }

    private void listPets() {
        List<Animal> pets = petService.listPets();
        outputArea.append("Listing Pets:\n");
        for (Animal pet : pets) {
            outputArea.append("Pet ID: " + pet.getId() + ", Name: " + pet.getName() + ", Age: " + pet.getAge() + "\n");
            outputArea.append(pet.getName() + " says: ");
            pet.makeSound();
        }
    }

    public static void main(String[] args) {
        new PetManagementGUI();
    }
}
