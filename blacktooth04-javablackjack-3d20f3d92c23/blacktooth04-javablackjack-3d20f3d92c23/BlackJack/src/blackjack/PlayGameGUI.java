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
public class PlayGameGUI extends javax.swing.JFrame {

    final int betTwentyFive = 25, betTen = 10;
    PlayGame play;
    final String dealer = "Dealer", player = "Player";
    final int numberOfPlayers = 2;
//    Player player;
//    Dealer dealer;
    boolean betsMade, finishedDealing, playerBlackJack, dealerBlackJack,
            done = false;
    List<Card> newDeck;
    int pot, playerTotal, dealerTotal;
    
    public void initPlay()  {
        play = new PlayGame();
        setChipCount(play.initialChips());
        startNewHand();
    }
    
   
    // called after every hand to clear play area
    private void startNewHand() {
        play.resetHands();
        newDeck = new ArrayList<>(); // erase shared deck
        pot = 0;
        betsMade = false;
        finishedDealing = false;
        playerBlackJack = false;
        dealerBlackJack = false;
        generalInfoArea.setText("Make a bet");
    }
    
// <editor-fold defaultstate="collapsed" desc="***********chips********">
    private void setChipCount(int number) {
        chipDisplay.setText(Integer.toString(number));
        if (number <= 0) // make sure the player has enough chips
            setChipCount(play.giveChips());
        play.setChip(number);
    }
    private void subtractChips(int bet) {
        int chipCount = play.getChipCount();
        setChipCount(chipCount -= bet);
    }
    private void addChips(int bet) {
        int chipCount = play.getChipCount();
        setChipCount(bet + chipCount);
    }
// </editor-fold>
           
    private void clearEverything() {
        startNewHand();
        playerInfoArea.setText("");
        playerPointTotal.setText("");
        dealerInfoArea.setText("");
        dealerPointTotal.setText("");
        potTotal.setText("0");
        betsMade = false;
    }
    
    // TODO
    // clean up // cleaned up a bit, decent
    private boolean drawInitialCards()  {
        generalInfoArea.setText("Dealing");
        newDeck = play.buildDeck();
        
        // starting hands
        playerInfoArea.setText(play.getPlayerStartingHand(newDeck));
        playerPointTotal.setText(play.getPlayerDeckValue());
        // TODO add other players here
        dealerInfoArea.setText(play.getNPCStartingHand(newDeck, dealer));
        dealerPointTotal.setText(play.getInitialDeckValue(dealer));
        
        // TODO
        // look at consolidating this, maybe use number of players to initialize 
        // array of player names. then iterate that through a single test for blackjack
        
        // test for blackjack       
        play.testForPlayerBlackJack();
        if (play.didPlayerBlackJack()) {
            play.blackJack();
            return true;
        }
        // test for npc blackjack
        if (play.testForNPCBlackJack(dealer)) {
            dealerInfoArea.setText(play.NPCCardArray(dealer));
            JOptionPane.showMessageDialog(null, "" + dealer + " blackjack");
            return true;
        }
        
        return false; // not done playing
    }
    
