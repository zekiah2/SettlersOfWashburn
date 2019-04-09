package settlersofwashburn;

import java.awt.*; 
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

class Board extends JPanel {

    public Road[] sideArray;
    public Settlement[] pointArray;
    public Tile[] tileArray;
    private ArrayList<Graphics2D> sideGraphic;
    private double xUnit;
    private double yUnit;
    private double xPos;
    private double yPos;
    private Settlement temp;
	private double[] eventCoords;
	private double[] coords;

    public Board() {
        sideArray = new Road[72];
        pointArray = new Settlement[54];
        tileArray = new Tile[19];
        sideGraphic = new ArrayList<Graphics2D>();
	eventCoords = new double[2];
        xUnit = 40 * Math.sqrt(3);
        yUnit = 40;
        xPos = 0;
        yPos = 0;
        int scnt = 0;

        for (int i = 0; i < 72; i++) {
            sideArray[i] = new Road();
        }

        for (int i = 0; i < 54; i++) {
            pointArray[i] = new Settlement();
        }

	MouseListener settlementListener = new SettlementColorChange();
	this.addMouseListener(settlementListener);

        xPos = 4 * xUnit;
        yPos = yUnit;

        for (int i = 0; i < 3; i++) {
            pointArray[i].setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 3 * xUnit;
        yPos = 2 * yUnit;

        for (int i = 3; i < 7; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 3 * xUnit;
        yPos = 4 * yUnit;

        for (int i = 7; i < 11; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 2 * xUnit;
        yPos = 5 * yUnit;

        for (int i = 11; i < 16; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 2 * xUnit;
        yPos = 7 * yUnit;

        for (int i = 16; i < 21; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = xUnit;
        yPos = 8 * yUnit;

        for (int i = 21; i < 27; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = xUnit;
        yPos = 10 * yUnit;

        for (int i = 27; i < 33; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 2 * xUnit;
        yPos = 11 * yUnit;

        for (int i = 33; i < 38; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 2 * xUnit;
        yPos = 13 * yUnit;

        for (int i = 38; i < 43; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 3 * xUnit;
        yPos = 14 * yUnit;

        for (int i = 43; i < 47; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 3 * xUnit;
        yPos = 16 * yUnit;

        for (int i = 47; i < 51; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }

        xPos = 4 * xUnit;
        yPos = 17 * yUnit;

        for (int i = 51; i < 54; i++) {
            temp = pointArray[i];
            temp.setBoardCoords(xPos, yPos);
            xPos = xPos + 2 * xUnit;
        }
        
        
        for (int i = 0; i < 3; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 3; i < 7; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 7; i < 11; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 11; i < 16; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 16; i < 21; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 21; i < 28; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 28; i < 32; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 32; i < 39; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 39; i < 42; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 42; i < 48; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        for (int i = 48; i < 50; i++) 
        {
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
            sideArray[scnt++] = new Road(pointArray[i].getBoardCoords());
        }
        
        sideArray[scnt++]=new Road(pointArray[50].getBoardCoords());
        setSize(800, 800);
        fillBoard();

    }

    public void fillBoard() {

        sideArray[0].addSide(sideArray[6]);
        sideArray[0].addSide(sideArray[1]);
        sideArray[1].addSide(sideArray[0]);
        sideArray[1].addSide(sideArray[2]);
        sideArray[1].addSide(sideArray[7]);
        sideArray[2].addSide(sideArray[1]);
        sideArray[2].addSide(sideArray[3]);
        sideArray[2].addSide(sideArray[7]);
        sideArray[3].addSide(sideArray[2]);
        sideArray[3].addSide(sideArray[4]);
        sideArray[3].addSide(sideArray[8]);
        sideArray[4].addSide(sideArray[3]);
        sideArray[4].addSide(sideArray[5]);
        sideArray[4].addSide(sideArray[8]);
        sideArray[5].addSide(sideArray[4]);
        sideArray[5].addSide(sideArray[9]);
        sideArray[6].addSide(sideArray[0]);
        sideArray[6].addSide(sideArray[10]);
        sideArray[6].addSide(sideArray[11]);
        sideArray[7].addSide(sideArray[1]);
        sideArray[7].addSide(sideArray[2]);
        sideArray[7].addSide(sideArray[12]);
        sideArray[7].addSide(sideArray[13]);
        sideArray[8].addSide(sideArray[3]);
        sideArray[8].addSide(sideArray[4]);
        sideArray[8].addSide(sideArray[14]);
        sideArray[8].addSide(sideArray[15]);
        sideArray[9].addSide(sideArray[5]);
        sideArray[9].addSide(sideArray[16]);
        sideArray[9].addSide(sideArray[17]);
        sideArray[10].addSide(sideArray[6]);
        sideArray[10].addSide(sideArray[18]);
        sideArray[10].addSide(sideArray[11]);
        sideArray[11].addSide(sideArray[10]);
        sideArray[11].addSide(sideArray[6]);
        sideArray[11].addSide(sideArray[12]);
        sideArray[11].addSide(sideArray[19]);
        sideArray[12].addSide(sideArray[7]);
        sideArray[12].addSide(sideArray[11]);
        sideArray[12].addSide(sideArray[13]);
        sideArray[12].addSide(sideArray[19]);
        sideArray[13].addSide(sideArray[7]);
        sideArray[13].addSide(sideArray[12]);
        sideArray[13].addSide(sideArray[14]);
        sideArray[13].addSide(sideArray[20]);
        sideArray[14].addSide(sideArray[8]);
        sideArray[14].addSide(sideArray[13]);
        sideArray[14].addSide(sideArray[15]);
        sideArray[14].addSide(sideArray[20]);
        sideArray[15].addSide(sideArray[8]);
        sideArray[15].addSide(sideArray[14]);
        sideArray[15].addSide(sideArray[16]);
        sideArray[15].addSide(sideArray[21]);
        sideArray[16].addSide(sideArray[9]);
        sideArray[16].addSide(sideArray[15]);
        sideArray[16].addSide(sideArray[17]);
        sideArray[16].addSide(sideArray[21]);
        sideArray[17].addSide(sideArray[9]);
        sideArray[17].addSide(sideArray[16]);
        sideArray[17].addSide(sideArray[22]);
        sideArray[18].addSide(sideArray[10]);
        sideArray[18].addSide(sideArray[23]);
        sideArray[18].addSide(sideArray[24]);
        sideArray[19].addSide(sideArray[11]);
        sideArray[19].addSide(sideArray[12]);
        sideArray[19].addSide(sideArray[25]);
        sideArray[19].addSide(sideArray[26]);
        sideArray[20].addSide(sideArray[13]);
        sideArray[20].addSide(sideArray[14]);
        sideArray[20].addSide(sideArray[27]);
        sideArray[20].addSide(sideArray[28]);
        sideArray[21].addSide(sideArray[15]);
        sideArray[21].addSide(sideArray[16]);
        sideArray[21].addSide(sideArray[29]);
        sideArray[21].addSide(sideArray[30]);
        sideArray[22].addSide(sideArray[17]);
        sideArray[22].addSide(sideArray[31]);
        sideArray[22].addSide(sideArray[32]);
        sideArray[23].addSide(sideArray[18]);
        sideArray[23].addSide(sideArray[24]);
        sideArray[23].addSide(sideArray[33]);
        sideArray[24].addSide(sideArray[18]);
        sideArray[24].addSide(sideArray[23]);
        sideArray[24].addSide(sideArray[25]);
        sideArray[24].addSide(sideArray[34]);
        sideArray[25].addSide(sideArray[19]);
        sideArray[25].addSide(sideArray[24]);
        sideArray[25].addSide(sideArray[26]);
        sideArray[25].addSide(sideArray[34]);
        sideArray[26].addSide(sideArray[19]);
        sideArray[26].addSide(sideArray[25]);
        sideArray[26].addSide(sideArray[27]);
        sideArray[26].addSide(sideArray[35]);
        sideArray[27].addSide(sideArray[20]);
        sideArray[27].addSide(sideArray[26]);
        sideArray[27].addSide(sideArray[28]);
        sideArray[27].addSide(sideArray[35]);
        sideArray[28].addSide(sideArray[20]);
        sideArray[28].addSide(sideArray[27]);
        sideArray[28].addSide(sideArray[29]);
        sideArray[28].addSide(sideArray[36]);
        sideArray[29].addSide(sideArray[21]);
        sideArray[29].addSide(sideArray[28]);
        sideArray[29].addSide(sideArray[30]);
        sideArray[29].addSide(sideArray[36]);
        sideArray[30].addSide(sideArray[21]);
        sideArray[30].addSide(sideArray[29]);
        sideArray[30].addSide(sideArray[31]);
        sideArray[30].addSide(sideArray[37]);
        sideArray[31].addSide(sideArray[22]);
        sideArray[31].addSide(sideArray[30]);
        sideArray[31].addSide(sideArray[32]);
        sideArray[31].addSide(sideArray[37]);
        sideArray[32].addSide(sideArray[22]);
        sideArray[32].addSide(sideArray[31]);
        sideArray[32].addSide(sideArray[38]);
        sideArray[33].addSide(sideArray[23]);
        sideArray[33].addSide(sideArray[39]);
        sideArray[34].addSide(sideArray[24]);
        sideArray[34].addSide(sideArray[25]);
        sideArray[34].addSide(sideArray[40]);
        sideArray[34].addSide(sideArray[41]);
        sideArray[35].addSide(sideArray[26]);
        sideArray[35].addSide(sideArray[27]);
        sideArray[35].addSide(sideArray[42]);
        sideArray[35].addSide(sideArray[43]);
        sideArray[36].addSide(sideArray[28]);
        sideArray[36].addSide(sideArray[29]);
        sideArray[36].addSide(sideArray[44]);
        sideArray[36].addSide(sideArray[45]);
        sideArray[37].addSide(sideArray[30]);
        sideArray[37].addSide(sideArray[31]);
        sideArray[37].addSide(sideArray[46]);
        sideArray[37].addSide(sideArray[47]);
        sideArray[38].addSide(sideArray[32]);
        sideArray[38].addSide(sideArray[48]);
        sideArray[39].addSide(sideArray[33]);
        sideArray[39].addSide(sideArray[40]);
        sideArray[39].addSide(sideArray[49]);
        sideArray[40].addSide(sideArray[34]);
        sideArray[40].addSide(sideArray[39]);
        sideArray[40].addSide(sideArray[41]);
        sideArray[40].addSide(sideArray[49]);
        sideArray[41].addSide(sideArray[34]);
        sideArray[41].addSide(sideArray[40]);
        sideArray[41].addSide(sideArray[42]);
        sideArray[41].addSide(sideArray[50]);
        sideArray[42].addSide(sideArray[35]);
        sideArray[42].addSide(sideArray[41]);
        sideArray[42].addSide(sideArray[43]);
        sideArray[42].addSide(sideArray[50]);
        sideArray[43].addSide(sideArray[35]);
        sideArray[43].addSide(sideArray[42]);
        sideArray[43].addSide(sideArray[44]);
        sideArray[43].addSide(sideArray[51]);
        sideArray[44].addSide(sideArray[36]);
        sideArray[44].addSide(sideArray[43]);
        sideArray[44].addSide(sideArray[45]);
        sideArray[44].addSide(sideArray[51]);
        sideArray[45].addSide(sideArray[36]);
        sideArray[45].addSide(sideArray[44]);
        sideArray[45].addSide(sideArray[46]);
        sideArray[45].addSide(sideArray[52]);
        sideArray[46].addSide(sideArray[37]);
        sideArray[46].addSide(sideArray[45]);
        sideArray[46].addSide(sideArray[47]);
        sideArray[46].addSide(sideArray[52]);
        sideArray[47].addSide(sideArray[37]);
        sideArray[47].addSide(sideArray[46]);
        sideArray[47].addSide(sideArray[48]);
        sideArray[47].addSide(sideArray[53]);
        sideArray[48].addSide(sideArray[38]);
        sideArray[48].addSide(sideArray[47]);
        sideArray[48].addSide(sideArray[53]);
        sideArray[49].addSide(sideArray[39]);
        sideArray[49].addSide(sideArray[40]);
        sideArray[49].addSide(sideArray[54]);
        sideArray[50].addSide(sideArray[41]);
        sideArray[50].addSide(sideArray[42]);
        sideArray[50].addSide(sideArray[55]);
        sideArray[50].addSide(sideArray[56]);
        sideArray[51].addSide(sideArray[43]);
        sideArray[51].addSide(sideArray[44]);
        sideArray[51].addSide(sideArray[57]);
        sideArray[51].addSide(sideArray[58]);
        sideArray[52].addSide(sideArray[45]);
        sideArray[52].addSide(sideArray[46]);
        sideArray[52].addSide(sideArray[59]);
        sideArray[52].addSide(sideArray[60]);
        sideArray[53].addSide(sideArray[47]);
        sideArray[53].addSide(sideArray[48]);
        sideArray[53].addSide(sideArray[61]);
        sideArray[54].addSide(sideArray[49]);
        sideArray[54].addSide(sideArray[55]);
        sideArray[54].addSide(sideArray[62]);
        sideArray[55].addSide(sideArray[50]);
        sideArray[55].addSide(sideArray[54]);
        sideArray[55].addSide(sideArray[56]);
        sideArray[55].addSide(sideArray[62]);
        sideArray[56].addSide(sideArray[50]);
        sideArray[56].addSide(sideArray[55]);
        sideArray[56].addSide(sideArray[57]);
        sideArray[56].addSide(sideArray[63]);
        sideArray[57].addSide(sideArray[51]);
        sideArray[57].addSide(sideArray[56]);
        sideArray[57].addSide(sideArray[58]);
        sideArray[57].addSide(sideArray[63]);
        sideArray[58].addSide(sideArray[51]);
        sideArray[58].addSide(sideArray[57]);
        sideArray[58].addSide(sideArray[59]);
        sideArray[58].addSide(sideArray[64]);
        sideArray[59].addSide(sideArray[52]);
        sideArray[59].addSide(sideArray[58]);
        sideArray[59].addSide(sideArray[60]);
        sideArray[59].addSide(sideArray[64]);
        sideArray[60].addSide(sideArray[52]);
        sideArray[60].addSide(sideArray[59]);
        sideArray[60].addSide(sideArray[61]);
        sideArray[60].addSide(sideArray[65]);
        sideArray[61].addSide(sideArray[53]);
        sideArray[61].addSide(sideArray[60]);
        sideArray[61].addSide(sideArray[65]);
        sideArray[62].addSide(sideArray[54]);
        sideArray[62].addSide(sideArray[55]);
        sideArray[62].addSide(sideArray[66]);
        sideArray[63].addSide(sideArray[56]);
        sideArray[63].addSide(sideArray[57]);
        sideArray[63].addSide(sideArray[67]);
        sideArray[63].addSide(sideArray[68]);
        sideArray[64].addSide(sideArray[58]);
        sideArray[64].addSide(sideArray[59]);
        sideArray[64].addSide(sideArray[69]);
        sideArray[64].addSide(sideArray[70]);
        sideArray[65].addSide(sideArray[60]);
        sideArray[65].addSide(sideArray[61]);
        sideArray[65].addSide(sideArray[71]);
        sideArray[66].addSide(sideArray[62]);
        sideArray[66].addSide(sideArray[67]);
        sideArray[67].addSide(sideArray[63]);
        sideArray[67].addSide(sideArray[66]);
        sideArray[67].addSide(sideArray[68]);
        sideArray[68].addSide(sideArray[63]);
        sideArray[68].addSide(sideArray[67]);
        sideArray[68].addSide(sideArray[69]);
        sideArray[69].addSide(sideArray[64]);
        sideArray[69].addSide(sideArray[68]);
        sideArray[69].addSide(sideArray[70]);
        sideArray[70].addSide(sideArray[64]);
        sideArray[70].addSide(sideArray[69]);
        sideArray[70].addSide(sideArray[71]);
        sideArray[71].addSide(sideArray[65]);
        sideArray[71].addSide(sideArray[70]);

        sideArray[0].addPoint(0);
        sideArray[0].addPoint(3);
        sideArray[1].addPoint(0);
        sideArray[1].addPoint(4);
        sideArray[2].addPoint(1);
        sideArray[2].addPoint(4);
        sideArray[3].addPoint(1);
        sideArray[3].addPoint(5);
        sideArray[4].addPoint(2);
        sideArray[4].addPoint(5);
        sideArray[5].addPoint(2);
        sideArray[5].addPoint(6);
        sideArray[6].addPoint(3);
        sideArray[6].addPoint(7);
        sideArray[7].addPoint(4);
        sideArray[7].addPoint(8);
        sideArray[8].addPoint(5);
        sideArray[8].addPoint(9);
        sideArray[9].addPoint(6);
        sideArray[9].addPoint(10);
        sideArray[10].addPoint(7);
        sideArray[10].addPoint(11);
        sideArray[11].addPoint(7);
        sideArray[11].addPoint(12);
        sideArray[12].addPoint(8);
        sideArray[12].addPoint(12);
        sideArray[13].addPoint(8);
        sideArray[13].addPoint(13);
        sideArray[14].addPoint(9);
        sideArray[14].addPoint(13);
        sideArray[15].addPoint(9);
        sideArray[15].addPoint(14);
        sideArray[16].addPoint(10);
        sideArray[16].addPoint(14);
        sideArray[17].addPoint(10);
        sideArray[17].addPoint(15);
        sideArray[18].addPoint(11);
        sideArray[18].addPoint(16);
        sideArray[19].addPoint(12);
        sideArray[19].addPoint(17);
        sideArray[20].addPoint(13);
        sideArray[20].addPoint(18);
        sideArray[21].addPoint(14);
        sideArray[21].addPoint(19);
        sideArray[22].addPoint(15);
        sideArray[22].addPoint(20);
        sideArray[23].addPoint(16);
        sideArray[23].addPoint(21);
        sideArray[24].addPoint(16);
        sideArray[24].addPoint(22);
        sideArray[25].addPoint(17);
        sideArray[25].addPoint(22);
        sideArray[26].addPoint(17);
        sideArray[26].addPoint(23);
        sideArray[27].addPoint(18);
        sideArray[27].addPoint(23);
        sideArray[28].addPoint(18);
        sideArray[28].addPoint(24);
        sideArray[29].addPoint(19);
        sideArray[29].addPoint(24);
        sideArray[30].addPoint(19);
        sideArray[30].addPoint(25);
        sideArray[31].addPoint(20);
        sideArray[31].addPoint(25);
        sideArray[32].addPoint(20);
        sideArray[32].addPoint(26);
        sideArray[33].addPoint(21);
        sideArray[33].addPoint(27);
        sideArray[34].addPoint(22);
        sideArray[34].addPoint(28);
        sideArray[35].addPoint(23);
        sideArray[35].addPoint(29);
        sideArray[36].addPoint(24);
        sideArray[36].addPoint(30);
        sideArray[37].addPoint(25);
        sideArray[37].addPoint(31);
        sideArray[38].addPoint(26);
        sideArray[38].addPoint(32);
        sideArray[39].addPoint(27);
        sideArray[39].addPoint(33);
        sideArray[40].addPoint(28);
        sideArray[40].addPoint(33);
        sideArray[41].addPoint(28);
        sideArray[41].addPoint(34);
        sideArray[42].addPoint(29);
        sideArray[42].addPoint(34);
        sideArray[43].addPoint(29);
        sideArray[43].addPoint(35);
        sideArray[44].addPoint(30);
        sideArray[44].addPoint(35);
        sideArray[45].addPoint(30);
        sideArray[45].addPoint(36);
        sideArray[46].addPoint(31);
        sideArray[46].addPoint(36);
        sideArray[47].addPoint(31);
        sideArray[47].addPoint(37);
        sideArray[48].addPoint(32);
        sideArray[48].addPoint(37);
        sideArray[49].addPoint(33);
        sideArray[49].addPoint(38);
        sideArray[50].addPoint(34);
        sideArray[50].addPoint(39);
        sideArray[51].addPoint(35);
        sideArray[51].addPoint(40);
        sideArray[52].addPoint(36);
        sideArray[52].addPoint(41);
        sideArray[53].addPoint(37);
        sideArray[53].addPoint(42);
        sideArray[54].addPoint(38);
        sideArray[54].addPoint(43);
        sideArray[55].addPoint(39);
        sideArray[55].addPoint(43);
        sideArray[56].addPoint(39);
        sideArray[56].addPoint(44);
        sideArray[57].addPoint(40);
        sideArray[57].addPoint(44);
        sideArray[58].addPoint(40);
        sideArray[58].addPoint(45);
        sideArray[59].addPoint(41);
        sideArray[59].addPoint(45);
        sideArray[60].addPoint(41);
        sideArray[60].addPoint(46);
        sideArray[61].addPoint(42);
        sideArray[61].addPoint(46);
        sideArray[62].addPoint(43);
        sideArray[62].addPoint(47);
        sideArray[63].addPoint(44);
        sideArray[63].addPoint(48);
        sideArray[64].addPoint(45);
        sideArray[64].addPoint(49);
        sideArray[65].addPoint(46);
        sideArray[65].addPoint(50);
        sideArray[66].addPoint(47);
        sideArray[66].addPoint(51);
        sideArray[67].addPoint(48);
        sideArray[67].addPoint(51);
        sideArray[68].addPoint(48);
        sideArray[68].addPoint(52);
        sideArray[69].addPoint(49);
        sideArray[69].addPoint(52);
        sideArray[70].addPoint(49);
        sideArray[70].addPoint(53);
        sideArray[71].addPoint(50);
        sideArray[71].addPoint(53);

        pointArray[0].add2Sides(0, 1);
        pointArray[1].add2Sides(2, 3);
        pointArray[2].add2Sides(4, 5);
        pointArray[3].add2Sides(0, 6);
        pointArray[4].add3Sides(1, 2, 7);
        pointArray[5].add3Sides(3, 4, 8);
        pointArray[6].add2Sides(5, 9);
        pointArray[7].add3Sides(6, 10, 11);
        pointArray[8].add3Sides(7, 12, 13);
        pointArray[9].add3Sides(8, 14, 15);
        pointArray[10].add3Sides(9, 16, 17);
        pointArray[11].add2Sides(10, 18);
        pointArray[12].add3Sides(11, 12, 19);
        pointArray[13].add3Sides(13, 14, 20);
        pointArray[14].add3Sides(15, 16, 21);
        pointArray[15].add2Sides(17, 22);
        pointArray[16].add3Sides(18, 23, 24);
        pointArray[17].add3Sides(19, 25, 26);
        pointArray[18].add3Sides(20, 27, 28);
        pointArray[19].add3Sides(21, 29, 30);
        pointArray[20].add3Sides(22, 31, 32);
        pointArray[21].add2Sides(23, 33);
        pointArray[22].add3Sides(24, 25, 34);
        pointArray[23].add3Sides(26, 27, 35);
        pointArray[24].add3Sides(28, 29, 36);
        pointArray[25].add3Sides(30, 31, 37);
        pointArray[26].add2Sides(32, 38);
        pointArray[27].add2Sides(33, 39);
        pointArray[28].add3Sides(34, 40, 41);
        pointArray[29].add3Sides(35, 42, 43);
        pointArray[30].add3Sides(36, 44, 45);
        pointArray[31].add3Sides(37, 46, 47);
        pointArray[32].add2Sides(38, 48);
        pointArray[33].add3Sides(39, 40, 49);
        pointArray[34].add3Sides(41, 42, 50);
        pointArray[35].add3Sides(43, 44, 51);
        pointArray[36].add3Sides(45, 46, 52);
        pointArray[37].add3Sides(47, 48, 53);
        pointArray[38].add2Sides(49, 54);
        pointArray[39].add3Sides(50, 55, 56);
        pointArray[40].add3Sides(51, 57, 58);
        pointArray[41].add3Sides(52, 59, 60);
        pointArray[42].add2Sides(53, 61);
        pointArray[43].add3Sides(54, 55, 62);
        pointArray[44].add3Sides(56, 57, 63);
        pointArray[45].add3Sides(58, 59, 64);
        pointArray[46].add3Sides(60, 61, 65);
        pointArray[47].add2Sides(62, 66);
        pointArray[48].add3Sides(63, 67, 68);
        pointArray[49].add3Sides(64, 69, 70);
        pointArray[50].add2Sides(65, 71);
        pointArray[51].add2Sides(66, 67);
        pointArray[52].add2Sides(68, 69);
        pointArray[53].add2Sides(70, 71);

        pointArray[0].add2Points(3, 4);
        pointArray[1].add2Points(4, 5);
        pointArray[2].add2Points(5, 6);
        pointArray[3].add2Points(0, 7);
        pointArray[4].add3Points(0, 1, 8);
        pointArray[5].add3Points(1, 2, 9);
        pointArray[6].add2Points(2, 10);
        pointArray[7].add3Points(3, 11, 12);
        pointArray[8].add3Points(4, 12, 13);
        pointArray[9].add3Points(5, 13, 14);
        pointArray[10].add3Points(6, 14, 15);
        pointArray[11].add2Points(7, 16);
        pointArray[12].add3Points(7, 8, 17);
        pointArray[13].add3Points(8, 9, 18);
        pointArray[14].add3Points(9, 10, 19);
        pointArray[15].add2Points(10, 20);
        pointArray[16].add3Points(11, 21, 22);
        pointArray[17].add3Points(12, 22, 23);
        pointArray[18].add3Points(13, 23, 24);
        pointArray[19].add3Points(14, 24, 25);
        pointArray[20].add3Points(15, 25, 26);
        pointArray[21].add2Points(16, 27);
        pointArray[22].add3Points(16, 17, 28);
        pointArray[23].add3Points(17, 18, 29);
        pointArray[24].add3Points(18, 19, 30);
        pointArray[25].add3Points(19, 20, 31);
        pointArray[26].add2Points(20, 32);
        pointArray[27].add2Points(21, 33);
        pointArray[28].add3Points(22, 33, 34);
        pointArray[29].add3Points(23, 34, 35);
        pointArray[30].add3Points(24, 35, 36);
        pointArray[31].add3Points(25, 36, 37);
        pointArray[32].add2Points(26, 37);
        pointArray[33].add3Points(27, 28, 38);
        pointArray[34].add3Points(28, 29, 39);
        pointArray[35].add3Points(29, 30, 40);
        pointArray[36].add3Points(30, 31, 41);
        pointArray[37].add3Points(31, 32, 42);
        pointArray[38].add2Points(33, 43);
        pointArray[39].add3Points(34, 43, 44);
        pointArray[40].add3Points(35, 44, 45);
        pointArray[41].add3Points(36, 45, 46);
        pointArray[42].add2Points(37, 46);
        pointArray[43].add3Points(38, 39, 47);
        pointArray[44].add3Points(39, 40, 48);
        pointArray[45].add3Points(40, 41, 49);
        pointArray[46].add3Points(41, 42, 50);
        pointArray[47].add2Points(43, 51);
        pointArray[48].add3Points(44, 51, 52);
        pointArray[49].add3Points(45, 52, 53);
        pointArray[50].add2Points(46, 53);
        pointArray[51].add2Points(47, 48);
        pointArray[52].add2Points(48, 49);
        pointArray[53].add2Points(49, 50);

        tileArray[0] = new Tile("lumber", 11, pointArray, new int[]{0, 4, 8, 12, 7, 3, 0}, Color.GREEN.darker().darker());
        tileArray[1] = new Tile("wool", 12, pointArray, new int[]{1, 5, 9, 13, 8, 4, 1}, Color.GREEN);
        tileArray[2] = new Tile("grain", 9, pointArray, new int[]{2, 6, 10, 14, 9, 5, 2}, Color.YELLOW);
        tileArray[3] = new Tile("brick", 4, pointArray, new int[]{7, 12, 17, 22, 16, 11, 7}, Color.ORANGE.darker());
        tileArray[4] = new Tile("ore", 6, pointArray, new int[]{8, 13, 18, 23, 17, 12, 8}, Color.GRAY);
        tileArray[5] = new Tile("brick", 5, pointArray, new int[]{9, 14, 19, 24, 18, 13, 9}, Color.ORANGE.darker());
        tileArray[6] = new Tile("wool", 10, pointArray, new int[]{10, 15, 20, 25, 19, 14, 10}, Color.GREEN);

        tileArray[7] = new Tile("DESERT", 5, pointArray, new int[]{16, 22, 28, 33, 27, 21, 16}, Color.GREEN);
        tileArray[8] = new Tile("lumber", 3, pointArray, new int[]{17, 23, 29, 34, 28, 22, 17}, Color.GREEN.darker().darker());
        tileArray[9] = new Tile("grain", 11, pointArray, new int[]{18, 24, 30, 35, 29, 23, 18}, Color.YELLOW);
        tileArray[10] = new Tile("lumber", 4, pointArray, new int[]{19, 25, 31, 36, 30, 24, 19}, Color.GREEN.darker().darker());
        tileArray[11] = new Tile("grain", 8, pointArray, new int[]{20, 26, 32, 37, 31, 25, 20}, Color.YELLOW);
        tileArray[12] = new Tile("brick", 8, pointArray, new int[]{28, 34, 39, 43, 38, 33, 28}, Color.ORANGE.darker());
        tileArray[13] = new Tile("wool", 10, pointArray, new int[]{29, 35, 40, 44, 39, 34, 29}, Color.GREEN);
        tileArray[14] = new Tile("wool", 9, pointArray, new int[]{30, 36, 41, 45, 40, 35, 30}, Color.GREEN);
        tileArray[15] = new Tile("ore", 3, pointArray, new int[]{31, 37, 42, 46, 41, 36, 31}, Color.GRAY);
        tileArray[16] = new Tile("ore", 5, pointArray, new int[]{39, 44, 48, 51, 47, 43, 39}, Color.GRAY);
        tileArray[17] = new Tile("grain", 2, pointArray, new int[]{40, 45, 49, 52, 48, 44, 40}, Color.YELLOW);
        tileArray[18] = new Tile("lumber", 6, pointArray, new int[]{41, 46, 50, 53, 49, 45, 41}, Color.GREEN.darker().darker());
        
        

        pointArray[0].add1Tiles(0);
        pointArray[1].add1Tiles(1);
        pointArray[2].add1Tiles(2);
        pointArray[3].add1Tiles(0);
        pointArray[4].add2Tiles(0, 1);
        pointArray[5].add2Tiles(1, 2);
        pointArray[6].add1Tiles(2);
        pointArray[7].add2Tiles(0, 3);
        pointArray[8].add3Tiles(0, 1, 4);
        pointArray[9].add3Tiles(1, 2, 5);
        pointArray[10].add2Tiles(2, 6);
        pointArray[11].add1Tiles(3);
        pointArray[12].add3Tiles(0, 3, 4);
        pointArray[13].add3Tiles(1, 4, 5);
        pointArray[14].add3Tiles(2, 5, 6);
        pointArray[15].add1Tiles(6);
        pointArray[16].add2Tiles(3, 7);
        pointArray[17].add3Tiles(3, 4, 8);
        pointArray[18].add3Tiles(4, 5, 9);
        pointArray[19].add3Tiles(5, 6, 10);
        pointArray[20].add2Tiles(6, 11);
        pointArray[21].add1Tiles(7);
        pointArray[22].add3Tiles(3, 7, 8);
        pointArray[23].add3Tiles(4, 8, 9);
        pointArray[24].add3Tiles(5, 9, 10);
        pointArray[25].add3Tiles(6, 10, 11);
        pointArray[26].add1Tiles(11);
        pointArray[27].add1Tiles(7);
        pointArray[28].add3Tiles(7, 8, 12);
        pointArray[29].add3Tiles(8, 9, 13);
        pointArray[30].add3Tiles(9, 10, 14);
        pointArray[31].add3Tiles(10, 11, 15);
        pointArray[32].add1Tiles(11);
        pointArray[33].add2Tiles(7, 12);
        pointArray[34].add3Tiles(8, 12, 13);
        pointArray[35].add3Tiles(9, 13, 14);
        pointArray[36].add3Tiles(10, 14, 15);
        pointArray[37].add2Tiles(11, 15);
        pointArray[38].add1Tiles(12);
        pointArray[39].add3Tiles(12, 13, 16);
        pointArray[40].add3Tiles(13, 14, 17);
        pointArray[41].add3Tiles(14, 15, 18);
        pointArray[42].add1Tiles(15);
        pointArray[43].add2Tiles(12, 16);
        pointArray[44].add3Tiles(13, 16, 17);
        pointArray[45].add3Tiles(14, 17, 18);
        pointArray[46].add2Tiles(15, 18);
        pointArray[47].add1Tiles(16);
        pointArray[48].add2Tiles(16, 17);
        pointArray[49].add2Tiles(17, 18);
        pointArray[50].add1Tiles(18);
        pointArray[51].add1Tiles(16);
        pointArray[52].add1Tiles(17);
        pointArray[53].add1Tiles(18);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g2d;
        int g2dcnt =0;

        for (int i = 0; i < 19; i++) {
            g.setColor(tileArray[i].getColor());
            g.fillPolygon(tileArray[i].getPolygon());
            g.setColor(Color.BLACK);
            g.setFont(new Font("Impact", 1, 50));
            g.drawString(Integer.toString(tileArray[i].getDiceNumber()), tileArray[i].getCenterX(), tileArray[i].getCenterY());
        }
        
        
        g.setColor(Color.DARK_GRAY.brighter());
                
        //0-10
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        
        
        
        //10-20
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        
        //20-30
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        
        
        //30-40
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        
        
        //40-50
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        
        
        //50-60
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        
        
        //60-70
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDown, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        
        
        //71-72
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownR, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        g2d = (Graphics2D) g.create();
        g2d.setColor(sideArray[g2dcnt].getColor());
        g2d.rotate(Road.aDownL, sideArray[g2dcnt].x, sideArray[g2dcnt].y+(sideArray[g2dcnt].height/2));
        g2d.fill(sideArray[g2dcnt]);
        sideGraphic.add(g2d);
        g2dcnt++;
        
        
        for (int i = 0; i < 54; i++) {
	    g.setColor(pointArray[i].getSettlementColor());
            coords = pointArray[i].getBoardCoords();
            Ellipse2D ellipse = new Ellipse2D.Double();
            ellipse.setFrameFromCenter(coords[0], coords[1], coords[0] - 5.0, coords[1] - 5.0);
            g2.draw(ellipse);
            g2.fill(ellipse);
        }
    }
	
	public void assessCoordsPressed()
	{
		for (int i = 0; i < 54; i++)
		{
			coords = pointArray[i].getBoardCoords();
			if (eventCoords[0] < coords[0] + 5.0 && eventCoords[0] > coords[0] - 5.0 && eventCoords[1] < coords[1] + 5.0 && eventCoords[1] > coords[1] - 5.0)		
			{
				pointArray[i].setSettlementColor(Color.ORANGE);
				break;
			}
		}
	
		repaint();
	}

	public void assessCoordsReleased()
	{
		for (int i = 0; i < 54; i++)
		{
			coords = pointArray[i].getBoardCoords();
			{
				pointArray[i].setSettlementColor(Color.BLACK);
				break;
			}
		}
		
		repaint();
	}

	private class SettlementColorChange extends MouseAdapter
	{
		public SettlementColorChange()
		{
		}

		public void mousePressed(MouseEvent e)
		{
			eventCoords[0] = e.getX();
			eventCoords[1] = e.getY();
			assessCoordsPressed();
		}
	
		public void mouseReleased(MouseEvent e)
		{
			eventCoords[0] = e.getX();
			eventCoords[1] = e.getY();
			assessCoordsReleased();
		}
	}
}
