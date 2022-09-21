package Game;

import java.util.Scanner;
import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class HumanPlayer extends Player {

    HumanPlayer(String userID) {
        super(userID);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int takePins(Board b) {
        int n=0;
        if(b.getNoPins()==1){
            b.takePins(1);
            JOptionPane.showMessageDialog(null, "Du tog 1 pin");
        } else{
            while(!(n==1 || n==2)){
                JOptionPane.showMessageDialog(null, "Du måste välja 1 eller 2 pins");
                n=UserInterface.askForInt(JOptionPane.showInputDialog("Hur många pins vill du ta?"));
                }
            }
            b.takePins(n);
            JOptionPane.showMessageDialog(null, "Du tog " + n + " pins");
            JOptionPane.showMessageDialog(null, "Det finns " + b.getNoPins() + " pins kvar");
            return b.getNoPins();

        }
        
    } 

    

