package com.company;

import java.io.File;
import java.util.Scanner;

public class dataBase {

    private FileHandler fh = new FileHandler();
    private String filename;
    private int rowWidth;
    private String name = "name.txt";
    private String location = "location.txt";
    private String time = "time.txt";
    private String colours = "colours.txt";

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


        viewPlants();
        System.out.println("Which line do you want to edit? ");
        int input = user.nextInt();

        System.out.println("Which part of the line do you want to change? ");
        System.out.println("(1) Name   (2) Location   (3) Time   (4) Colours");
        System.out.println(fh.readLine(name, input-1) + ", " + fh.readLine(location, input-1) + ", " + fh.readLine(time, input-1) + ", " + fh.readLine(colours, input-1));
        int inputTwo = user.nextInt();






        if (inputTwo == 1){
            fh.doTheEdit(name, input);

        }else if (inputTwo == 2){
            fh.doTheEdit(location, input);

        }else if (inputTwo == 3) {
            fh.doTheEdit(time, input);

        }else if (inputTwo == 4) {
            fh.doTheEdit(colours, input);

        }

        System.out.println("    ");

    }

    public void addToPlant(){
        Scanner user = new Scanner(System.in);

        System.out.println("Name: ");
        fh.appendLine(name, user.nextLine());

        System.out.println("Location: ");
        fh.appendLine(location, user.nextLine());

        System.out.println("Period of flowering (write the months): ");
        fh.appendLine(time, user.nextLine());

        System.out.println("Main colour: ");
        fh.appendLine(colours, user.nextLine());


        System.out.println("    ");
    }

    public void viewPlants(){
        System.out.println("List of plants: ");
        int lineNum = fh.countLines(name);
        for (int i=0; i<lineNum; i++){
            System.out.print((i+1) + ") " + fh.readLine(name, i) + ", ");
            System.out.print(fh.readLine(location, i) + ", ");
            System.out.print(fh.readLine(time, i) + ", ");
            System.out.print(fh.readLine(colours, i));
            System.out.println("");
        }
        System.out.println("    ");
        System.out.println("    ");
    }


    public void removePlants(){
        Scanner user = new Scanner(System.in);
        int lineNum = fh.countLines(name);

        viewPlants();
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

