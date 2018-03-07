/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import anneaux.FlaviusJosephe;

/**
 * <h1>FlaviusJosepheTest</h1>
 * <p>
 * Classe de test de la classe FlaviusJosephe.
 * </p>
 * 
 * @author Souha Benzakour.
 *
 */
public class FlaviusJosepheTest {

	FlaviusJosephe fJ1, fJ2;
	private OutputStream sortie; // flux de redirection de la sortie
	private PrintStream original; // flux de sortie initial

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(original);
	}

	/**
	 * Test de la methode
	 * {@link anneaux.FlaviusJosephe#FlaviusJosephe(java.lang.Integer, java.lang.Integer)}
	 * .
	 */
	@Test
	public void testFlaviusJosephe() {
		fJ1 = new FlaviusJosephe(8, 3);
		assertNotNull(fJ1);
	}

	/**
	 * Test de la methode {@link anneaux.FlaviusJosephe#flush()}.
	 */
	@Test
	public void testFlush() {
		/* Redirection du flux de sortie standard dans sortie */
		original = System.out;
		sortie = new ByteArrayOutputStream();
		System.setOut(new PrintStream(sortie));

		fJ1 = new FlaviusJosephe(8, 3);
		fJ1.flush();
		String s = sortie.toString();
		s = s.substring(s.indexOf("["), s.indexOf("]") + 1);
		assertEquals("[3, 6, 1, 5, 2, 0, 4, 7]", s);
	}

	/**
	 * Test de la methode {@link anneaux.FlaviusJosephe#flush()}.
	 */
	@Test
	public void testFlush2() {
		/* Redirection du flux de sortie standard dans sortie */
		original = System.out;
		sortie = new ByteArrayOutputStream();
		System.setOut(new PrintStream(sortie));

		fJ2 = new FlaviusJosephe(10, 2);
		fJ2.flush();
		String s = sortie.toString();
		s = s.substring(s.indexOf("["), s.indexOf("]") + 1);
		assertEquals("[2, 4, 6, 8, 0, 3, 7, 1, 9, 5]", s);
	}

}
