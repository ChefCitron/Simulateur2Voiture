package domaineVoiture;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by flori on 23/03/2016.
 */
public class TestRoute {

    @Test
    public void testGetxDeb() throws Exception {
        Route r = new Route(0,0,0,0);

        assertEquals("La position x de route doit être 0",0,r.getxDeb());

        Route r2 = new Route(1000,0,0,0);

        assertEquals("La position x de route doit être 1000",1000,r2.getxDeb());

    }

    @Test
    public void testGetyDeb() throws Exception {
        Route r = new Route(0,0,0,0);

        assertEquals("La position y de route doit être 0",0,r.getyDeb());

        Route r2 = new Route(0,1000,0,0);

        assertEquals("La position y de route doit être 1000",1000,r2.getyDeb());
    }

    @Test
    public void testGetLongueur() throws Exception {

        Route r = new Route(0,0,0,0);

        assertEquals("La longueur de route doit être de 0",0,r.getLongueur());

        Route r2 = new Route(0,0,1000,0);

        assertEquals("La longueur de route doit être 1000",1000,r2.getLongueur());
    }

    @Test
    public void testGetLargeur() throws Exception {

        Route r = new Route(0,0,0,0);

        assertEquals("La largeur de route doit être de 0",0,r.getLargeur());

        Route r2 = new Route(0,0,0,1000);

        assertEquals("La largeur de route doit être 1000",1000,r2.getLargeur());
    }
}