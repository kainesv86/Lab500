/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Foods;


import helper.ScannerCus;
import helper.Validator;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Kaine
 */
public class Foods extends ArrayList<Food> {

    public Foods(int i) {
        super(i);
    }

    public Foods() {
    }

    public Foods(Collection<? extends Food> clctn) {
        super(clctn);
    }
    
    public Food searchFoodByID(String ID) {
        ID = ID.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().toUpperCase().equals(ID)) {
                return this.get(i);
            }
        }
        return null;
    }
    
    public void addFood() {
        boolean choice = true;
        ScannerCus sc = new ScannerCus();
        do {
            String ID;
            boolean isExist;
            do {
                ID = sc.getString(Validator.StringType.STRING, 0, 255, "Enter ID: ");
                isExist = this.searchFoodByID(ID) != null;
                if (isExist) {
                    System.out.println("ID is dulicate");
                }
            } while (isExist);
            
            String name = sc.getString(Validator.StringType.STRING, 0, 255, "Enter name: ");
            double weight = sc.getDouble(0, Double.MAX_VALUE, "Invalid value", "Enter weight:");
            String type = sc.getString(Validator.StringType.STRING, 0, 255, "Enter type: ");
            String place = sc.getString(Validator.StringType.STRING, 0, 255, "Enter place: ");
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            
            this.add(new Food(ID, name, weight, type, place, date));
            System.out.println("Do you want to add another food");
            choice = sc.getBoolean();
        } while (choice == true);
    }
    
    public void searchFoodByName() {
        ScannerCus sc = new ScannerCus();
        boolean choice = true;
        boolean isFound;
        do {
            String name = sc.getString(Validator.StringType.STRING, 0, 255, "Enter food for search: ");
            isFound = false;
            for (int i = 1; i < this.size(); i++) {
                if (this.get(i).getName().indexOf(name) >= 0) {
                    System.out.println(this.get(i).toString());
                    isFound = true;
                }
            }
            if (!isFound) {
                System.out.println("Food not found");
            }
            System.out.println("Do you want to continues to search?");
            choice = sc.getBoolean();
        } while (choice == true);
    }
    
    public void RemoveFoodByID() {
        ScannerCus sc = new ScannerCus();
        Food e = searchFoodByID(sc.getString(Validator.StringType.STRING, 0, 255, "Enter ID to remove: "));
        boolean isConfirm = false;
        if (e != null) {
            System.out.println("Are you sure to remove it?");
            isConfirm = sc.getBoolean();
            if (isConfirm) {
                this.remove(e);
                System.out.println("Remove successfully");
            } else {
                System.out.println("Remove failed");
            }
            return;
        }
        System.out.println("Food not found");
    }
    
    public void listSort() {
        Food e = null;
        int n = this.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (this.get(i).getDate().compareTo(this.get(j).getDate()) > 0) {
                    e = this.get(i);
                    this.set(i, this.get(j));
                    this.set(j, e);
                }
            }
        }
    }
    
    public void printAllFood() {
        for (int i = 0; i < this.size(); i++){
                System.out.println(this.get(i).toString());
            }
    }
}