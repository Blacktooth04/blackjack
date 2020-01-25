/**
 * Russell Lilljedahl
 * 28 July 2018
 * Blackjack
*/
package blackjack;

import java.util.List;

/**
 *
 * @author russell3233
 */
public class NPCInheriter extends PlayerInheriter {
    
    public String getAIStartingHand(List<Card> newDeck, List<Card> deckToCheck) {
        getNextCard(newDeck, deckToCheck);
        return ("Showing: " + getNextCard(newDeck, deckToCheck));
    }

    public String getStartingHand(List<Card> newDeck) {
        String dealerHand = getAIStartingHand(newDeck, hand);
        return dealerHand;
    }
    
    public int hiddenFirstCard() {
        int total = 0;
        for (int i = 1; i < hand.size(); i++) {
            total = iterateThroughHand(hand, total, i);
        }
        return total;        
    }
    
    public String cardArray() {
        String output = "";
        for (int i = 0; i < hand.size(); i++) {
            card = hand.get(i);
            output += "\n" + card.cardString();
        }
        return output;
    }
    
}
