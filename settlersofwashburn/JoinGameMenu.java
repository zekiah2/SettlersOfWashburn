package settlersofwashburn;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.BindException;
import javax.swing.*;

public class JoinGameMenu {

    JTextField nameField;
    JTextField sourceIPField;
    JFrame loginFrame;
    Client s;

    public JoinGameMenu() {
        loginFrame = new JFrame("Login");
        JPanel loginPanel = new JPanel();
        JPanel fieldsPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JLabel nameLabel = new JLabel("Name");
        nameField = new JTextField(1);
        JLabel sourceIPLabel = new JLabel("Game IP Adress");
        sourceIPField = new JTextField(1);
        sourceIPField.setText("localhost");
        loginPanel.setLayout(new GridLayout(2, 1));
        fieldsPanel.setLayout(new GridLayout(2, 2));
        loginFrame.add(loginPanel);
        loginPanel.add(fieldsPanel);
        loginPanel.add(buttonPanel);
        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameField);
        fieldsPanel.add(sourceIPLabel);
        fieldsPanel.add(sourceIPField);
        buttonPanel.add(loginButton);
        loginFrame.setSize(300, 150);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        loginButton.addActionListener(new buttonListener());
    }

    class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                s = new Client();
            } catch (BindException ex) {
                System.out.println(ex);
            }
            s.connect(sourceIPField.getText(), nameField.getText());
            loginFrame.setVisible(false);
        }
    }
}
