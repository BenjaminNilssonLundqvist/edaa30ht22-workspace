package Game;

import java.util.Random;

import javax.swing.JOptionPane;

public class ComputerPlayer extends Player {

    ComputerPlayer(String userID) {
        super(userID);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int takePins(Board b) {
        Random r=new Random();
        if(b.getNoPins()==1){
            b.takePins(1);
            JOptionPane.showMessageDialog( null, "Datorn valde 1 pins");

        }else{
            int n=r.nextInt(2)+1;
            b.takePins(n);
                JOptionPane.showMessageDialog(null, "Datorn valde "+n+" Pins");
                JOptionPane.showMessageDialog(null, "Det finns "+ b.getNoPins()+" pins kvar");
            
        }
        return b.getNoPins();
    }
    
}
