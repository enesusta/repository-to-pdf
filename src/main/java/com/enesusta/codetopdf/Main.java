package com.enesusta.codetopdf;

import com.enesusta.codetopdf.model.Person;

import java.awt.Dimension;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //DirectorySelect.launch(DirectorySelect.class);
/*
        Frame frame = new Frame("Code To PDF");

        frame.setSize(new Dimension(600,600));
        frame.add(new Menu());
        frame.init();

*/

        Person person = new Person("enes","usta","edirne");


        person.setName("feyza");
        System.out.println(person.getName() + " " + person.getSurname() + " "  + person.getCity());
        System.out.println(person.toString());
    }
}
