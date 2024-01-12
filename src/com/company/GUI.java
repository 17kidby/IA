package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener {
    // canvas for other GUI widgets

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    private JPanel panel;


    public GUI(int width, int height) {
        System.out.println("SEQUENCE: GUI constructor");
        this.setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        button1 = new JButton("Add");
        button1.setBounds(0,0, 200, 80);
        button2 = new JButton("Edit");
        button2.setBounds(0,100, 200, 80);
        button3 = new JButton("View");
        button3.setBounds(0,200, 200, 80);
        button4 = new JButton("Delete");
        button4.setBounds(0,300, 200, 80);
        button5 = new JButton("test");
        button5.setBounds(580,350, 200, 80);
        add(button1);
        button1.addActionListener(this);
        add(button2);
        button2.addActionListener(this);
        add(button3);
        button3.addActionListener(this);
        add(button4);
        button4.addActionListener(this);
        add(button5);
        button5.addActionListener(this);
/*
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\17kidby_m\\IdeaProjects\\IA\\src\\com\\company\\Screenshot 2023-11-28 113806 plus bordrs.png");
        Image image = imageIcon.getImage();

        // Resizing the image
        int newWidth = 1000;
        int newHeight = 500;
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel label = new JLabel(resizedIcon);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(null); // Set the layout manager to null for manual positioning
        label.setBounds(300, 100, newWidth, newHeight); // Set the position of the label manually
        imagePanel.add(label);
*/
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonsPanel, BorderLayout.NORTH);
        //mainPanel.add(imagePanel, BorderLayout.CENTER);

        add(mainPanel);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        dataBase db = new dataBase("sabs.txt");

        if (e.getActionCommand().equals("Add")){
            int confirm = 1;
            String addName;
            String addLocation;
            String addTime;
            String addColour;

            while (confirm == 1) {
                addName = JOptionPane.showInputDialog(GUI.this, "Enter Name of Plant: ");
                addLocation = JOptionPane.showInputDialog(GUI.this, "Enter Location on Grid: ");
                addTime = JOptionPane.showInputDialog(GUI.this, "Enter Period of Flowering (write the months): ");
                addColour = JOptionPane.showInputDialog(GUI.this, "Enter Main Colour of Plant: ");
                confirm = JOptionPane.showConfirmDialog(GUI.this, "Confirm this is correct?");
                System.out.println(confirm);
            }
            db.addToPlant(addName, addLocation, addTime, addColour);


        }else if (e.getActionCommand().equals("Edit")) {
            db.editPlants();
        }else if (e.getActionCommand().equals("View")) {
            db.viewPlants();
        }else if (e.getActionCommand().equals("Delete")) {
            db.removePlants();
        }else if (e.getActionCommand().equals("test"))  {
            // Show input dialog
            String userInput = JOptionPane.showInputDialog(GUI.this, "Enter text:");

            // Check if the user pressed OK and entered text
            if (userInput != null && !userInput.isEmpty()) {
                JOptionPane.showMessageDialog(GUI.this, "You entered: " + userInput);
            }


        }

    }
}
