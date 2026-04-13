# Prog PoE (Chatapp) 
## Student Information:
#### Student Number: ST10501497
#### Project: chatapp PoE (Prog)
#### Institution: Rosebank College

## Description:
Chatapp is a Java-based application made to handle a users registration and login.
The project is focused on ensuring that the user inserts valid information, that must meet specific conditions.
This project is part of my Part 1 for my Programming PoE.

## Features
* **Username Validation:** Ensures that the user only inserts a username that has an underscore (_) and is not longer than five characters.
* **Password Complexity:** Validates that the user password is atleast eight characters long, and contains a capital letter, a number and a special character.
* **Phone Number Validation:** Verifies that the cellphone number includes the South African international code (+27) and also that the number is the correct length.
* **Automated Testing:** Used JUnit 5 to test the validation logic, ensure that the methods work as expected.

## How To Run
1. **Clone or Download** the ZIP, then extract files.
2. **Open** Apache NetBeans and open the project via the **File** tab.
3. **Clean and Build** the project.
4. **Run** the file by clicking the green "play" button.
5. **Test** by right clicking on the project and selecting "Test".

## More
**Loops:**
* **Before** The last-minute add-on I added to the project were loops. at first the program would run and let the user insert credentials that didnt meet the conditions only to inform the user at the end of the registration.
  
* **After** The programme now informs the user that the inserted credintial does not meet the required conditions, and prompts them to insert proper credintials before letting them go into the next step.

* **Example:** If the user inserts a username that doesn't meet the set conditions the programme will prompt them to insert a proper username, and also tell them the conditions that must be met until a proper username is inserted.
