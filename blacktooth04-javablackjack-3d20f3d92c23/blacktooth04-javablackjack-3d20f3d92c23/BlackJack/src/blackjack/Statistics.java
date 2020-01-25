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
public class Statistics {
    
    //wins, losses, blackJacks, forfeits, busts, chipCount
    private final int  chipCount;
    int[] loadArray;
        
    // learned to not throw exception from method.
    // will cause everything downline to have to call it.
    public Statistics()  {
        loadArray = new int[6];
        Load load = new Load();
        load.loadFile(loadArray);
        this.chipCount = (loadArray[5]);
        
    }
    
    public int[] getStatArray() {
        return loadArray;
    }
       
    public int getChipCount() {
        return chipCount;
    }
    
    
    
}
