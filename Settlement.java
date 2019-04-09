/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settlersofwashburn;

import java.awt.Color; 
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Jacob
 */
class Settlement extends Component {

    		private ArrayList<Integer> adjacentSides;
		private ArrayList<Integer> adjacentPoints;
		private ArrayList<Integer> adjacentTiles;
		private double[] boardCoords;
		private Color pointColor;
                private int owner = -1;

		public Settlement()
		{
			adjacentSides = new ArrayList<Integer>();
			adjacentPoints = new ArrayList<Integer>();
			adjacentTiles = new ArrayList<Integer>();
			boardCoords = new double[2];
			pointColor = Color.BLACK;
		}
		
		public void add2Sides(int side1, int side2)
		{
			adjacentSides.add(side1);
			adjacentSides.add(side2);
		}
		
		public void add3Sides(int side1, int side2, int side3)
		{
			adjacentSides.add(side1);
			adjacentSides.add(side2);
			adjacentSides.add(side3);
		}

		public void add2Points(int point1, int point2)
		{
			adjacentPoints.add(point1);
			adjacentPoints.add(point2);
		}
		
		public void add3Points(int point1, int point2, int point3)
		{
			adjacentPoints.add(point1);
			adjacentPoints.add(point2);
			adjacentPoints.add(point3);
			
		}
		
		public void add1Tiles(int tile)
		{
			adjacentTiles.add(tile);
		}
		
		public void add2Tiles(int tile1, int tile2)
		{
			adjacentTiles.add(tile1);
			adjacentTiles.add(tile2);
		}
		
		public void add3Tiles(int tile1, int tile2, int tile3)
		{
			adjacentTiles.add(tile1);
			adjacentTiles.add(tile2);
			adjacentTiles.add(tile3);
		}
		
		public int getSidesSize()
		{
			return adjacentSides.size();
		}
		
		public int getPointsSize()
		{
			return adjacentPoints.size();
		}
		
		public int getTilesSize()
		{
			return adjacentTiles.size();
		}
		
		public int getSidesElement(int element)
		{
			return adjacentSides.get(element);
		}
		
		public int getPointsElement(int element)
		{
			return adjacentPoints.get(element);
		}
		
		public int getTilesElement(int element)
		{
			return adjacentTiles.get(element);
		}
		
		public void setBoardCoords(double x, double y)
		{
			boardCoords[0] = x;
			boardCoords[1] = y;
		}

		public double[] getBoardCoords()
		{
			return boardCoords;
		}

		public void setSettlementColor(Color pointColor)
		{
			this.pointColor = pointColor;
		}
		
		public Color getSettlementColor()
		{
			return pointColor;
		}		
                public void setOwner(int owner){
                    this.owner=owner;
                }
                public int getOwner(){
                    return owner;
                }
}
