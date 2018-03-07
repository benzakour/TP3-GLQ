package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import anneaux.Couleur;
import anneaux.FeuTricolore;

/**
 * <h1>FeuTricoloreTest</h1>
 * <p>
 * Classe de test de FeuTricolore.
 * </p>
 * 
 * @author Souha Benzakour et Anthony Gumb.
 *
 */
public class FeuTricoloreTest {

	private FeuTricolore fT;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fT = new FeuTricolore(Couleur.VERT);
	}

	/**
	 * Teste la methode de {@link anneaux.FeuTricolore#change()}.
	 */
	@Test
	public void testChange() {
		assertEquals(fT.change(), Couleur.ORANGE);
		assertEquals(fT.change(), Couleur.ROUGE);
		assertEquals(fT.change(), Couleur.VERT);
		assertEquals(fT.change(), Couleur.ORANGE);
	}
}
