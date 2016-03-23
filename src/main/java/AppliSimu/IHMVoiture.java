package applisimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import domaineVoiture.Route;

import domaineVoiture.Voiture;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * declaration classe.
 */
public class IHMVoiture extends JFrame implements Observer {
  /**
   * .
   */
	private static final double PARAMATRE_CONVERSION_METRES_PIXELS = 0.5;
  /**
   * .
   */
  private static final int WINDOW_SIZE = 505;
  /**
   * .
   */
  private static final int Y_RECT = 300;
  /**
   * .
   */
  private static final int LONG_RECT = 30;
  /**
   * .
   */
  private static final int LARG_RECT = 15;

  /**
   * .
   */
  private Voiture maVoiture;
  /**
   * .
   */
  private ArrayList<Route> mesRoutes;
  /**
   * .
   */
  private CommandeVoiture maCommandeVoiture;

  /**
   * .
   */
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(WINDOW_SIZE, WINDOW_SIZE);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);
		this.setVisible(true);
	}

  /**
   * .
   * @param pmaVoiture .
   * @param pmesRoutes .
   */
	public IHMVoiture(final Voiture pmaVoiture,
                    final ArrayList<Route> pmesRoutes) {
		super();
		this.mesRoutes = pmesRoutes;
		this.maVoiture = pmaVoiture;
		maVoiture.addObserver(this);
		initGraphique();
	}

  /**
   * .
   */
	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
		this.mesRoutes = null;
	}

  /**
   * @param xMetres .
   * @return .
   */
	public int calculerPositionPixels(final int xMetres) {
		return (int) (PARAMATRE_CONVERSION_METRES_PIXELS * xMetres);
	}

  /**
   * .
   * @param arg0
   * @param arg1
   */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	@Override
	public final void paint(final Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.LIGHT_GRAY);
		dessinerRoute(contexteGraphique);
		contexteGraphique.setColor(Color.RED);
		dessinerVoiture(contexteGraphique);
	}

  /**
   * @param contexteGraphique .
   */
	private void dessinerRoute(final Graphics contexteGraphique) {
		for (Route r : mesRoutes) {
			int xDeb = r.getxDeb();
			int yDeb = r.getyDeb();
			int longueur = r.getLongueur();
			int largeur = r.getLargeur();
			contexteGraphique.fillRect(xDeb, yDeb, longueur, largeur);
		}
	}

  /**
   * @param contexteGraphique .
   */
	private void dessinerVoiture(final Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
		contexteGraphique.fillRect(xPixel,
        Y_RECT, LONG_RECT, LARG_RECT);
	}
}
