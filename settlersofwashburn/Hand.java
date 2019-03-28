/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settlersofwashburn;

import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class Hand {
    private ArrayList<Card> brick;
    private ArrayList<Card> wool;
    private ArrayList<Card> ore;
    private ArrayList<Card> grain;
    private ArrayList<Card> lumber;
    public Hand(){
        brick= new ArrayList<Card>();
        wool= new ArrayList<Card>();
        ore= new ArrayList<Card>();
        grain= new ArrayList<Card>();
        lumber= new ArrayList<Card>();
    }
    public void addCard(Card card){
        if(card.getType() == Card.BRICK){
           brick.add(card);
        }
        if(card.getType() == Card.WOOL){
           wool.add(card);
        }
        if(card.getType() == Card.ORE){
           ore.add(card);
        }
        if(card.getType() == Card.GRAIN){
           grain.add(card);
        }
        if(card.getType() == Card.LUMBER){
           lumber.add(card);
        }
        
    }
    public void removeCard(Card card){
        if(card.getType() == Card.BRICK){
           brick.remove(0);
        }
        if(card.getType() == Card.WOOL){
           wool.remove(0);
        }
        if(card.getType() == Card.ORE){
           ore.remove(0);
        }
        if(card.getType() == Card.GRAIN){
           grain.remove(0);
        }
        if(card.getType() == Card.LUMBER){
           lumber.remove(0);
        }
    }
}
