package DomaineVoiture;

/**
 * Created by flori on 15/03/2016.
 */
public class Route {
    private int debx;
    private int deby;
    private int finx;
    private int finy;


    public Route(int x, int y, int x2, int y2) {
        debx = x;
        deby = y;
        finx = x2;
        finy = y2;
    }

    public int getxDeb(){
        return debx;
    }
    public int getyDeb(){
        return deby;
    }
    public int getxFin(){
        return finx;
    }
    public int getyFin(){
        return finy;
    }
}
