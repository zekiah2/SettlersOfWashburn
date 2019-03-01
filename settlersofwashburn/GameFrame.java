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
import java.awt.Graphics;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.*;
import java.awt.geom.AffineTransform;
import javafx.scene.shape.Polyline;
public class GameFrame extends JFrame
{
    JTextArea chatTA;
    JPanel boardPL;
    JTextField messageField;
    JButton sendButton;
    int[] xPos;
    int[] yPos;
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
    boardPL = new JPanel(){
     public void paintComponent(Graphics g){  
         super.paintComponent(g);
         xPos=new int[7];
         yPos=new int[7];
            for (int i =0; i < 7; i++)
            {
                xPos[i]= (int) (100 + 50 * Math.cos(i * 2 * Math.PI / 6));
                yPos[i]= (int) (400 + 50 * Math.sin(i*2 * Math.PI / 6));      
               // h.addPoint((int) (xPos[i]), (int) ());
            }
//            for (int i=0; i<5;i++)
//            {
//                Rectangle rect= new Rectangle(new Point(xPos[i],yPos[i]));
//                rect.setFrameFromDiagonal(new Point(xPos[i],yPos[i]),new Point(xPos[i+1],yPos[i+1]));
//                AffineTransform transform = new AffineTransform();
//             //   transform.rotate(45);
//              //  transform.translate(xPos[i], yPos[i]); 
//              //  Shape rotatedRect = transform.createTransformedShape(rect);
//              //  g.draw(rotatedRect);
//            }
            g.setColor(Color.red);
            g.drawPolyline(xPos, yPos, 7);
            for (int i =0; i < 7; i++)
            {
                xPos[i]= (int) (175 + 50 * Math.cos(i * 2 * Math.PI / 6));
                yPos[i]= (int) (355 + 50 * Math.sin(i*2 * Math.PI / 6));      
               // h.addPoint((int) (xPos[i]), (int) ());
            }
            g.setColor(Color.red);
            g.drawPolyline(xPos, yPos, 7);
            g.fillPolygon(xPos, yPos, 7);
        }
    }
    ;
   // add(boardPL);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800,600);
    setResizable(false);
    setVisible(true);
    
    }
public static void main(String args[]){
   new GameFrame();
}
}

