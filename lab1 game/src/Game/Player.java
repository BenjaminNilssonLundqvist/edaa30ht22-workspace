package Game;

public abstract class Player{
    protected String userID;
    
    Player(String userID){
        this.userID=userID;
    }

    public String getUserid(){
        return userID;
    }

    public abstract int takePins(Board b);

    

    
}
