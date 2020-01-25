/**
 * Russell Lilljedahl
 * 28 July 2018
 * Blackjack
*/
package blackjack;

import java.util.List;
import java.util.Collections;

/**
 *
 * @author russell3233
 */
public class Deck {
    
    final String[] suits = {"Heart", "Spade", "Club", "Diamonds"};;
    final String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", 
            "Jack", "Queen", "King", "Ace"};
//    final String[] faces = {"Ace"};
   
    private final int numberOfDecks = 8;
    
    public Deck() {
    }
    
    public List<Card> buildDeck(List<Card> deck) {
        createDeck(faces, suits, deck);
        return deck;
    }
    
    private List<Card> createDeck(String[] faces, String[] suits, List<Card> deck) {
        // iterate through suits and faces
        // add them to deck
        for (int i = 0; i < numberOfDecks; i++) {
            for (String suit : suits) {
                for (String face : faces) {
                    Card card = new Card(face, suit); 
                    deck.add(card);
                }
            }
        }
        return deck;
    }
    
    public List<Card> shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
        return deck;
    }
    
    public Card drawCard(List<Card> deck) {
        Card card = deck.remove(0);
        return card;
    }
    
    public int findCardValue(Card card) {
        int total = card.getValue();
        return total;
    }
    
    
}

