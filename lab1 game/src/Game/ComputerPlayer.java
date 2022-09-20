package Game;

import java.util.Random;

public class ComputerPlayer extends Player {

    ComputerPlayer(String userID) {
        super(userID);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int takePins(Board b) {
        Random r=new Random();
       int a=r.nextInt(2) + 1;
       b.takePins(a);
       return b.getNoPins()-a;
    }
    
}
