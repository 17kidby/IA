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


        //getting size of monitor
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(size);
        int screenHeight = size.height;
        int screenLength = size.width;


        //GUI TIME
        JFrame frame = new JFrame("IA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI myGUI = new GUI(screenLength, screenHeight);
        frame.add(myGUI);


        frame.pack();
        frame.setVisible(true);
        frame.setLocation(-7, -1);

    }
}

