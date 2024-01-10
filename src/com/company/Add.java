package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JPanel {

    public Add(int width, int height) {
        System.out.println("SEQUENCE: GUI constructor");
        this.setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());

        JTextField textField = new JTextField("Type something here");

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This method is called when the "Enter" key is pressed in the text field
                String enteredText = textField.getText();
                JOptionPane.showMessageDialog(null, "You entered: " + enteredText);
            }
        });

            // Add the JTextField to the JPanel
        add(textField);



    }
}
