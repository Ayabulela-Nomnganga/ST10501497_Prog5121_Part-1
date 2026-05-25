/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author User
 */
public class Login 
{
    
    /*
    Declaring user login variables
    */
    String username;
    String password;
    String phoneNumber;
    
    public boolean checkUserName(String username)
    {
        return username.contains("_") && username.length() <=5;
    }
    
    public boolean checkPasswordComplexity(String password) 
    {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) 
        {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) 
            {
                hasCapital = true;
            }
            else if (Character.isDigit(c)) 
            {
                hasNumber = true;
            }
            else if (Character.isDigit(c)) 
            {
                hasSpecial = false;
            }
            
            
        }
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }
    
    public boolean checkPhoneNumber(String phone)
    {
        return phone.startsWith("+27") && phone.length() <= 12;
    }
    
    public String registerUser(String username, String password, String phoneNumber)
    {
        if (!checkUserName(username)) 
        {
            return "Username is not correctly formatted; please ensure that your"
                    + " username contains an underscore and is no more than five"
                    + " characters in lengths";
        }
        else if(checkPasswordComplexity(password))
        {
            return "Password is not correctly formatted; please ensure that the"
                    + " password contains at least eight characters, a capital "
                    + " letter, a number, and a special character.";
        }
        else if(checkPhoneNumber(phoneNumber))
        {
            return "Cell phone number incorrectly formatted or does not contain"
                    + " international code.";
        }
        
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        
        return "User registered suceessfully.";
    }
    public boolean loginUser(String username, String password)
    {
    return this.username.equals(username) && this .password.equals(password);
    }
    public String returnLoginStatus(boolean success)
    {
        if(success)
        {
         return "Welcome " + username + " it is great to see you again.";
        }
        else{
         return "Username or password incorrect please try again.";
            }
    }
    
} 
 
 
 
 

