package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class dataBase {

    private FileHandler fh = new FileHandler();
    private String filename;
    private int rowWidth;
    private String name = "name.txt";
    private String location = "location.txt";
    private String time = "time.txt";
    private String colours = "colours.txt";
    private JPanel labelPanel = new JPanel();
    JFrame frame2 = new JFrame("Plant Viewer");




    public dataBase(String filename) {
        this.filename = filename;

    }

    // add a new record to the end of the database
    public void appendRecord(String data) {
        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record
        String temp = "";
        int rows = fh.countLines(filename);
        String line = fh.readLineAt(filename, rows);

        if (line != null) {
            //FileHandler.writeLineAt(filename, line + temp, rows);
            fh.appendLine(filename, data);
        }
    }

    // delete the record at the specified row
    public void deleteRecord(int rowNumber) {
        // TODO: replace this placeholder code
    }

    // return the record at the specified row
    public String getRecord(int rowNumber) {


        return ""; // TODO: replace this placeholder code
    }

    // return the number of records in the database
    public int getRecordCount() {
        return (fh.countLines(filename));

    }

    // search for a record matching data
    // return true if found
    public boolean findRecord(String data) {


        return false; // TODO: replace this placeholder code
    }

    public void editPlants() {
        Scanner user = new Scanner(System.in);
        int lineNum = fh.countLines(name);
        String[] data = new String[lineNum];
        int yCorLoop = 120;


        String[] buttonList = new String[lineNum-1];

        for (int i=0; i<lineNum; i++){
            JButton button = new JButton("Line " + i);
            button.setBounds(200, yCorLoop, 40, 20);
            labelPanel.add(button);


        }


        System.out.println("Which part of the line do you want to change? ");
        System.out.println("(1) Name   (2) Location   (3) Time   (4) Colours");
        //System.out.println(fh.readLine(name, input-1) + ", " + fh.readLine(location, input-1) + ", " + fh.readLine(time, input-1) + ", " + fh.readLine(colours, input-1));
        int inputTwo = user.nextInt();






       //if (inputTwo == 1){
       //    fh.doTheEdit(name, input);

       //}else if (inputTwo == 2){
       //    fh.doTheEdit(location, input);

       //}else if (inputTwo == 3) {
       //    fh.doTheEdit(time, input);

       //}else if (inputTwo == 4) {
       //    fh.doTheEdit(colours, input);

       //}

        System.out.println("    ");

    }

    public void actionPerformed(ActionEvent e) {

    }

    public void addToPlant(String Name, String Location, String Time, String Colours){
        Scanner user = new Scanner(System.in);


        fh.appendLine(name, Name);


        fh.appendLine(location, Location);


        fh.appendLine(time, Time);


        fh.appendLine(colours, Colours);


        System.out.println("    ");
    }

    public void viewPlants(String viewingTitle){
        int lineNum = fh.countLines(name);

        //making new window pop out
        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame2.setSize(1536,864);
        frame2.setVisible(true);

        //list title
        JLabel label = new JLabel(viewingTitle);
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        label.setBounds(180, 0, 600, 100);

        //creating loop to generate list of plants on screen
        labelPanel.setLayout(null);
        int yCorLoop=120;
        for (int i=0; i<lineNum; i++){
            JLabel newLine = new JLabel((i+1) + ") " + fh.readLine(name, i) + ", " + fh.readLine(location, i) + ", " + fh.readLine(time, i) + ", " + fh.readLine(colours, i));
            newLine.setFont(new Font("Comic Sans MC", Font.PLAIN, 20));
            newLine.setBounds(175, yCorLoop, 1536, 40);
            labelPanel.add(newLine);
            yCorLoop =yCorLoop+40;
        }

        //adding map
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\44739\\IdeaProjects\\IA\\src\\com\\company\\Screenshot 2023-11-28 113806 plus bordrs.jpg");
        Image image = imageIcon.getImage();

        // Resizing the map again
        int newWidth = 432;
        int newHeight = 864;
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(986, -100, newWidth, newHeight); // Set the position of the label manually


        labelPanel.add(imageLabel);
        labelPanel.add(label);
        frame2.add(labelPanel);

        //return frame2;


    }


    public void removePlants(){
        Scanner user = new Scanner(System.in);
        int lineNum = fh.countLines(name);

        viewPlants("");
        System.out.println("Which line do you want to delete? ");
        int start = user.nextInt();

        fh.deleteLineAt(name, (start-1));
        fh.deleteLineAt(location, (start-1));
        fh.deleteLineAt(time, (start-1));
        fh.deleteLineAt(colours, (start-1));

        System.out.println("    ");
    }

    public void doTest(){
        System.out.println(fh.readLine(name, 1));
    }





}

