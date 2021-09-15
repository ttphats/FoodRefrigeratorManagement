/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import util.InputData;

/**
 *
 * @author SE150968 - Thai Thanh Phat
 */
public class FoodList {

    ArrayList<Food> foodList = new ArrayList();

    private Scanner sc = new Scanner(System.in);

    public void addFood() {
        String ID, name, type, place;
        double weight;
        Date expiredDate;
        int pos;

        do {
            ID = InputData.getID("Input food ID(FXXXXX): ", "The format of ID is FXXXXX (X stands for a digit)", "^[F|f]\\d{5}$");
            pos = searchFoodByID(ID);
            if (pos >= 0) {
                System.out.println("The food ID is already exists. " + "Input another one!");
            }
        } while (pos != -1);

        name = InputData.getString("Input food name: ", "The food name is required!");
        weight = InputData.getADouble("Input food weight: ", "The food weight's format is wrong! Try again!");
        type = InputData.getString("Input food type: ", "The food type is required!");
        place = InputData.getString("Input food place: ", "The food place is required!");
        expiredDate = InputData.getADate("Input a date value yyyy/m/d: ", "Inputted date is invalid! Please try again:");
        foodList.add(new Food(ID, name, weight, type, place, expiredDate));
        System.out.println("A new food is added sucessfully");

    }

    public int searchFoodByID(String foodID) {
        if (foodList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getID().equalsIgnoreCase(foodID)) {
                return i;
            }
        }
        return -1;
    }

    public Food searchFoodObjectByName(String foodName) {
        if (foodList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getName().equalsIgnoreCase(foodName)) {
                return foodList.get(i);
            }
        }
        return null;

    }

    public void searchFoodByName(String foodName) {
        int Count = 0;
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getName().indexOf(foodName) >= 0) {
                System.out.println("Here is the Food "
                        + "that you want to search");
                foodList.get(i).showFood();
                Count++;
            }
        }
        if (Count == 0) {
            System.out.println("This food does not exist!!!");
        }
    }

    public void removeFoodByID() {
        String ID;
        String response;
        int pos;
        ID = InputData.getString("Input Food ID: ", "Food ID is required!");
        pos = searchFoodByID(ID);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Are you sure to remove this food?(YES/NO):");
            response = InputData.getString("Do you want to continue to search food?(YES/NO):", "Please input your choice(YES/NO)").toUpperCase();
            if (response.startsWith("Y")) {
                foodList.remove(pos);
                System.out.println("The selected Food is removed successfully!");
            } else {
                System.out.println("Remove is cancelled!");
            }

        }
    }

    public void printFoodListDescendingByExpiredDate() {
        System.out.println("------------------------------------");
        System.out.println("Here is the food list in fridge");
        String header = String.format("|%-6s|%-15s|%-7s|%-15s|%-15s|%-12s|", "ID", "Name", "Weight", "Type", "Place", "Expired Date");
        System.out.println(header);
        if (foodList.isEmpty()) {
            readFile();
            //System.out.println("The fridge is empty. Nothing to print!");
        }
        Collections.sort(foodList);

        for (int i = 0; i < foodList.size(); i++) {
            foodList.get(i).showFood();
        }

    }

//    public void writeToFile() {
//        String fileName = InputData.getString("Input file's name:", "The file's name is required!!!");
//
//        try {
//            FileWriter fw = new FileWriter(fileName + ".txt");
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            for (Food food : foodList) {
//                bw.write(food.toString());
//                bw.newLine();
//            }
//            bw.close();
//            fw.close();
//            System.out.println("Store the food list to binary file is success");
//
//        } catch (Exception e) {
//            System.out.println("Store the food list to binary file is ERROR! Please try again!");
//        }
//    }
    public void writeToFile() {
        String fileName = InputData.getString("Input file's name:", "The file's name is required!!!");
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            File file = new File(fileName + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for (Food food : foodList) {
                bw.write(food.toString());
                //bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Store the food list to binary file is success");

        } catch (Exception e) {
            System.out.println("Store the food list to binary file is ERROR! Please try again!");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readFile() {
        try {

            FileReader fr = new FileReader("lab1.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
            if ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            if ((foodList.isEmpty()) & (line != null)) {
                System.out.println("The fridge is empty. Nothing to print!");

            }

            fr.close();
            br.close();
        } catch (Exception ex) {
        }
    }

}
