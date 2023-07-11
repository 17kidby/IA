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

    public GUI(int width, int height) {
        System.out.println("SEQUENCE: GUI constructor");
        this.setPreferredSize(new Dimension(width, height));
        setLayout(null);
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
