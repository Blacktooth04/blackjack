/**
 * Russell Lilljedahl
 * 28 July 2018
 * Blackjack
*/
package blackjack;

/**
 *
 * @author russell3233
 */
public class Card {
    
    private final String faceValue, suit;
    private int cardValue;
    
    public Card(String faceValue, String suit) {
        this.faceValue = faceValue;
        this.suit = suit;
        this.cardValue = assignCardValue(faceValue);
    }

    
    private int assignCardValue(String faceValue) {
        int cardValue;
        if (faceValue.startsWith("J") || faceValue.startsWith("Q")
                || faceValue.startsWith("K")) {
            cardValue = 10;
        } else if (faceValue.startsWith("A")) {
            cardValue = 11; // convert to 1 later if necessary
        } else { 
            cardValue = Integer.parseInt(faceValue);
        }
        return cardValue;
    }
    
    public int getValue() {
        return this.cardValue;
    }
    
    // TODO
    // TEMPORARY until i draw some cards
    public String cardString() {
        return (this.faceValue + " of " + this.suit);        
    }
    
    public boolean canValueBeLowered() {      
        return this.getValue() == 11;
    }
    
    public void reassignCardValue() {
        this.cardValue = 1;
    }
    
}
