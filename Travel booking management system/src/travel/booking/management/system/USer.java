/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.booking.management.system;

import java.util.*;
import java.io.*;

public class USer implements Serializable {

    private String name;
    private String lastname;
    private int age;
    private int ID;
    private char gender;

    public USer() {
        name = "";
        lastname="";
        age = 0;
        ID = 0;
        gender =' ';
    }

    public USer(String name,String lastname, int age, int ID,char gender) {
        this.name = name;
        this.lastname= lastname;
        this.age = age;
        this.ID = ID;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }
 public String getLName() {
        return lastname;
    }
    public int getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }
    public char getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return (name + "\t" +lastname+"\t"+ age + "\t" + ID+"\t"+gender);
    }
}