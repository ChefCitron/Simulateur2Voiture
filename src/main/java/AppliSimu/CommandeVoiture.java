package AppliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class CommandeVoiture extends JPanel implements ActionListener{
	
	private JButton boutonAccelerer;
    private JButton boutonTournerGauche;
    private JButton boutonTournerDroite;
	private JButton boutonInverserDirection;
	private Voiture maVoiture;
	
	
	public CommandeVoiture (JFrame fenetre, Voiture maVoiture) {
		
		super();
		this.setLayout(new FlowLayout());
 
		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);
        boutonTournerDroite = new JButton("Droite");
        boutonTournerDroite.addActionListener(this);
        this.add(boutonTournerDroite);
        boutonTournerGauche = new JButton("Gauche");
        boutonTournerGauche.addActionListener(this);
        this.add(boutonTournerGauche);
		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);
		
		fenetre.add(this);
		this.maVoiture = maVoiture;
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		Object bouton = event.getSource();
		if (bouton == boutonAccelerer)
			maVoiture.accelerer();
        else if (bouton == boutonTournerDroite) {
            maVoiture.tournerDroite();
        }
        else if (bouton == boutonTournerGauche) {
            maVoiture.tournerGauche();
        }
		else
			maVoiture.inverserDirection();
	}
	

}
