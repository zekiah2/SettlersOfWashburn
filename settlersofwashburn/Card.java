/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settlersofwashburn;

/**
 *
 * @author Jacob
 */
public class Card 
{
    public static final int BRICK=0;
    public static final int WOOL=1;
    public static final int ORE=2;
    public static final int GRAIN=3;
    public static final int LUMBER=4;
    
    private int type;
    public Card(int type){
        this.type=type;
    }
    public void setType(int type){
        this.type=type;
    }
    public  int getType(){
        return type;
    }
}
