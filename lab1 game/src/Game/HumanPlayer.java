package Game;

import java.util.Scanner;

public class HumanPlayer extends Player {

    HumanPlayer(String userID) {
        super(userID);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int takePins(Board b) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        if(n==1|| n==2){
            b.takePins(n);
        }else{
            System.out.print("Din luriga jävel 1 eller två pinnar");
        }
        return b.getNoPins()-n;
    }

    
}
