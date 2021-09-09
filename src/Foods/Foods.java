/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Foods;


import helper.ScannerCus;
import helper.Validator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

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
            if (this.get(i).getID().toUpperCase().equals(ID.toUpperCase())) {
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
 
            Date date = sc.getDate("Enter expired date(yyyy-mm-dd): ");
            
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
            name = name.trim();
            isFound = false;
            for (int i = 1; i < this.size(); i++) {
                if (this.get(i).getName().contains(name)) {
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
    
    public void listSortAndPrint() {
        Food e = null;
        int n = this.size();
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if (this.get(j+1).getDate().compareTo(this.get(j).getDate()) > 0) {
                    e = this.get(j);
                    this.set(j, this.get(j+1));
                    this.set(j+1, e);
                }
            }
        }
        
        for (Food item : this) {
            System.out.println(item.toString());
        }
    }
    
    public void printAllFood() {
        for (int i = 0; i < this.size(); i++){
                System.out.println(this.get(i).toString());
            }
    }
    
    public boolean loadFromFile(String fileName) throws FileNotFoundException, IOException {
        File f = new File(fileName);
        if (!f.exists()) return false;
	FileReader fr = new FileReader(f);
	BufferedReader bf = new BufferedReader(fr);
	String details;
        while ((details = bf.readLine()) != null) {
				StringTokenizer stk = new StringTokenizer(details);
				String ID = stk.nextToken(",").trim();
                                String name = stk.nextToken(",").trim();
                                double weight = Double.parseDouble(stk.nextToken(",").trim());
                                String type = stk.nextToken(",").trim();
                                String place = stk.nextToken(",").trim();
                                Date date = Date.valueOf(stk.nextToken(",").trim());
                                this.add(new Food(ID, name, weight, type, place, date));
			}
        return true;
    }
        
    public boolean saveToFile(String fileName) throws FileNotFoundException, IOException {
		File f = new File(fileName);
		try (PrintWriter out = new PrintWriter(f)) {
			this.forEach(item -> out.println(item.toString()));
		}
		return true;
    }
}