/**
 * Russell Lilljedahl
 * 28 July 2018
 * Blackjack
*/
package blackjack;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author russell3233
 */
public class PlayGame {
    
    List<Card> newDeck;
    Card card;
    private int wins, losses, blackJacks, forfeits, busts, chipCount;
    public final static int blackJackNumber = 21, dealerStoppingPoint = 6;
    Deck deck;
    Statistics stats;
    boolean playerBlackJack;
    Player player;
    Dealer dealer;
    
    public PlayGame()   {
        newDeck = new ArrayList<>();
        stats = new Statistics();
        int[] statArray = stats.getStatArray();
        wins = statArray[0];
        losses = statArray[1];
        blackJacks = statArray[2];
        forfeits = statArray[3];
        busts = statArray[4];
        chipCount = statArray[5];
        System.out.println("Init Chips: " + chipCount);
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
    }
    
    public void resetHands() {
        player = new Player();
        dealer = new Dealer();
    }
    
    public int initialChips() {
        return chipCount;
    }
    
// <editor-fold defaultstate="collapsed" desc="***********load/save********">
    //wins, losses, blackJacks, forfeits, busts, chipCount
    public void loadStats()  {
        int[] statArray = stats.getStatArray();
        this.wins = statArray[0];
        this.losses = statArray[1];
        this.blackJacks = statArray[2];
        this.forfeits = statArray[3];
        this.busts = statArray[4];
    }
    
    public String[] getStatArray() {
        String[] statArray = new String[6];
        statArray[0] = Integer.toString(wins);
        statArray[1] = Integer.toString(losses);
        statArray[2] = Integer.toString(blackJacks);
        statArray[3] = Integer.toString(forfeits);
        statArray[4] = Integer.toString(busts);
        statArray[5] = Integer.toString(chipCount);
        return statArray;
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="***********incrementers********">
    public void incrementWins() {
        wins++;
    }
    public void incrementLosses() {
        losses++;
   }
    public void incrementBlackJack() {
        blackJacks++;
    }
    public void incrementForfeits() {
        forfeits++;
    }
    public void incrementBusts() {
        busts++;
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="***********chips********">
    public int getChipCount() {
        return chipCount;
    }
    public int giveChips() {
        JOptionPane.showMessageDialog(null, "You're out of chips.\nHave a thousand on the house.");
        return 1000;
    }
    public boolean hasEnoughChips(int number) {
        return (chipCount - number) >= 0;
    }
    public void setChip(int number) {
        chipCount = number;
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="***********game logic********">
    public List<Card> buildDeck() {
        newDeck = deck.buildDeck(newDeck);
        newDeck = deck.shuffleDeck(newDeck);
        return newDeck;
    }

    public boolean decideIfTie(int one, int two){
        return one == two;
    }
    
    public boolean decideWinOrLoss(int one, int two) {
        return one > two;
        
//        if (two > blackJackNumber)
//            return true;
//        else 
//            return one > two;
    }
    
    public void finishedPlaying() {
        Save save = new Save();
        save.saveData(getStatArray());
    }
    
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="***********win/loss conditions************">
    
    public void blackJack()  {
        JOptionPane.showMessageDialog(null, "Blackjack!");
        incrementBlackJack();
    }
    
    public void win()  {
        JOptionPane.showMessageDialog(null, "You win!");
        incrementWins();
    }
    
    public void loss()  {
        JOptionPane.showMessageDialog(null, "You lose.");
        incrementLosses();
    }

    public void bust() {
        JOptionPane.showMessageDialog(null, "Busted");
        incrementBusts();
        incrementLosses();
    }
    
    public void forfeit()  {
        incrementForfeits();
    }
    
    public void tie()  {
        JOptionPane.showMessageDialog(null, "Tie");
    }
    
//    public boolean seeWhoWon(int one, int two)  {
//        boolean tie = decideIfTie(one, two);
//        if (tie) {
//            return true; // let the GUI know there was a tie
//        } else {
//            boolean win = decideWinOrLoss(one, two);
//            if (win)
//                win();
//            else
//                loss();
//            return false;
//        }
//    }
    
    
// </editor-fold>    
    
    
// <editor-fold defaultstate="collapsed" desc="***********initial draw********">
    public String getPlayerStartingHand(List<Card> newDeck) {
        return player.getStartingHand(newDeck);
    }
    public String getPlayerDeckValue() {
        return Integer.toString(player.getDeckValue());
    }
    public void testForPlayerBlackJack() {
        setPlayerBlackJack(player.testForBlackJack(player.getDeckValue()));
    }
    public void setPlayerBlackJack(boolean input) {
        playerBlackJack = input;
    }
    public boolean didPlayerBlackJack(){
        return playerBlackJack;
    }
    public String getPlayerCard(List<Card> newDeck) {
        return player.getCard(newDeck);
    }
    
    // use the string input to handle different npc's
    public String getNPCStartingHand (List<Card> newDeck, String NPC) {
        return dealer.getStartingHand(newDeck);
//        if (NPC.contains("dealer"))
//            return dealer.getStartingHand(newDeck);
//        else
//            return dealer.getStartingHand(newDeck);
    }
    public String getInitialDeckValue(String NPC) {
        return Integer.toString(dealer.hiddenFirstCard());
    }
    public String getNPCDeckValue(String NPC) {
        return Integer.toString(dealer.getDeckValue());
//        if (NPC.contains("dealer"))
//            return Integer.toString(dealer.getDeckValue());
//        else
//            return Integer.toString(dealer.getDeckValue());
    }
    public boolean testForNPCBlackJack(String NPC) {
        return dealer.testForBlackJack(dealer.getDeckValue());
//        if (NPC.contains("dealer"))
//            return dealer.testForBlackJack(dealer.getDeckValue());
//        else
//            return false;
    }
    public String NPCCardArray(String NPC) { // if NPC blackjacks, show all cards
        return dealer.cardArray();
//        if (NPC.contains("dealer"))
//            return dealer.cardArray();
//        else
//            return dealer.cardArray();
    }
    public void runAI(String NPC, List<Card> newDeck) {
        dealer.AI(newDeck);
//        if (NPC.contains("Dealer"))
//            dealer.AI(newDeck);
    }
// </editor-fold>

}
