package Game;

public class TakePinsGame {
    public static void main(String[] args){
        Board b=new Board();
        b.setUp(10);
        HumanPlayer p=new HumanPlayer("kalle");
        ComputerPlayer c=new ComputerPlayer("datorN");
        
      
        c.takePins(b);
        System.out.print(b.getNoPins());
        
        p.takePins(b);
        System.out.print(b.getNoPins());

       }
        

    
    }
