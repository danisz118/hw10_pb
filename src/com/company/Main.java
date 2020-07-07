package com.company;


import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        AddressBook addressBook = new AddressBook();

        Date date = new Date();

        addressBook.addRecord("zach", "25.01.94", 063043, "ул. Ленина, 3", date.getTime());
        addressBook.addRecord("zsafda", "30.01.91", 0236, "ул. Ленина, 15", date.getTime());
        addressBook.addRecord("zasada", "25.01.45", 0145, "ул. Ленина, 63", date.getTime());

        String json = (String) addressBook.objectToJson(addressBook);
        addressBook.fileWriter(json);
        String a = addressBook.fileReader();




    }
}
