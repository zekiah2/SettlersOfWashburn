/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settlersofwashburn;

/**
 *
 * @author Zekiah
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Road extends Rectangle
{
    
    public static final double xUnit = 277.12812921102034  -207.84609690826525;
    public static final double yUnit = 40;
    public static final double aUpR=-1*Math.atan2(yUnit,xUnit);
    public static final double aDownR=Math.atan2(yUnit,xUnit);
    public static final double aUp = -1*Math.PI/2;
    public static final double aDown =  Math.PI/2;
    public static final double aDownL = Math.PI/2 + Math.atan2(xUnit,yUnit);
    public static final double aUpL= -1*(Math.PI/2 +Math.atan2(xUnit,yUnit));   
    //*/
    private Graphics2D g2d;
    private double theta;
    private JPanel parent;
    private ArrayList<Road> adjacentSides;
    private ArrayList<Integer> adjacentPoints;
    private Color color = Color.BLACK;
    private Shape hitBox;
    private int owner =-1;//WHITE = 0 ORANGE = 1 BLUE = 2 RED = 3
    public Road()
    {
        adjacentSides = new ArrayList<Road>();
	adjacentPoints = new ArrayList<Integer>();
    }
    public Road(Point p)
    {
        setLocation(p);
        setSize(new Dimension((int)Math.pow((xUnit*xUnit)+(yUnit*yUnit), .5),6));
        adjacentSides = new ArrayList<Road>();
	adjacentPoints = new ArrayList<Integer>();
    }
    public Road(double[] p)
    {
        setLocation((int)p[0]+10,(int)p[1]-3);
        setSize(new Dimension((int)Math.pow((xUnit*xUnit)+(yUnit*yUnit), .5)-20,6));
        adjacentSides = new ArrayList<Road>();
	adjacentPoints = new ArrayList<Integer>();
    }
    public Road(Point p, Dimension d)
    {
        setLocation(p);
        setSize(d);
        adjacentSides = new ArrayList<Road>();
	adjacentPoints = new ArrayList<Integer>();
    }
    public Road(Point p, Dimension d, Graphics2D g)
    {
        setLocation(p);
        setSize(d);
        g2d = g;
        adjacentSides = new ArrayList<Road>();
	adjacentPoints = new ArrayList<Integer>();
    }
    public Road(Point p, Dimension d, Graphics2D g,double t)
    {
        setLocation(p);
        setSize(d);
        g2d = g;
        theta = t;
        adjacentSides = new ArrayList<Road>();
	adjacentPoints = new ArrayList<Integer>();
    }
    public Road(Point p, Dimension d, Graphics2D g,double t,JPanel temp)
    {
        setLocation(p);
        setSize(d);
        g2d = g;
        theta = t;
        parent = temp;
        adjacentSides = new ArrayList<Road>();
	adjacentPoints = new ArrayList<Integer>();
    }
    public Graphics2D getGraphics2D()
    {
        return g2d;
    }
    public void setGraphics2D(Graphics2D g)
    {
        g2d = g;
    }
    public double getTheta()
    {
        return theta;
    }
    public void setTheta(double t)
    {
        theta = t;
    }
    public JPanel getParent()
    {
        return parent;
    }
    public void setParent(JPanel t)
    {
        parent = t;
    }
    public void addToAdjacentSides(Road i)
    {
        adjacentSides.add(i);
    }
    public void addSide(Road i)
    {
        adjacentSides.add(i);
    }
    public void setAdjacentSides(ArrayList<Road> t)
    {
        adjacentSides = t;
    }
    public ArrayList<Road> getToAdjacentSides()
    {
        return adjacentSides;
    }
    public void addToAdjacentPoints(int i)
    {
        adjacentPoints.add(i);
    }
    public void addPoint(int i)
    {
        adjacentPoints.add(i);
    }
    public int getSidesSize()
    {
            return adjacentSides.size();
    }
    public Road getSidesElement(int element)
    {
            return adjacentSides.get(element);
    }
    public void setAdjacentPoints(ArrayList<Integer> t)
    {
        adjacentPoints = t;
    }
    public ArrayList<Integer> getToAdjacentPoints()
    {
        return adjacentPoints;
    }
    
    public int getPointsSize()
    {
            return adjacentPoints.size();
    }

    public int getPointsElement(int element)
    {
            return adjacentPoints.get(element);
    }
    public Color getColor()
    {
        return color;
    }
    public void setColor(Color t)
    {
        color = t;
    }
    public void setColor(int t)
    {
        //WHITE = 0 ORANGE = 1 BLUE = 2 RED = 3
        switch(t){
            case 0:
                this.setColor(Color.WHITE);
                break;
            case 1:
                this.setColor(Color.ORANGE);
                break;
            case 2:
                this.setColor(Color.BLUE);
                break;
            case 3:
                this.setColor(Color.RED);
                break;
            default:
                this.setColor(Color.BLACK);
        }
    }
    public void setTranslation()
    {
        hitBox = g2d.getTransform().createTransformedShape(this);
    }
    public void setTranslation(Graphics2D t)
    {
        hitBox = t.getTransform().createTransformedShape(this);
    }
    public Shape getHitBox()
    {
        return hitBox;
    }
    public boolean hit(Point2D p)
    {
        if(hitBox.contains(p)) return true;
        else return false;
    }
    public boolean hit(double x, double y)
    {
        if(hitBox.contains(x,y)) return true;
        else return false;
    }
    public int getOwner()
    {
        return owner;
    }
    public void setOwner(int t)
    {
        owner = t;
        //WHITE = 0 ORANGE = 1 BLUE = 2 RED = 3
        /*
        switch(t){
            case 0:
                this.setColor(Color.WHITE);
                owner = t;
                break;
            case 1:
                this.setColor(Color.ORANGE);
                owner = t;
                break;
            case 2:
                this.setColor(Color.BLUE);
                owner = t;
                break;
            case 3:
                this.setColor(Color.RED);
                owner = t;
                break;
            default:
                this.setColor(Color.BLACK);
                owner = -1;
        }
        */
        
        
    }
}
