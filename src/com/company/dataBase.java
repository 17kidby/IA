package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class dataBase implements ActionListener {
    private FileHandler fh = new FileHandler();
    private String filename;
    private int rowWidth;
    private String name = "name.txt";
    private String location = "location.txt";
    private String time = "time.txt";
    private String colours = "colours.txt";
    private JPanel labelPanel = new JPanel();
    JFrame frame2 = new JFrame("Plant Viewer");
    private boolean editing = false;
    private String[] options = {"Name", "Location", "Time", "Colours"};


    public dataBase(String filename) {
        this.filename = filename;
    }


    public Dimension screenSize(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return size;
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
        editing = true;
        Scanner user = new Scanner(System.in);
        int lineNum = fh.countLines(name);
        String[] data = new String[lineNum];
        int yCorLoop = 125;

        labelPanel.setLayout(null);

        String[] buttonList = new String[lineNum-1];

        for (int i=0; i<lineNum; i++){
            JButton button = new JButton("Line " + (i+1));
            button.setBounds(50, yCorLoop, 70, 30);
            labelPanel.add(button);
            button.addActionListener(this);
            yCorLoop = yCorLoop+50;
        }

        frame2.add(labelPanel);

        viewPlants("What do you want to edit?", 700, (150)+(50*lineNum));
    }


    public void actionPerformed(ActionEvent e) {
        Scanner input = new Scanner(System.in);
        System.out.println(editing);

        if (editing == true){
            for (int i=0; i< fh.countLines(name); i++){
                if (e.getActionCommand().equals("Line " + (i+1))){
                    int section = JOptionPane.showOptionDialog(labelPanel, "What section would you like to edit?", "Edit options", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (section == 0){
                        fh.doTheEdit(name, i);

                    }else if (section == 1){
                        fh.doTheEdit(location, i);

                    }else if (section == 2) {
                        fh.doTheEdit(time, i);

                    }else if (section == 3) {
                        fh.doTheEdit(colours, i);
                    }
                }
            }
            editing=false;

        }else{
            for (int i=0; i< fh.countLines(name); i++){
                if (e.getActionCommand().equals("Line " + (i+1))){
                    int lineToDelete = JOptionPane.showConfirmDialog(labelPanel, "Are you sure you want to delete Line " + (i+1), "Confirm Line Deletion", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (lineToDelete == 0){
                        fh.deleteLineAt(name, (i));
                        fh.deleteLineAt(location, (i));
                        fh.deleteLineAt(time, (i));
                        fh.deleteLineAt(colours, (i));
                    }
                }
            }
        }
    }


    public void addToPlant(String Name, String Location, String Time, String Colours){
        Scanner user = new Scanner(System.in);

        fh.appendLine(name, Name);

        fh.appendLine(location, Location);

        fh.appendLine(time, Time);

        fh.appendLine(colours, Colours);

        System.out.println("    ");
    }


    public void viewPlants(String viewingTitle, int width, int height){
        int lineNum = fh.countLines(name);


        //making new window pop out
        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame2.setSize(width,height);
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
            yCorLoop =yCorLoop+50;
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

    }




    public void removePlants(){

        editing=false;

        int lineNum = fh.countLines(name);
        String[] data = new String[lineNum];
        int yCorLoop = 125;

        labelPanel.setLayout(null);

        String[] buttonList = new String[lineNum-1];

        for (int i=0; i<lineNum; i++){
            JButton button = new JButton("Line " + (i+1));
            button.setBounds(50, yCorLoop, 70, 30);
            labelPanel.add(button);
            button.addActionListener(this);
            yCorLoop = yCorLoop+50;
        }

        frame2.add(labelPanel);

        viewPlants("What line would you like to delete?", 700, (150)+(50*lineNum));
    }


    public void doTest(){
        System.out.println(fh.readLine(name, 1));
    }
}


