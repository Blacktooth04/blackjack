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
public interface NPCInterface {
                 
    // TODO FUTURE
    // Moved most of these to NPC and Player Inheriter
    // Maybe implement an AI here, including player
    // or allow everyone to use insurance, double down, etc.

    public void AI(List<Card> newDeck);
    
    /**
     * TODO
     */
    
    // void double();
    // void insurance();
    // void split();
    
    
}
