/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Comparator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import anneaux.AnneauTrie;

/**
 * @author explorer
 *
 */
public class TestAnneauTrie {

	public static AnneauTrie<String> anneau1, anneau2;

	/**
	 * <h1>setUpBeforeClass</h1>
	 * <p>
	 * </p>
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		anneau1 = new AnneauTrie<>();
		anneau2 = new AnneauTrie<>();
	}

	/**
	 * <h1>setUp</h1>
	 * <p>
	 * </p>
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		anneau1 = new AnneauTrie<>();
		anneau2 = new AnneauTrie<>();
		anneau2.insere("element1");
		anneau2.insere("element2");
		anneau2.insere("element3");
		anneau2.insere("element4");
	}

	/**
	 * Teste la méthode de {@link anneaux.AnneauTrie#AnneauTrie()}.
	 */
	@Test
	public void testAnneauTrie() {
		AnneauTrie<String> anneau = new AnneauTrie<>();
		assertNotNull(anneau);
	}

	/**
	 * Teste la méthode de
	 * {@link anneaux.AnneauTrie#AnneauTrie(java.util.Comparator)}.
	 */
	@Test
	public void testAnneauTrieComparatorOfE() {
		AnneauTrie<String> anneau = new AnneauTrie<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		assertNotNull(anneau);
	}

	/**
	 * Teste la méthode de {@link anneaux.AnneauTrie#insere(java.lang.Object)}.
	 */
	@Test
	public void testInsere() {
		anneau1.insere("element1");
		assertEquals(1, anneau1.taille());
		anneau1.insere("element2");
		assertEquals(2, anneau1.taille());
	}

	/**
	 * Teste la méthode de {@link anneaux.AbstractAnneauListeChainee#hashCode()}
	 * .
	 */
	@Test
	public void testHashCode() {
		AnneauTrie<String> anneau3 = new AnneauTrie<>();
		assertEquals(1, anneau3.hashCode());
	}

	/**
	 * Teste la méthode de
	 * {@link anneaux.AbstractAnneauListeChainee#supprime(java.lang.Object)}.
	 */
	@Test
	public void testSupprime() {
		boolean test = anneau2.supprime("element2");
		assertEquals(true, test);
		test = anneau2.supprime("aucun");
		assertEquals(false, test);
	}

	/**
	 * Teste la méthode de
	 * {@link anneaux.AbstractAnneauListeChainee#suivant(java.lang.Object)}.
	 */
	@Test
	public void testSuivantE() {
		String suivant = anneau2.suivant("element2");
		assertEquals("element3", suivant);
	}

	/**
	 * Teste la méthode de
	 * {@link anneaux.AbstractAnneauListeChainee#suivant(java.lang.Object, int)}
	 * .
	 */
	@Test
	public void testSuivantEInt() {
		String suivant = anneau2.suivant("element4", 6);
		assertEquals("element2", suivant);
	}

	/**
	 * Teste la méthode de
	 * {@link anneaux.AbstractAnneauListeChainee#contient(java.lang.Object)}.
	 */
	@Test
	public void testContient() {
		assertEquals(true, anneau2.contient("element3"));
		assertEquals(false, anneau2.contient("#######"));
	}

	/**
	 * Teste la méthode de {@link anneaux.AbstractAnneauListeChainee#estVide()}.
	 */
	@Test
	public void testEstVide() {
		assertEquals(true, anneau1.estVide());
		assertEquals(false, anneau2.estVide());
	}

	/**
	 * Teste la méthode de {@link anneaux.AbstractAnneauListeChainee#taille()}.
	 */
	@Test
	public void testTaille() {
		assertEquals(4, anneau2.taille());
	}

	/**
	 * Teste la méthode de
	 * {@link anneaux.AbstractAnneauListeChainee#coupeEnDeux()}.
	 */
	@Test
	public void testCoupeEnDeux() {

	}

	/**
	 * Teste la méthode de
	 * {@link anneaux.AbstractAnneauListeChainee#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {

	}

	/**
	 * Teste la méthode de {@link anneaux.AbstractAnneauListeChainee#toString()}
	 * .
	 */
	@Test
	public void testToString() {

	}

}
