/**
 * Russell Lilljedahl
 * 29 August 2018
 * Blackjack
*/
package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author russell3233
 */
public class PlayerInheriter {
    
    Deck deck;
    Card card;
    List<Integer> aceLocationArray;
    List<Card> hand;
    int arrayLocation, total; // save the position for where to iterate
    
    public int iterateThroughHand(java.util.List<Card> hand, int total, int i) {
        card = hand.get(i); 
        total += deck.findCardValue(card);
        return total;
    }
    
    public boolean testForBlackJack(int point) {
        return point == PlayGame.blackJackNumber;
    }
    
    public int cardValueTotal(List<Card> deckToCheck) {
        int total = 0;
        aceLocationArray = new ArrayList<>();
        for (int i = 0; i < deckToCheck.size(); i++) {
            card = deckToCheck.get(i);
            // test if the card is an ace, if so, store it in the location array
            if (card.cardString().contains("Ace"))
                aceLocationArray.add(i);
            total = iterateThroughHand(deckToCheck, total, i);
        }
        return total;
    }
    
    public int testBustForAce(List<Card> deckToCheck, int location) {
        // if the player busted and there is an ace
        card = deckToCheck.get(aceLocationArray.get(location));
        if (card.canValueBeLowered()) 
            card.reassignCardValue();
        location++; // move to next array value if it's necessary to run again
        return location;
    }
    
    public String getNextCard(List<Card> newDeck, List<Card> deckToCheck) {
        card = deck.drawCard(newDeck);
        deckToCheck.add(card);
        return card.cardString();
    }

    public int getDeckValue () {
        total = cardValueTotal(hand);
        arrayLocation = 0;
        while (total > PlayGame.blackJackNumber && !aceLocationArray.isEmpty() 
                && aceLocationArray.size() > arrayLocation) {
            arrayLocation = testBustForAce(hand, arrayLocation);
            total = cardValueTotal(hand);
        }
        return total;        
    }
    
    public String getCard(List<Card> deck) {
        return getNextCard(deck, hand);
    }
}
