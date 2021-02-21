/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.booking.management.system;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.*;
import java.util.*;

public class Trips {

    private int startdate;
    private int enddate;
    private int noofseats = 50;

    public void reservation() throws FileNotFoundException, IOException {
        ObjectOutputStream Stream = new ObjectOutputStream(new FileOutputStream("Reservation.txt", true));
        int seats;
        Trips general = new Trips();
        Trips family = new Trips();
        Trips couple = new Trips();

        System.out.println("Choose type of tour:");

        System.out.println("1. General");
        System.out.println("2. Family");
        System.out.println("3. Couple");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("Enter number of seats:");
            seats = input.nextInt();
            general.noofseats -= seats;
            Stream.writeChars("General");
            Stream.writeInt(seats);
        } else if (choice == 2) {
            System.out.println("Enter number of seats:");
            seats = input.nextInt();
            family.noofseats -= seats;
            Stream.writeChars("Family");
            Stream.writeInt(seats);
        } else if (choice == 3) {
            couple.noofseats -= 2;
            Stream.writeChars("Couple");
            Stream.writeInt(2);
        } else {
            System.out.println("Trip doesn't exist!");
            System.exit(1);
        }
        setStartDate();
        setEndDate();

        Stream.close();

    }

    public void setStartDate() {
        System.out.println("Enter start date:");
        Scanner scanner = new Scanner(System.in);
        String str[] = {"Day", "Month", "Year"};
        String date = "";

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter " + str[i] + ": ");
            date = date + scanner.next() + "/";
        }
        date = date.substring(0, date.length() - 1);
        System.out.println("Date: " + date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    }

    public void setEndDate() {
        System.out.println("Enter end date:");
        Scanner scanner = new Scanner(System.in);
        String str[] = {"Day", "Month", "Year"};
        String date = "";

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter " + str[i] + ": ");
            date = date + scanner.next() + "/";
        }
        date = date.substring(0, date.length() - 1);
        System.out.println("Date: " + date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    }

    public int getStartdate() {
        return startdate;
    }

    public int getEnddate() {
        return enddate;
    }

    public int getNoofseats() {
        return noofseats;
    }

}
