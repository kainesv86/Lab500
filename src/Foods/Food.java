/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Foods;
import java.sql.Date;
/**
 *
 * @author Kaine
 */
public class Food {
    private final String ID;
    private String name;
    private double weight;
    private String type;
    private String place;
    private Date date;

    public Food(String ID, String name, double weight, String type, String place, Date date) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.date = date;
    }    

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return this.ID + ", " + this.name + ", " + this.weight + ", " + this.type + ", " + this.place + ", " + this.date;
    }
    
    
}
