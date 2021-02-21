/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.booking.management.system;

import java.util.*;
import java.io.*;

public class Tour_Guide extends USer implements Serializable {

    private double salary;
    private int noOfTrips = 0;
    private boolean available = true;

    public Tour_Guide() {
        super();
    }

    public Tour_Guide(String name,String lastname ,int age, int ID,char gender,int noOfTrips,String available) {
        super(name,lastname,age, ID,gender);
        this.noOfTrips=noOfTrips;
        this.available = (available.equals("Available")?true:false);
    }

    public void setAvailable() {
        available = false;

    }

    public boolean getAvailable() {
        return available;
    }

    public double calcSalary() {
        salary = (noOfTrips * 80) * 0.1;
//0.1= taxes
//80= 3ala kol trip 80 gene
        return salary;
    }

    public void setNum(int noOfTrips) {
        this.noOfTrips = noOfTrips;
    }

    public int getNum() {
        return noOfTrips;
    }
}