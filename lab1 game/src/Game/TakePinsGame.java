package Game;

import javax.swing.JOptionPane;

public class TakePinsGame {
    public static void main(String[] args) {

        Board b = new Board();
        b.setUp(10);

        Player p = new HumanPlayer("Benne");
        Player c = new ComputerPlayer("datorN");
        Player c2 = new ComputerPlayer2("datorN2");

        while (b.getNoPins() > 0) {
            if (b.getNoPins() > 0) {
                p.takePins(b);
                if (b.getNoPins() == 0) {
                    JOptionPane.showMessageDialog(null, c2.getUserid() + " har vunnit!");
                    break;
                }

            }
            if(b.getNoPins()>0){
                c2.takePins(b);
                if(b.getNoPins()==0){
                    JOptionPane.showMessageDialog(null, p.getUserid() + " har vunnit!");
                    break;
                }
            }

        }

    }
}
