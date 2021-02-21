/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.booking.management.system;

import java.io.*;
import java.util.ArrayList;
import static java.util.Collections.list;


public class Files {
    public static ArrayList <Customer> readcus() throws FileNotFoundException, IOException, ClassNotFoundException{
       ArrayList <Customer> list= new ArrayList();
       FileInputStream input = new FileInputStream("Customer.txt");
       ObjectInputStream ois= new ObjectInputStream(input);

        list = (ArrayList<Customer>)ois.readObject();

      
        return list;
    }
    public static void writecus  (ArrayList <Customer> write ) throws IOException, FileNotFoundException, ClassNotFoundException{
       ArrayList <Customer> list= new ArrayList();
        try{
        list=  readcus();
               }
        finally{
       write.addAll(list);
       ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("Customer.txt"));
       oos.writeObject(write);
       oos.close();
       } 
    }
     public static ArrayList <Tour_Guide> readguide() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList <Tour_Guide> list= new ArrayList();
        FileInputStream input = new FileInputStream("TourGuides.txt");
        ObjectInputStream ois= new ObjectInputStream(input);

        list = (ArrayList<Tour_Guide>)ois.readObject();


        return list;
    }
    public static void writeguide(ArrayList <Tour_Guide> write ) throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayList <Tour_Guide> list= new ArrayList();
        try{
            list=  readguide();
        }
        finally{
            if(list.size() != 0)
                    write.addAll(list);
            ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("TourGuides.txt"));
            oos.writeObject(write);
            oos.close();
        }
    }
}

