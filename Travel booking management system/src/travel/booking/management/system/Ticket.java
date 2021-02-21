/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.booking.management.system;

import java.util.*;
import java.io.*;

public class Ticket {

    private int price;
    private String type;

    public Ticket() {

        price = 0;
        type = "";

    }

    Ticket(String type, int price) {
        this.type = type;
        this.price = price;
    }

    int getPrice() {
        return price;
    }

    String getType() {
        return type;
    }

}
