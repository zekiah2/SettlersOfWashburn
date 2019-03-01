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
    private ArrayList<Card> hand;
    public Hand(){
        hand= new ArrayList<Card>();
    }
    public void addCard(Card card){
        hand.add(card);
    }
    public void removeCard(Card card){
        hand.remove(card);
    }
    public Object[] getHand(){
        return hand.toArray();
    }
}
