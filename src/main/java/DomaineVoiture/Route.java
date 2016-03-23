package domaineVoiture;

/**
 * Created by flori on 15/03/2016.
 */
public class Route {

    private int debx;
    private int deby;
    private int longueur;
    private int largeur;

    public Route(int _x, int _y, int _longueur, int _largeur) {
        debx = _x;
        deby = _y;
        this.longueur = _longueur;
        largeur = _largeur;
    }

    public int getxDeb(){
        return debx;
    }
    public int getyDeb(){
        return deby;
    }
    public int getLongueur(){
        return longueur;
    }
    public int getLargeur() { return largeur; }
}
