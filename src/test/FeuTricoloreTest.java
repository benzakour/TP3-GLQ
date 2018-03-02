package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import anneaux.Couleur;
import anneaux.FeuTricolore;

class FeuTricoloreTest {

	FeuTricolore fT;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		fT = new FeuTricolore(Couleur.VERT);
	}

	@Test
	void testChange() {
		assert fT.change() == Couleur.ORANGE;
		assert fT.change() == Couleur.ROUGE;
		assert fT.change() == Couleur.VERT;
		assert fT.change() == Couleur.ORANGE;
	}

}
