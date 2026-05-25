/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/*
 * Handles message creation, validation,and storage.
 */
public class Message {
    
    //variable
    private String messageID;     
    private int messageNumber;     
    private String recipient;      
    private String messageText;    
    private String messageHash;    
    private String sendStatus;      

     
    public Message() {
        this.messageID = "";
        this.messageNumber = 0;
        this.recipient = "";
        this.messageText = "";
        this.messageHash = "";
        this.sendStatus = "";
    }

    /**
     * used during generation in the apps loop.
     */
    public Message(String messageID, int messageNumber, String recipient, String messageText) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.sendStatus = ""; // Populated downstream during user action selection
    }

    //Enables JUnit checks
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }

    public int getMessageNumber() { return messageNumber; }
    public void setMessageNumber(int messageNumber) { this.messageNumber = messageNumber; }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    public String getMessageText() { return messageText; }
    public void setMessageText(String messageText) { this.messageText = messageText; }

    public String getMessageHash() { return messageHash; }
    public void setMessageHash(String messageHash) { this.messageHash = messageHash; }

    public String getSendStatus() { return sendStatus; }
    public void setSendStatus(String sendStatus) { this.sendStatus = sendStatus;} 
    
    /**
     * Saves the current message into a local storage file.
     */
    public void storeMessage() {
        String jsonObject = "{\n" +
                "  \"messageID\": \"" + this.messageID + "\",\n" +
                "  \"messageNumber\": " + this.messageNumber + ",\n" +
                "  \"recipient\": \"" + this.recipient + "\",\n" +
                "  \"messageText\": \"" + this.messageText.replace("\"", "\\\"") + "\",\n" +
                "  \"messageHash\": \"" + this.messageHash + "\",\n" +
                "  \"sendStatus\": \"" + this.sendStatus + "\"\n" +
                "}";

        try (java.io.FileWriter writer = new java.io.FileWriter("messages.json", true)) {
            writer.write(jsonObject + "\n");
        } catch (java.io.IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

   
    public String sentMessage(java.util.Scanner scanner) {
        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");
        System.out.print("Select an option: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid choice. Enter 1, 2, or 3: ");
            scanner.next();
        }
        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1:
                this.sendStatus = "Sent";
                return "Message successfully sent."; 
            case 2:
                this.sendStatus = "Disregarded";
                return "Press 0 to delete the message."; 
            case 3:
                this.sendStatus = "Stored";
                storeMessage(); 
                return "Message successfully stored."; 
            default:
                this.sendStatus = "Disregarded";
                return "Invalid option. Message dropped.";
        }
    }
}