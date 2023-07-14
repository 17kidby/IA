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
    private JPanel panel;


    public GUI(int width, int height) {
        System.out.println("SEQUENCE: GUI constructor");
        this.setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        button1 = new JButton("Add");
        button1.setBounds(0,0, 200, 80);
        button2 = new JButton("b2");
        button2.setBounds(0,100, 200, 80);
        button3 = new JButton("b2");
        button3.setBounds(0,200, 200, 80);
        button4 = new JButton("b2");
        button4.setBounds(0,300, 200, 80);
        add(button1);
        button1.addActionListener(this);
        add(button2);
        button2.addActionListener(this);
        add(button3);
        button3.addActionListener(this);
        add(button4);
        button4.addActionListener(this);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\17kidby_m\\IdeaProjects\\IA\\src\\com\\company\\Royal_Standard_of_the_United_Kingdom.svg.png");
        Image image = imageIcon.getImage();

        // Resizing the image
        int newWidth = 1000;
        int newHeight = 500;
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel label = new JLabel(resizedIcon);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(null); // Set the layout manager to null for manual positioning
        label.setBounds(500, 100, newWidth, newHeight); // Set the position of the label manually
        imagePanel.add(label);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonsPanel, BorderLayout.NORTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        add(mainPanel);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("b1")){
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }else{
            System.out.println("AAAAAAAAAAAAAAAAA b");
        }

    }
}
