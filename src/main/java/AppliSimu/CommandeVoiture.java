package applisimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domaineVoiture.Voiture;

/**
 * javadoc a venir.
 */
public class CommandeVoiture extends JPanel implements ActionListener {
	/**
	 * javadoc a venir.
	 */
	private JButton boutonAccelerer;
	/**
	 * javadoc a venir.
	 */
	private JButton boutonInverserDirection;
	/**
	 * javadoc a venir.
	 */
	private Voiture maVoiture;

	/**
	 * Constructeur.
	 * @param fenetre la fenetre d'affichage
	 * @param pmaVoiture la voiture
     */
	public CommandeVoiture(final JFrame fenetre, final Voiture pmaVoiture) {
		super();
		this.setLayout(new FlowLayout());
		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);
		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);
		fenetre.add(this);
		this.maVoiture = pmaVoiture;
	}

	/**
	 * Methode d'action.
	 * @param event l'evenement
     */
	public final void actionPerformed(final ActionEvent event) {
		Object bouton = event.getSource();
		if (bouton == boutonAccelerer) {
			maVoiture.accelerer();
		} else {
			maVoiture.inverserDirection();
		}
	}
}
