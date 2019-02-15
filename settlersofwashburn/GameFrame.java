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
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class GameFrame extends JFrame
{
    JTextArea chatTA;
    JTextField messageField;
    JButton sendButton;
    public GameFrame()
    {
    JPanel mainPanel=new JPanel();
    add(mainPanel);

    chatTA=new JTextArea();
    chatTA.setPreferredSize(new Dimension(600,500));
    chatTA.setEditable(false);
    chatTA.setLineWrap(true);
    mainPanel.add(new JScrollPane(chatTA
               ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
              ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
    JPanel bottomPanel=new JPanel();
    add(bottomPanel,BorderLayout.SOUTH);
    messageField=new JTextField(50);
    bottomPanel.add(messageField);
    sendButton=new JButton("Send");
    sendButton.setEnabled(false);
    bottomPanel.add(sendButton);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800,600);
    setResizable(false);
    setVisible(true);
    }
}
