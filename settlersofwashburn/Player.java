/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settlersofwashburn;

import java.awt.Color;
import java.io.PrintWriter;

/**
 *
 * @author Jacob
 */
public class Player {

    public static final int WHITE = 0;
    public static final int ORANGE = 1;
    public static final int BLUE = 2;
    public static final int RED = 3;

    private int color;
    private String name;
    private PrintWriter out;
    public Hand hand;

    public Player(PrintWriter out, String name) {
        this.name = name;
        this.out = out;
        hand= new Hand();
    }

    public PrintWriter getPrintWriter() {
        return out;
    }

    public String getName() {
        return name;
    }

    public void setColor(int color) {
        if (color == 0) {
            this.color = WHITE;
        }
        if (color == 1) {
            this.color = ORANGE;
        }
        if (color == 2) {
            this.color = BLUE;
        }
        if (color == 3) {
            this.color = RED;
        }
    }

    public String getColorString() {
        if (color == 0) {
            return "white";
        }
        if (color == 1) {
            return "orange";
        }
        if (color == 2) {
            return "blue";
        } else {
            return "red";
        }
    }
    public int getColorInt() {
        return color;
    }
    public int colorStringToInt(String color){
        if(color.equals("white")){
            return 0;
        }
        if(color.equals("orange")){
            return 1;
        }
        if(color.equals("blue")){
            return 2;
        }
        if(color.equals("red")){
            return 3;
        }
        else{
            return 4;
        }
    }
}
