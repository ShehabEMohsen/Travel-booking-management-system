
package travel.booking.management.system;

import java.util.*;
import java.io.*;

public class Admin extends USer implements Serializable {

    private ArrayList<Tour_Guide> Guide = new ArrayList<>();
    private ArrayList<Customer> cust = new ArrayList<>();
    Tour_Guide tg = new Tour_Guide();

    public Admin() {
        super();
    }

    public void addGuide(Tour_Guide tg) {
        Guide.add(tg);

        if (tg.getAge() < 21) {
            System.out.println("Age too low, you have to be 21 or over");
        } else {
            try {
                FileOutputStream out = new FileOutputStream("Guides.txt", true);
                ObjectOutputStream ob = new ObjectOutputStream(out);
                ob.writeObject(Guide);
                System.out.println("Tour Guide added");
                ob.close();
            } catch (IOException ex) {
                System.out.println("Error!");
                ex.printStackTrace();
            }
        }

    }

    public void editGuide() throws IOException, FileNotFoundException, ClassNotFoundException {
        //Main(
        displayG();
        Scanner input = new Scanner(System.in);
        System.out.print("Choose which Guide you want to edit: ");
        int choice = input.nextInt();
        //)
        System.out.print("Enter the new name: ");
        String newName = input.next();
         System.out.print("Enter the new last name: ");
        String newlastName = input.next();
        System.out.print("Enter new age: ");
        int newAge = input.nextInt();
        System.out.print("Enter new ID: ");
        int newID = input.nextInt();
        System.out.println("enter gender: m , f:");
        char newgen =input.next().charAt(0);
        Tour_Guide tg = new Tour_Guide(newName,newlastName, newAge, newID,newgen,3,"Yes");
        Guide.set(choice - 1, tg);//law masalan 1 haighiaro w yehot el object elgedid w -1 one yegeeb index zero
        try {
            FileOutputStream out = new FileOutputStream("Guides.txt");
            ObjectOutputStream ob = new ObjectOutputStream(out);
            ob.writeObject(Guide);
            ob.close();
        } catch (IOException ex) {
            System.out.println("Error!");
            ex.printStackTrace();
        }

    }

    public void deleteGuide() throws IOException, FileNotFoundException, ClassNotFoundException {
        displayG();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which guide you want to delete: ");
        int choice = input.nextInt();
        Guide.remove(choice - 1);// ymsah el guide
        try {
            FileOutputStream out = new FileOutputStream("Guides.txt");
            ObjectOutputStream ob = new ObjectOutputStream(out);
            ob.writeObject(Guide);
            ob.close();
        } catch (IOException ex) {
            System.out.println("Error!");
            ex.printStackTrace();
        }
    }

    public void displayG() {//display kolohom
        
        System.out.println("no. name\tage\tID");
        System.out.println("========================");
        for (int i = 0; i < Guide.size(); i++) {

            System.out.println((i + 1) + ". " + Guide.get(i) + " ");
        }
    }

    public void displayGuide() throws IOException, FileNotFoundException, ClassNotFoundException {
        //display wahed bas
        Scanner input = new Scanner(System.in);
        displayG();
        System.out.println("Choose which guide you want to display: ");
        int choice = input.nextInt();
        System.out.println(Guide.get(choice - 1));
    }

    public void addCustomer(Customer c) {
        cust.add(c);

        if (c.getAge() < 18) {
            System.out.println("The age is too low, you have ot be 18 or over!");
        } else {
            try {
                FileOutputStream out = new FileOutputStream("Customers.txt", true);
                ObjectOutputStream ob = new ObjectOutputStream(out);
                ob.writeObject(cust);
                System.out.println("Customer added");
                ob.close();
            } catch (IOException ex) {
                System.out.println("Error!");
                ex.printStackTrace();
            }
        }
    }

    public void editCustomer() {
        //Main(
        displayC();
        Scanner input = new Scanner(System.in);
        System.out.print("Choose which Customer you want to edit: ");
        int choice = input.nextInt();
        //)
        System.out.print("Enter the new name: ");
        String newName = input.next();
         System.out.print("Enter the new last name: ");
        String newlastName = input.next();
        System.out.print("Enter new age: ");
        int newAge = input.nextInt();
        System.out.print("Enter new ID: ");
        int newID = input.nextInt();
        System.out.println("enter gender: m , f:");
        char newgen =input.next().charAt(0);
        Customer c = new Customer(newName,newlastName, newAge, newID,newgen);
        cust.set(choice - 1, c);
        try {
            FileOutputStream out = new FileOutputStream("Customer.txt");
            ObjectOutputStream ob = new ObjectOutputStream(out);
            ob.writeObject(cust);
            ob.close();
        } catch (IOException ex) {
            System.out.println("Error!");
            ex.printStackTrace();
        }
    }

    public void deleteCustomer() {
        displayC();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which customer you want to delete: ");
        int choice = input.nextInt();
        cust.remove(choice - 1);
        try {
            FileOutputStream out = new FileOutputStream("Customer.txt");
            ObjectOutputStream ob = new ObjectOutputStream(out);
            ob.writeObject(cust);
            ob.close();
        } catch (IOException ex) {
            System.out.println("Error!");
            ex.printStackTrace();
        }
    }

    public void displayC() {
        System.out.println("no. name\tage\tID");
        System.out.println("========================");
        for (int i = 0; i < cust.size(); i++) {
            
            System.out.println((i + 1) + ". " + cust.get(i) + " ");
        }
    }

    public void displayCustomer() {
        Scanner input = new Scanner(System.in);
        displayC();
        System.out.println("Choose which Customer you want to display: ");
        int choice = input.nextInt();
        System.out.println(cust.get(choice - 1));
    }

    public ArrayList<Tour_Guide> guidesAvailable() { //betshof fi kam guide available
        ArrayList<Tour_Guide> avGuide = new ArrayList<>();
        for (int i = 0; i < Guide.size(); i++) {
            if (Guide.get(i).getAvailable() == true) {
                avGuide.add(Guide.get(i));
            }
        }
        return avGuide;
    }
}
