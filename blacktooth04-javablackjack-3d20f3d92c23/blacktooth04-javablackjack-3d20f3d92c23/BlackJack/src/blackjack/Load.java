/**
 * Russell Lilljedahl
 * 28 July 2018
 * Blackjack
*/
package blackjack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author russell3233
 */
public class Load {
    
    File file;
    BufferedReader br;
    
    public Load() {
        file = new File("./SAVES/statistics.txt");
    }
    
    public int[] loadFile(int[] statArray) {
        
        try {
            br = new BufferedReader(new FileReader(file));
            
            String line = null;
            String[] list = new String[6];
            // read in data, push to string array ignoring the comma
            while ((line = br.readLine()) != null) {
                list = line.split(",");
            }
            // convert string array to int
            for (int i = 0; i < list.length; i++) {
                statArray[i] = Integer.parseInt(list[i]);
            }
            
        } catch (IOException ex) {
            
        }
        return statArray;
    }
    
    public List<String> loadRules()  {
        List<String> rules = new ArrayList<>(); // 14 lines max
        file = new File("./SAVES/rules.txt");
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                rules.add(line);
                rules.add("\n");
            }
        } catch (IOException ex) {
            
        }
        
        return rules;
    }
}
