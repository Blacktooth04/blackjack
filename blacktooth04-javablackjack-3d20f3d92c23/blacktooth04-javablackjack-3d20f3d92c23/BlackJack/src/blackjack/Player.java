/**
 * Russell Lilljedahl
 * 28 July 2018
 * Blackjack
*/
package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author russell3233
 */
public class Player extends PlayerInheriter implements NPCInterface {

    public Player() {
        hand = new ArrayList<>();
        deck = new Deck();
    }
                   
    public String getStartingHand(List<Card> newDeck) {
        return (getNextCard(newDeck, hand) + ", " + getNextCard(newDeck, hand));
    }

    //TODO 
    // Implement an autoplay
    @Override
    public void AI(List<Card> newDeck) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
