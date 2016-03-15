package AppliSimu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import DomaineVoiture.Route;

import javax.swing.*;

import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private ArrayList<Route> mesRoutes;
	private CommandeVoiture maCommandeVoiture;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture, ArrayList<Route> mesRoutes) {
		super();
		this.mesRoutes = mesRoutes;
		this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
		this.mesRoutes = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	//@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.LIGHT_GRAY);
		dessinerRoute(contexteGraphique);
		contexteGraphique.setColor(Color.RED);
		dessinerVoiture(contexteGraphique);
	}

	private void dessinerRoute(Graphics contexteGraphique){
		for(Route r : mesRoutes){
		int xDeb = r.getxDeb();
		int yDeb = r.getyDeb();
		int xFin = r.getxFin();
		int yFin = r.getyFin();
		contexteGraphique.fillRect(xDeb,yDeb,xFin-xDeb,50);}
		//contexteGraphique.fillRect(0,275,500,50);
	}
	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
		contexteGraphique.fillRect(xPixel, 300, 30, 15);
	}
	
}
