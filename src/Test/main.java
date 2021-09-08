/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Foods.Foods;
import helper.MenuHelper;

/**
 *
 * @author Kaine
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuHelper menu = new MenuHelper(5);
        Foods list = new Foods();
        menu.add("Add a new food");
        menu.add("Search a food by name");
        menu.add("Remove the food by ID");
        menu.add("Print the food list in the= descending order of expired date");
        menu.add("Quit");
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
                        list.listSort();
                        list.printAllFood();
                        break;
                }
        } while (choice != 5);
    }
    
}
