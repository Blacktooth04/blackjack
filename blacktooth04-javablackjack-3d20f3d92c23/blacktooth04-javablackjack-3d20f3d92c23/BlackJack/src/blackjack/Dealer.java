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
public class Dealer extends NPCInheriter implements NPCInterface {
   
    // TODO
    // Multiple Inheritance
    
    public Dealer() {
        hand = new ArrayList<>();
        deck = new Deck();
    }
              
    @Override
    public void AI(List<Card> newDeck) {
        int distanceFromBlackJack = PlayGame.blackJackNumber - cardValueTotal(hand);
        while (distanceFromBlackJack > 5) {
            getNextCard(newDeck, hand);
            distanceFromBlackJack = PlayGame.blackJackNumber - cardValueTotal(hand);
        }
    }


    
}
