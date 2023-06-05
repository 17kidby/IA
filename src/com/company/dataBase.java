package com.company;

public class dataBase {

    private String filename;
    private int rowWidth;

    public dataBase(String filename) {
        this.filename = filename;

    }

    // add a new record to the end of the database
    public void appendRecord(String data) {
        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record
        String temp = "";
        int rows = FileHandler.countLines(filename);
        String line = FileHandler.readLineAt(filename, rows);

        if (line != null) {
            FileHandler.writeLineAt(filename, line + temp, rows);
            FileHandler.appendLine(filename, data);
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
        return (FileHandler.countLines(filename));

    }

    // search for a record matching data
    // return true if found
    public boolean findRecord(String data) {
        return false; // TODO: replace this placeholder code
    }

}

