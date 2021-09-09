/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Foods.Foods;
import helper.MenuHelper;
import helper.ScannerCus;
import helper.Validator;
import java.io.IOException;

/**
 *
 * @author Kaine
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MenuHelper menu = new MenuHelper(6);
        Foods list = new Foods();
        menu.add("Add a new food");
        menu.add("Search a food by name");
        menu.add("Remove the food by ID");
        menu.add("Print the food list in the descending order of expired date");
        menu.add("Save Foods to file");
        menu.add("Quit");
        
        ScannerCus sc = new ScannerCus();
        
        if (!list.loadFromFile("food.dat")) {
            System.out.println("load file food.date failed");
        }
        
        int choice;
        do {
                System.out.println("Welcome to Food Management - @ 2021 by Pham Vinh Tai");
                choice = menu.getChoice();
                switch (choice) {
                    case 1: 
                        list.addFood();
                        break;
                    case 2:
                        list.searchFoodByName();
                        break;
                    case 3:
                        list.RemoveFoodByID();
                        break;
                    case 4:
                        list.listSortAndPrint();
                        break;
                    case 5:
                        if (!list.saveToFile(sc.getString(Validator.StringType.STRING, 0, 255, "Enter name file to save (<<file_name>>.dat): ") + ".dat")) {
                            System.out.println("Save file failed");
                        } else {
                            System.out.println("Save file successfully");
                        }
                        break;
                }
        } while (choice != 6);
        
    }
    
}
