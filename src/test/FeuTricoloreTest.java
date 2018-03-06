package test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import anneaux.Couleur;
import anneaux.FeuTricolore;

public class FeuTricoloreTest {

	private FeuTricolore fT;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fT = new FeuTricolore(Couleur.VERT);
	}

	@Test
	public void testChange() {
		assert fT.change() == Couleur.ORANGE;
		assert fT.change() == Couleur.ROUGE;
		assert fT.change() == Couleur.VERT;
		assert fT.change() == Couleur.ORANGE;
	}
}
