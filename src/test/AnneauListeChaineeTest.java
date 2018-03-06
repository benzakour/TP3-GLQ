package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import anneaux.Anneau;
import anneaux.AnneauListeChainee;

/**
 * <h1>AnneauListeChaineeTest</h1>
 * <p>
 * Classe de test de AnneauListeChainee.
 * </p>
 * 
 * @author Souha Benzakour et Noemie Spina
 *
 */
public class AnneauListeChaineeTest {

	LinkedList<Integer> a1 = new LinkedList<Integer>();
	LinkedList<Integer> a2 = new LinkedList<Integer>();
	LinkedList<Integer> a3 = new LinkedList<Integer>();
	LinkedList<Integer> a4 = new LinkedList<Integer>();
	LinkedList<Integer> a5 = new LinkedList<Integer>();

	AnneauListeChainee<Integer> anneau1;
	AnneauListeChainee<Integer> anneau2;
	AnneauListeChainee<Integer> anneau3;
	AnneauListeChainee<Integer> anneau4;
	AnneauListeChainee<Integer> anneau5;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// pour anneau1
		a1.add(1);
		a1.add(6);
		a1.add(3);
		a1.add(2);
		// pour deuxième anneau
		a2.add(6);
		a2.add(3);
		a2.add(2);
		a2.add(1);
		// pour troisième anneau
		a3.add(2);
		a3.add(4);
		// pour quatrième anneau
		a4.add(1);
		a4.add(3);
		a4.add(6);
		a4.add(2);
		anneau1 = new AnneauListeChainee<Integer>(a1);
		anneau2 = new AnneauListeChainee<Integer>(a2);
		anneau3 = new AnneauListeChainee<Integer>(a3);
		anneau4 = new AnneauListeChainee<Integer>(a4);
		anneau5 = new AnneauListeChainee<Integer>(a5);

	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#insere(Object)}.
	 */
	@Test
	public void testInsere() {
		// anneau1
		anneau1.insere(4);
		assertEquals(new Integer(4), anneau1.getAnneau().getLast());
		// anneau2
		anneau2.insere(10);
		assertEquals(new Integer(10), anneau2.getAnneau().getLast());
		// anneau3
		anneau3.insere(1);
		assertEquals(new Integer(1), anneau3.getAnneau().getLast());
	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#supprime(Object)}.
	 */
	@Test
	public void testSupprime() {
		// anneau1
		int i = anneau1.getAnneau().size();
		anneau1.supprime(1);
		assertEquals(3, i - 1);
		// anneau3
		int j = anneau3.taille();
		anneau3.supprime(2);
		assertEquals(1, j - 1);
		// anneau4
		int k = anneau4.taille();
		anneau3.supprime(3);
		anneau3.supprime(1);
		assertEquals(2, k - 2);
	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#suivant(Object)}.
	 */
	@Test
	public void testSuivantE() {
		// anneau1
		int i = anneau1.suivant(3);
		assertEquals(2, i);
		// anneau2
		int j = anneau2.suivant(6);
		assertEquals(3, j);
	}

	/**
	 * Teste la methode de
	 * {@link anneaux.AnneauListeChainee#suivant(Object, int)}.
	 */
	@Test
	public void testSuivantEInt() {
		// anneau1
		int i = anneau1.suivant(1, 2);
		assertEquals(3, i);
		// anneau4
		int j = anneau4.suivant(1, 5);
		assertEquals(3, j);
	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#contient(Object)}.
	 */
	@Test
	public void testContient() {
		// anneau2
		assertTrue(anneau2.contient(1));
		assertFalse(anneau2.contient(50));
	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#estVide()}.
	 */
	@Test
	public void testEstVide() {
		assertFalse(anneau1.estVide());
		assertTrue(anneau5.estVide());
	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#taille()}.
	 */
	@Test
	public void testTaille() {
		// pour anneau1
		int i = anneau1.taille();
		assertEquals(4, i);
		// anneau4
		anneau4.insere(5);
		anneau4.insere(7);
		int j = anneau4.taille();
		assertEquals(6, j);
	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#coupeEnDeux())}.
	 */
	@Test
	public void testCoupeEnDeux() {
		List<Anneau<Integer>> list = anneau1.coupeEnDeux();
		assertTrue(list.get(0).contient(1));
		assertTrue(list.get(1).contient(6));
		assertTrue(list.get(0).contient(3));
		assertTrue(list.get(1).contient(2));
	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#equals(Object)}.
	 */
	@Test
	public void testEqualsObject() {
		assertFalse(anneau1.equals("ASD"));
		assertFalse(anneau1.equals(anneau4));
		assertTrue(anneau1.equals(anneau2));
		assertFalse(anneau1.equals(anneau3));
		anneau4.insere(11);
		anneau4.supprime(1);
		assertFalse(anneau1.equals(anneau4));
	}

	/**
	 * Teste la methode de {@link anneaux.AnneauListeChainee#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		assertEquals(136, anneau1.hashCode());
	}
}
