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

       // dataBase names = new dataBase("name.txt", 10);
        //dataBase location = new dataBase("location.txt", 10);
        //dataBase time = new dataBase("time.txt", 10);
        //dataBase colours = new dataBase("colours.txt", 10);
       // db.appendRecord("1.ABCDEFGH");
       // db.appendRecord("2.ABCDEFGH");
       // db.appendRecord("3.ABCDEFGH");
       // db.appendRecord("4.ABCDEFGH");
       // System.out.println(db.getRecord(2));	 // should be "3.ABCDEFGH"
       // System.out.println(db.findRecord("EBCDEFGHIJ")); // false
       // System.out.println(db.findRecord("2.ABCDEFGH")); // true
       // System.out.println("count = " + db.getRecordCount()); // 4
        //db.appendRecord("sans");
        //db.appendRecord("jesus");

        //FileHandler.appendLine("test.txt", "osadifj");
        //System.out.println(FileHandler.countLines("test.txt"));
        //System.out.println(FileHandler.readLine("test.txt", 0));
        //System.out.println(FileHandler.readLine("test.txt", 1));
        //System.out.println(FileHandler.readLine("test.txt", 2));
        //System.out.println(" ");
        //FileHandler.writeLineAt("test.txt", "qweqw", 1);
        //FileHandler.writeLineAt("name.txt", "po", 2);
        //System.out.println(FileHandler.countLines("test.txt"));
        //System.out.println(" ");

        //db.appendRecord("cheese");


        Scanner user = new Scanner(System.in);
        String option = "";


        //GUI TIME
        JFrame frame = new JFrame("IA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI myGUI = new GUI(1366,768);


        frame.add(myGUI);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(-7,-1);

        JFrame frame2 = new JFrame("IA");
        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        GUI anotherONE = new GUI(1000,500);

        frame2.add(anotherONE);
        frame2.pack();
        frame2.setVisible(true);
        frame2.setLocation(-7,-1);

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


