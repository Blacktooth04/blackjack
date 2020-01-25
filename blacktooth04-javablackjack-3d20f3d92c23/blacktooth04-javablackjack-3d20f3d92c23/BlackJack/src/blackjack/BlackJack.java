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
public class BlackJack {


    public static void main(String[] args) throws IOException {
        createNewFileMethod();
        MainMenuGUI main = new MainMenuGUI();
        main.setVisible(true);
    }
    
    // create new statistics file if first time running
    private static void createNewFileMethod() throws IOException {
        
        File file = new File("./SAVES/statistics.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Created new file: " + file.toString());
            // wins, losses, blackjacks, forfeits, busts, chipCount
            try (FileWriter fw = new FileWriter(file, false) // true appends
            ) {
                // wins, losses, blackjacks, forfeits, busts, chipCount
                fw.write("0,0,0,0,0,1000");
            }
        } 
    } // end createNewFile Methods
}
