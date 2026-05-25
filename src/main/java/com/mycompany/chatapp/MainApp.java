/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author User
 */

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // Scanner allows the user to enter information
        Scanner input = new Scanner(System.in);
        
        // Create an object of the Login class so we can call its methods
        Login login = new Login();

        // --- REGISTRATION SECTION ---
        System.out.println("=== USER REGISTRATION ===");

        System.out.print("Enter a username: ");
        String username = input.nextLine();

        System.out.print("Enter a password: ");
        String password = input.nextLine();

        System.out.print("Enter your South African phone number (+27...): ");
        String phone = input.nextLine();

        // Call the registerUser method and store the message it returns
        String response = login.registerUser(username, password, phone);
        
        // Show the registration message
        System.out.println(response);

        // --- LOGIN SECTION ---
        // We only proceed to login if the registration message indicates success
        if (response.equals("User registered successfully.")) {
            System.out.println("\n=== USER LOGIN ===");

            System.out.print("Enter your username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = input.nextLine();

            // Call loginUser to check if details match the stored ones
            boolean loggedIn = login.loginUser(loginUsername, loginPassword);

            // Print out the correct login message
            String loginMessage = login.returnLoginStatus(loggedIn);
            System.out.println(loginMessage);
        }
    }
    /**
     * ChatApp Part 2.
     * Accurately tracks menu input options 1, 2, and 3.
     */
    private static void launchMenu(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            
            System.out.print("Enter your choice: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.next(); 
                continue; 
            }
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    handleSendingMessages(scanner);
                    break;
                    
                case 2:
                    System.out.println("Coming Soon.");
                    break;
                    
                case 3:
                    System.out.println("Thank you for using ChatApp. Goodbye!");
                    running = false; 
                    break;
                    
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

    /**
     * Captures the message size and runs the required loops.
     */
    private static void handleSendingMessages(Scanner scanner) {
        System.out.println("\nHow many messages would you like to send?");
        
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid whole number:");
            scanner.next();
        }
        
        int numMessages = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 0; i < numMessages; i++) {
            int messageNumber = i + 1;
            System.out.println("\n--- Message " + messageNumber + " ---");
            // Validation and logic will hook here in the next step
        }
        
        System.out.println("\nAll " + numMessages + " message slots processed.");
    }
}