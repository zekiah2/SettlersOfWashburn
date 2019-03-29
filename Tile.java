/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settlersofwashburn;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Jacob
 */
public class Tile extends Polygon {

    private String tileName;
    private int diceNumber = 0;
    boolean numberMatch = false;
    private Color c;
    private Board p;
    private Polygon tile;
    private int centerX;
    private int centerY;
    public Settlement[] tileSettlements;

    public Tile(String name, int number, Settlement[] points, int[] hexPoint, Color c) {
        this.p = p;
        this.c = c;
        tileName = name;
        diceNumber = number;
        double[] coords;
        int[] x = new int[7];
        int[] y = new int[7];
        tileSettlements= new Settlement[7];
        for (int i = 0; i < 7; i++) 
        {
            int z= hexPoint[i];
            tileSettlements[i]=points[z];
            coords= points[z].getBoardCoords();
            x[i]=(int) coords[0];
            y[i]=(int) coords[1];
            
        }
        int z=hexPoint[0];
        coords = points[z].getBoardCoords();
        
        centerX = (int) coords[0] -20;
        centerY = (int) coords[1] + 100;
        tile = new Polygon(x, y, 7);
    }

    public void setDiceNumber(int number) {
        diceNumber = number;
    }

    public String getTileName() {
        return tileName;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public Polygon getPolygon() {
        return tile;
    }

    public Color getColor() {
        return c;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }
    public Settlement[] getSettlements() {
        return tileSettlements;
    }
}
