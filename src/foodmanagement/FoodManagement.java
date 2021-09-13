/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagement;

import data.Storage;
import java.util.Scanner;
import ui.Menu;
import util.InputData;

/**
 *
 * @author skpha
 */
public class FoodManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu("Welcome to Food Management - @ 2021 by <SE150968 - Thái Thành Phát >");
        menu.addNewOption("1. Add a new food");
        menu.addNewOption("2. Search a food by name");
        menu.addNewOption("3. Remove the food by ID");
        menu.addNewOption("4. Print the food list in the descending order of expired date");
        menu.addNewOption("5. Store the food list to binary file");
        menu.addNewOption("6. Quit");

        Storage fridge = new Storage();
        Scanner sc = new Scanner(System.in);
        int choice;
        String response;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("You are preparing to "
                                + "input a new food to fridge");
                        fridge.addFood();
                        response = InputData.getString("Do you want to continue to add food?(YES/NO):", "Please input your choice(YES/NO)").toUpperCase();

                    } while (response.startsWith("Y"));

                    break;
                case 2:
                    String foodName;
                    do {
                        System.out.println("You are required to input "
                                + "a Food's Name to search");
                        foodName = InputData.getString("Input food name: ", "The food name is required!");
                        fridge.searchFoodByName(foodName);
                        response = InputData.getString("Do you want to continue to search food?(YES/NO):", "Please input your choice(YES/NO)").toUpperCase();

                    } while (response.startsWith("Y"));

                    break;
                case 3:
                    System.out.println("You are required to input "
                            + "a Food's ID to remove");

                    fridge.removeFoodByID();
                    break;
                case 4:
                    System.out.println("You are preparing to "
                            + "print the food list descending by expired date");
                    fridge.printFoodListDescendingByExpiredDate();
                    break;
                case 5:
                    System.out.println("You are preparing to write the food list to a file");
                    fridge.writeToFile();
                    break;
                case 6:
                    System.out.println("Good bye, see you again!!!");
                    break;
                default:
                    break;
            }

        } while (choice != 6);
    }

}
