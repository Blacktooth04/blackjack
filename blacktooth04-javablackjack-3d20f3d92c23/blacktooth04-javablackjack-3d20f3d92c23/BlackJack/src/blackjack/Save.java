/**
 * Russell Lilljedahl
 * 28 July 2018
 * Blackjack
*/
package blackjack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author russell3233
 */
public class Save {
    
    public void saveData(String[] statArray) {
        File file = new File("./SAVES/statistics.txt");
        try{
            FileWriter fw = new FileWriter(file, false);
            for (String statArray1 : statArray) {
                fw.write(statArray1 + ",");
            }
            fw.close();
        } catch (IOException ex) {
        }
    }
    
}