    /**
     * Creates new form PlayGameGUI
     */
    public PlayGameGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to startNewHand the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dealerPanel = new javax.swing.JPanel();
        playerPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        generalInfoArea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerInfoArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        dealerInfoArea = new javax.swing.JTextArea();
        betTenButton = new javax.swing.JButton();
        standButton = new javax.swing.JButton();
        chipDisplay = new javax.swing.JTextField();
        chipLabel = new javax.swing.JLabel();
        hitButton = new javax.swing.JButton();
        forfeitButton = new javax.swing.JButton();
        betTwentyFiveButton = new javax.swing.JButton();
        playerPointLabel = new javax.swing.JLabel();
        playerPointTotal = new javax.swing.JTextField();
        dealerPointsLabel = new javax.swing.JLabel();
        dealerPointTotal = new javax.swing.JTextField();
        dealerPointsLabel1 = new javax.swing.JLabel();
        potTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        dealerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout dealerPanelLayout = new javax.swing.GroupLayout(dealerPanel);
        dealerPanel.setLayout(dealerPanelLayout);
        dealerPanelLayout.setHorizontalGroup(
            dealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        dealerPanelLayout.setVerticalGroup(
            dealerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        playerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        playerPanelLayout.setVerticalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        infoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        generalInfoArea.setEditable(false);
        generalInfoArea.setBackground(new java.awt.Color(255, 255, 255));
        generalInfoArea.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        generalInfoArea.setText("Make a bet.");

        playerInfoArea.setEditable(false);
        playerInfoArea.setColumns(20);
        playerInfoArea.setRows(5);
        playerInfoArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(playerInfoArea);

        dealerInfoArea.setEditable(false);
        dealerInfoArea.setColumns(20);
        dealerInfoArea.setRows(5);
        dealerInfoArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(dealerInfoArea);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(generalInfoArea, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(generalInfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        betTenButton.setText("Bet 10");
        betTenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betTenButtonActionPerformed(evt);
            }
        });

        standButton.setText("Stand");
        standButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standButtonActionPerformed(evt);
            }
        });

        chipDisplay.setEditable(false);
        chipDisplay.setBackground(new java.awt.Color(255, 255, 255));
        chipDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        chipDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chipDisplayActionPerformed(evt);
            }
        });

        chipLabel.setText("Chip Count");

        hitButton.setText("Hit");
        hitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitButtonActionPerformed(evt);
            }
        });

        forfeitButton.setText("Forfeit");
        forfeitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forfeitButtonActionPerformed(evt);
            }
        });

        betTwentyFiveButton.setText("Bet 25");
        betTwentyFiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betTwentyFiveButtonActionPerformed(evt);
            }
        });

        playerPointLabel.setText("Points");

        playerPointTotal.setEditable(false);
        playerPointTotal.setBackground(new java.awt.Color(255, 255, 255));
        playerPointTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerPointTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerPointTotalActionPerformed(evt);
            }
        });

        dealerPointsLabel.setText("Points");

        dealerPointTotal.setEditable(false);
        dealerPointTotal.setBackground(new java.awt.Color(255, 255, 255));
        dealerPointTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dealerPointTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealerPointTotalActionPerformed(evt);
            }
        });

        dealerPointsLabel1.setText("Pot");

        potTotal.setEditable(false);
        potTotal.setBackground(new java.awt.Color(255, 255, 255));
        potTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        potTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                potTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(chipLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(betTenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chipDisplay)
                        .addComponent(betTwentyFiveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dealerPointsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dealerPointTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dealerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 240, Short.MAX_VALUE)
                        .addComponent(forfeitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(playerPointLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(playerPointTotal))
                                    .addComponent(standButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                .addGap(182, 182, 182))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dealerPointsLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(potTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addGap(181, 181, 181))))
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dealerPointsLabel))
                    .addComponent(dealerPointTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forfeitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dealerPointsLabel1))
                            .addComponent(potTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addComponent(hitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(standButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(playerPointLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(playerPointTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(betTenButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(chipLabel)
                                .addGap(40, 40, 40))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(betTwentyFiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(chipDisplay)))
                                .addContainerGap())))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chipDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chipDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chipDisplayActionPerformed

    private void betTenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betTenButtonActionPerformed
        if (play.hasEnoughChips(betTen)) {
            while (!betsMade) {
                pot += numberOfPlayers * betTen; // fairly sure you can't fold
                potTotal.setText(Integer.toString(pot));
                subtractChips(betTen);
                betsMade = true; // stop user from continually pressing the bet button
                done = drawInitialCards();
            }
            // if someone blackjacked, done is true
            if (done) {
                System.out.println("Done");
                betsMade = false;
                if (play.playerBlackJack) {
                    play.win();
                    addChips(Integer.parseInt(potTotal.getText()));
                } else {
                    play.loss();
                }
                clearEverything();
            }
        } else
            setChipCount(play.giveChips());
    }//GEN-LAST:event_betTenButtonActionPerformed

    private void betTwentyFiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betTwentyFiveButtonActionPerformed
        if (play.hasEnoughChips(betTwentyFive)) {   
            while (!betsMade) {
                pot += numberOfPlayers * betTwentyFive; // fairly sure you can't fold
                potTotal.setText(Integer.toString(pot));
                subtractChips(betTwentyFive);
                betsMade = true; // stop user from continually pressing the bet button
                done = drawInitialCards();
            }
            // if someone blackjacked, done is true
            if (done) {
                betsMade = false;
                if (play.playerBlackJack) {
                    play.win();
                    addChips(Integer.parseInt(potTotal.getText()));
                } else {
                    play.loss();
                }
                clearEverything();
            }
        } else {
            setChipCount(play.giveChips());
        }
    }//GEN-LAST:event_betTwentyFiveButtonActionPerformed

    private void playerPointTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerPointTotalActionPerformed

    }//GEN-LAST:event_playerPointTotalActionPerformed

    private void dealerPointTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealerPointTotalActionPerformed

    }//GEN-LAST:event_dealerPointTotalActionPerformed

    private void potTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_potTotalActionPerformed

    }//GEN-LAST:event_potTotalActionPerformed
        // TODO
        // clean up
        // get this into player // cleaned up a bit, decent
    private void hitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitButtonActionPerformed
        if (betsMade) { // stop player from pressing hit before betting
            playerInfoArea.setText(playerInfoArea.getText() + "\n" + 
                    play.getPlayerCard(newDeck));
            playerPointTotal.setText(play.getPlayerDeckValue());                

            if (Integer.parseInt(play.getPlayerDeckValue()) > 
                    PlayGame.blackJackNumber) {
                play.bust(); // player busted
                play.loss();
                clearEverything();
            } else if (Integer.parseInt(play.getPlayerDeckValue()) == 
                    PlayGame.blackJackNumber) {
                //blackJack(); // not sure if 21 always equals blackjack
                play.win();
                addChips(Integer.parseInt(potTotal.getText()));
                clearEverything();
            }
        }       
    }//GEN-LAST:event_hitButtonActionPerformed

    private void standButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standButtonActionPerformed
        if (betsMade) { // stop player from pressing stand before betting
            play.runAI(dealer, newDeck);
            dealerInfoArea.setText(play.NPCCardArray(dealer));
            dealerPointTotal.setText(play.getNPCDeckValue(dealer));
            
            if (Integer.parseInt(play.getNPCDeckValue(dealer)) > 
                    PlayGame.blackJackNumber) 
                JOptionPane.showMessageDialog(null, "Dealer busted");
            if (play.decideIfTie(Integer.parseInt(playerPointTotal.getText()), 
                    Integer.parseInt(dealerPointTotal.getText()))) {
                play.tie();
                addChips(Integer.parseInt(potTotal.getText()) / 2);
            } else if (play.decideWinOrLoss(Integer.parseInt(playerPointTotal.getText()), 
                    Integer.parseInt(dealerPointTotal.getText()))) {
                play.win();
                addChips(Integer.parseInt(potTotal.getText()));
            } else {
                play.loss();
            }
            clearEverything();
        }
    }//GEN-LAST:event_standButtonActionPerformed

    private void forfeitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forfeitButtonActionPerformed
        play.forfeit();
        setChipCount(Integer.parseInt(chipDisplay.getText()));
        play.finishedPlaying();
        MainMenuGUI main = new MainMenuGUI();
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_forfeitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new PlayGameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton betTenButton;
    private javax.swing.JButton betTwentyFiveButton;
    private javax.swing.JTextField chipDisplay;
    private javax.swing.JLabel chipLabel;
    private javax.swing.JTextArea dealerInfoArea;
    private javax.swing.JPanel dealerPanel;
    private javax.swing.JTextField dealerPointTotal;
    private javax.swing.JLabel dealerPointsLabel;
    private javax.swing.JLabel dealerPointsLabel1;
    private javax.swing.JButton forfeitButton;
    private javax.swing.JTextField generalInfoArea;
    private javax.swing.JButton hitButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea playerInfoArea;
    private javax.swing.JPanel playerPanel;
    private javax.swing.JLabel playerPointLabel;
    private javax.swing.JTextField playerPointTotal;
    private javax.swing.JTextField potTotal;
    private javax.swing.JButton standButton;
    // End of variables declaration//GEN-END:variables
}
