package AppliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import DomaineVoiture.Route;
import DomaineVoiture.Voiture;

public class ProtoSimu {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;

	public static void main(String[] args) {
		ArrayList<Route> mesRoutes = new ArrayList<Route>();
		Route maRoute = new Route(0,275,500,100);
		//changer route2 Route maRoute2 = new Route(100,200,200,0);
		mesRoutes.add(maRoute);
		//mesRoutes.add(maRoute2);
		final Voiture maVoiture = new Voiture (100, 0, 10);
		IHMVoiture monTriangle = new IHMVoiture(maVoiture,mesRoutes);
		
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			//@Override
			public void actionPerformed(ActionEvent arg0) {
				maVoiture.miseAJourPosition();
			}
		});
		
		timerAvancer.start();
		
		while(true){
		}

	}

}
