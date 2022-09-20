package Game;

public class Board {
    private int noPins;

    void setUp(int a) {
        noPins=a;
    }

    void takePins(int n) {
       noPins-=n;

    }

    int getNoPins() {
        return noPins;
    }

}