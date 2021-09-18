# Welcome to My Lap211 Java Project - FoodRefrigeratorManagement Project

## You will find in this repo:
# J1.L.P0010



## LAB211 Assignment

  Type: Long Assignment
  
  Code: J1.L.P0010
  
  LOC: 400++
  
  Slot(s): N/A
##Title
	Food management in a refrigerator.
## Background
	Mr. Hoa is a student at FPT University, Faculty of Information Technology. After he had finished the Object-Oriented Programming course, he wanted to build a program to manage the food in his refrigerator. The program must be designed so that management of the food is easy.
## Program Specifications
	You are required to develop a Java program that shows the following menu:
Welcome to Food Management - @ 2021 by <Student ID - Student Name >
Select the options below:
1. Add a new food
2. Search a food by name
3. Remove the food by ID
4. Print the food list in the descending order of expired date
5. Quit
Each menu choice should invoke an appropriate function to perform the selected menu item. Your program must display the menu after each task and wait for the user to select another option until the user chooses to quit the program. Each food has the following information: ID (cannot be modified, cannot be duplicated), name, weight, type, place (where your put this food in refrigerator), expired date. Use collection to food the phones.
# Function details
### 1. Function 1: Show menu – 50 LOC
The program displays a menu and asks users to input an option from 1 to 5.
### 2. Function 2: Build the data structure – 50 LOC
	* Classes, abstract classes, interfaces.
	* Use only one collection to store food.
### 3. Function 3: Add a food to the list – 50 LOC
	* User inputs new food’s information
	* Remember to check the id cannot be duplicated. Other information must be validating.
	* Add the new a food to the collection.
	* After adding, the program asks whether you want to continue adding another food or return to the menu.
### 4. Function 4: Search a phone by name – 50 LOC
	* User inputs the key word want to search. The program returns all food that has name contain the search string.
	* If the food is not existed, the screen shows message “This food does not exist”. Otherwise, the screen shows the foods information.
	* After searching, the program asks if the user wants to continue searching for another food or return to the menu.
### 5. Function 5: Remove the food by ID – 100 LOC
	* User can remove any food in the refrigerator by ID.
	* Before the remove, the program must show confirm message.
	* Show the result of the remove: success or fail.
	* After removing, the program returns to the menu.
### 6. Function 6: Print the food – 50 LOC
	* The program will print the food list in the descending order of expired date.
	* After printing, the program returns to the menu.
### 7. Function 7: Store the food list to binary file – 50 LOC
	* The user enters the file name (<<file_name>>.dat) you want to save.
	* The program will save all information of the phone in the store to the file.
	* After save, the program returns to the menu.
	|F00022|TRAI CAM       |0,80   |TRAI CAY       |NGAN MAT       |2025-01-01  |
	|F11111|CON GA         |4,00   |THIT NAC       |NGAN DONG      |2024-06-06  |
	|F00011|CON CA         |2,40   |DO HOP         |NGAN MAT       |2024-05-06  |
	|F55555|CON HEO        |3,50   |THIT MO        |NGAN DONG      |2023-05-05  |
	|F44444|CON BO         |2,00   |XUONG          |NGAN DONG      |2023-04-04  |
	|F99999|BANH MI        |0,40   |CAT LAT        |NGAN MAT       |2023-01-01  |
	|F66666|CA CHUA        |4,30   |RAU CU         |NGAN MAT       |2022-03-03  |
	|F77777|CAI XANH       |0,50   |RAU CU         |NGAN MAT       |2022-02-02  |
	|F88888|TAO DO         |3,70   |TRAI CAY       |NGAN MAT       |2021-10-10  |


* NetBeans Apache Ant project including JUnit Test
* .gitignore file for NetBeans project
* README.md - this file itself - using Markdown language

### © 2021 ttphats | fb/ttphats01