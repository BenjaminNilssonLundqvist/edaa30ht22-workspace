package Game;

import javax.swing.JOptionPane;

public class ComputerPlayer2 extends Player {

    public ComputerPlayer2(String userId) {
        super(userId);
    }

    public int takePins(Board b) {
        int amount = 2;
         if (b.getNoPins()>= 5) {
            b.takePins(amount);
            JOptionPane.showMessageDialog(null, "Datorn valde " + amount + " pins");
            JOptionPane.showMessageDialog(null, "Det finns " + b.getNoPins() + " pins kvar");
        } else {
            amount = 1;
            b.takePins(amount);
            JOptionPane.showMessageDialog(null, "Datorn valde " + amount + " pins");
            JOptionPane.showMessageDialog(null, "Det finns " + b.getNoPins() + " pins kvar");
        }
        return amount;
    }

}