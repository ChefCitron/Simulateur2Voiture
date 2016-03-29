package DomaineVoiture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestVoiture {
	
	private Voiture maVoiture;
	
	@Before
	public void setUp(){
		maVoiture = new Voiture (100, 50, 10);
	}
	
	@Test
	public void  testEvolutionXenFonctionVitesseSurUnTopSeconde() {
		
		maVoiture.miseAJourPosition();
		
		assertEquals(110, maVoiture.getX());
	}
	
	@Test
	public void testAcceleration(){
		
		maVoiture.accelerer();
		
		assertEquals(20, maVoiture.getVitesse());
	}


	@Test
	public void testAccelerationLimite() {
		
		maVoiture.setVitesse(100);
		maVoiture.accelerer();
		assertEquals(100, maVoiture.getVitesse());
		
	}

	@Test
	public void testChangementDeSens() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		assertEquals(180, maVoiture.getDirection());
		
	}
	
	@Test
	public void testChangementDeSensEtEvolutionDeX() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(90, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteHaute() {
		
		maVoiture.setVitesse(1000);
		maVoiture.miseAJourPosition();
		assertEquals(1000, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteBasse() {
		
		maVoiture.setVitesse(1000);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(0, maVoiture.getX());
		
	}
    @Test
    public void testTournerDroite() {
        assertEquals("L'angle doit être de 0 ",0,maVoiture.getDirection());
        maVoiture.tournerDroite();
        assertEquals("L'angle doit être de 90 ",90,maVoiture.getDirection());
        maVoiture.tournerDroite();
        assertEquals("L'angle doit être de 180 ",180,maVoiture.getDirection());
        maVoiture.tournerDroite();
        assertEquals("L'angle doit être de 270 ",270,maVoiture.getDirection());
        maVoiture.tournerDroite();
        assertEquals("L'angle doit être de 0 ",0,maVoiture.getDirection());

    }

    @Test
    public void testTournerGauche() {
        assertEquals("L'angle doit être de 0 ",0,maVoiture.getDirection());
        maVoiture.tournerGauche();
        assertEquals("L'angle doit être de 270 ",270,maVoiture.getDirection());
        maVoiture.tournerGauche();
        assertEquals("L'angle doit être de 180 ",180,maVoiture.getDirection());
        maVoiture.tournerGauche();
        assertEquals("L'angle doit être de 90 ",90,maVoiture.getDirection());
        maVoiture.tournerGauche();
        assertEquals("L'angle doit être de 0 ",0,maVoiture.getDirection());

    }

    @Test
    public void testDeplacementVerticalBas(){
        assertEquals("le Y doit être de 50",50,maVoiture.getY());
        maVoiture.miseAJourPosition();
        assertEquals("le Y doit être de 50",50,maVoiture.getY());
        maVoiture.tournerDroite();
        maVoiture.miseAJourPosition();
        assertEquals("le Y doit être de 60",60,maVoiture.getY());
    }

    @Test
    public void testDeplacementVerticalHaut(){
        assertEquals("le Y doit être de 50",50,maVoiture.getY());
        maVoiture.miseAJourPosition();
        assertEquals("le Y doit être de 50",50,maVoiture.getY());
        maVoiture.tournerGauche();
        maVoiture.miseAJourPosition();
        assertEquals("le Y doit être de 40",40,maVoiture.getY());
    }

}
