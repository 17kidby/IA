package com.company;
import java.io.File;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;



public class Main {

    public static void main(String[] args) {
        //dataBase db = new dataBase("test.txt");

        // test the database works
        System.out.println("Database (type 'end' to end)");


        Scanner user = new Scanner(System.in);
        String option = "";


        //GUI TIME
        JFrame frame = new JFrame("IA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI myGUI = new GUI(1536,864);
        frame.add(myGUI);

        frame.pack();
        frame.setVisible(true);
        frame.setLocation(-7,-1);












        /*
        while (!option.equals("end")) {
            System.out.println("1. Add ");
            System.out.println("2. Edit");
            System.out.println("3. View");
            System.out.println("4. Delete");
            option = user.next();

            if (option.equals("1")) {
                db.addToPlant();
            }

            if (option.equals("2")) {
                db.editPlants();
            }

            if (option.equals("3")) {
                db.viewPlants();
            }

            if (option.equals("4")){
                db.removePlants();
            }


            if (option.equals("test")){
                db.doTest();
            }


        }
        */







    }
}


