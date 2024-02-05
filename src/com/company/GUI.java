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
        button1.setBounds(200,300, 200, 80);
        button2 = new JButton("Edit");
        button2.setBounds(500,300, 200, 80);
        button3 = new JButton("View");
        button3.setBounds(200,450, 200, 80);
        button4 = new JButton("Delete");
        button4.setBounds(500,450, 200, 80);
        add(button1);
        button1.addActionListener(this);
        add(button2);
        button2.addActionListener(this);
        add(button3);
        button3.addActionListener(this);
        add(button4);
        button4.addActionListener(this);








        ImageIcon imageIcon = new ImageIcon("C:\\Users\\44739\\IdeaProjects\\IA\\src\\com\\company\\Screenshot 2023-11-28 113806 plus bordrs.jpg");
        Image image = imageIcon.getImage();

        // Resizing the image
        int newWidth = 432;
        int newHeight = 864;
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel label = new JLabel(resizedIcon);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(null); // Set the layout manager to null for manual positioning
        label.setBounds(1056, -100, newWidth, newHeight); // Set the position of the label manually
        imagePanel.setBackground(Color.gray);

        imagePanel.add(label);

        JLabel title = new JLabel("Garden Flower Storing Thing");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        title.setForeground(Color.white);
        title.setBounds(140,90,1000,100);
        imagePanel.add(title);


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonsPanel, BorderLayout.NORTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);
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
                confirm = JOptionPane.showConfirmDialog(GUI.this, "Confirm this is correct? \nPlant: " + addName + "\nLocation: " + addLocation + " \nFlowering Time: " + addTime + " \nColour: " + addColour);

                if (confirm == 0){
                    db.addToPlant(addName, addLocation, addTime, addColour);
                }
            }



        }else if (e.getActionCommand().equals("Edit")) {
            db.editPlants();
        }else if (e.getActionCommand().equals("View")) {
            db.viewPlants("List of plants in your garden: ");
        }else if (e.getActionCommand().equals("Delete")) {
            db.removePlants();
        }else if (e.getActionCommand().equals("test"))  {

            //testPopUpWindow frejm = new testPopUpWindow(50,50);
            //frejm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frejm.setVisible(true);


        }

    }

}
