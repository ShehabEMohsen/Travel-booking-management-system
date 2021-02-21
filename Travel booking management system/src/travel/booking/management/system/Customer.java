/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.booking.management.system;

import java.util.*;
import java.io.*;

public class Customer extends USer implements Serializable {

    ArrayList<Ticket> list1 = new ArrayList<>();
    private int NoOfTrips;

    public Customer() {
        super();
    }

    public Customer(String name,String lastname, int age, int ID,char gender) {
        super(name,lastname, age, ID,gender);
    }

    public int getNoOfTrips() {
        return NoOfTrips;
    }

    public void setNoOfTrips(int NoOfTrips) {
        this.NoOfTrips = NoOfTrips;
    }

    public void booking() throws IOException, ClassNotFoundException {

        Ticket t = new Ticket();

        list1.add(new Ticket("Platinium", 200));
        list1.add(new Ticket("Gold", 150));
        list1.add(new Ticket("Silver", 100));

        System.out.println("View customer details:");
        System.out.println(this.toString());

        for (int i = 0; i < list1.size(); i++) {
            System.out.println((i + 1) + " " + list1.get(i).getType() + "\t" + list1.get(i).getPrice());
        }
        System.out.println("Choose type of ticket:");

        Scanner input = new Scanner(System.in);
        int y = input.nextInt();
        System.out.println("How many trips to book?");
        int x = input.nextInt();
        setNoOfTrips(x);
        double price = Discount(list1.get(y - 1).getPrice()) * x;
        System.out.println("Your payment is " + price);
        double pay = input.nextDouble();
        if (pay < price) {
            System.out.println("Payment insufficiant.");
        } else if (pay > price) {
            double change = pay - price;
            System.out.println("Payment complete, Change: " + change);
            System.out.println("Booking is successful");
        } else {
            System.out.println("Payment complete.");
            System.out.println("Booking is successful");
        }

        ObjectOutputStream Stream = new ObjectOutputStream(new FileOutputStream("Reservation.txt", true));
        Stream.writeObject(this.toString() + list1.get(y).getType() + list1.get(y).getPrice());

        Stream.close();

    }

    public int Discount(int x) {
        double dis;
        if (NoOfTrips > 2) {
            System.out.println("Discount recieved");
            dis = x * 0.2;
            x -= dis;
            return x;
        } else {
            System.out.println("No discount recieved");
            return x;
        }
    }
}


