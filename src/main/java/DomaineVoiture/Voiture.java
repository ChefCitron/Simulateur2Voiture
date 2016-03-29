package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

    private double paramatreConversionMetresPixels = 0.5;
	private int x;
	private int y;
	private int vitesseMetreSeconde;
	private int directionEnDegres;

	public Voiture(int x, int y, int vitesse) {
		this.x = x;
		this.y = y;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = 0;
	}

	public void miseAJourPosition() {
		miseAJourPositionX();
        miseAJourPositionY();
		notificationObservateur();
	}

	private void miseAJourPositionX() {
		if (directionEnDegres == 0) {
            x += vitesseMetreSeconde;
        }
		else if(directionEnDegres == 180) {
            x -= vitesseMetreSeconde;
        }
		if (x > 1000)
			x = 1000;
		else if (x < 0)
			x = 0;
	}
    private void miseAJourPositionY() {
        if(directionEnDegres == 90) {
            y += vitesseMetreSeconde;
        }
        if(directionEnDegres == 270) {
            y -= vitesseMetreSeconde;
        }
        if (y > 1000)
            y = 1000;
        else if (y < 0)
            y = 0;
    }
	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getX() {
		return x;
	}

	public void accelerer() {
		if (vitesseMetreSeconde < 100)
			vitesseMetreSeconde += 10;	
	}

	public Object getVitesse() {
		return vitesseMetreSeconde;
	}

	public void setVitesse(int vitesse) {
		vitesseMetreSeconde = vitesse;
	}

	public void setDirection(int angleDirection) {
		this.directionEnDegres = angleDirection;
		
	}

	public void inverserDirection() {
		directionEnDegres += 180 ;
		directionEnDegres = directionEnDegres % 360;
	}
    public int getY(){
        return y;
    }
	public Object getDirection() {
	return directionEnDegres;
	}

    public int calculerPositionPixels(int xMetres) {
        return (int) (paramatreConversionMetresPixels * xMetres);
    }
    public int calculerPositionYPixels(int yMetres) {
        return (int) (paramatreConversionMetresPixels * yMetres);
    }
    public void tournerDroite() {
        int angle = (this.directionEnDegres+270 )% 360;
        System.out.println(angle);
        this.setDirection(angle);
        notificationObservateur();
    }
    public void tournerGauche() {
        int angle = (this.directionEnDegres+90 )% 360;
        this.setDirection(angle);
        notificationObservateur();
    }

}
