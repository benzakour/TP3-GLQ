package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import anneaux.AnneauTrie;
import anneaux.Appel;
import anneaux.Sens;
import anneaux.StockDesAppels;

/**
 * <h1>StockDesAppelsTest</h1>
 * <p>
 * Classe de test de StockDesAppels.
 * </p>
 * 
 * @author Audrey Mommeja et Denis Dimitrov.
 *
 */
public class StockDesAppelsTest {

	AnneauTrie<Appel> anneau1 = new AnneauTrie<Appel>();
	AnneauTrie<Appel> anneau2 = new AnneauTrie<Appel>();
	AnneauTrie<Appel> anneau3 = new AnneauTrie<Appel>();

	@BeforeClass
	static public void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		anneau1.insere(new Appel(6, Sens.MONTEE));
		anneau1.insere(new Appel(2, Sens.DESCENTE));
		anneau1.insere(new Appel(3, Sens.DESCENTE));
		anneau1.insere(new Appel(1, Sens.MONTEE));
		anneau1.insere(new Appel(5, Sens.DESCENTE));

		anneau2.insere(new Appel(5, Sens.MONTEE));
		anneau2.insere(new Appel(10, Sens.MONTEE));
		anneau2.insere(new Appel(1, Sens.DESCENTE));
		anneau2.insere(new Appel(7, Sens.DESCENTE));
		anneau2.insere(new Appel(7, Sens.MONTEE));
	}

	/**
	 * Teste la methode de {@link anneaux.StockDesAppels#trierAppels()}.
	 */
	@Test
	public void testTrierAppels() {
		StockDesAppels appels = new StockDesAppels(anneau1);
		anneau3 = appels.trierAppels();
		assertEquals(anneau3.toString(), "[1^,6^,5v,3v,2v]");

		StockDesAppels appels2 = new StockDesAppels(anneau2);
		anneau3 = appels2.trierAppels();
		assertEquals(anneau3.toString(), "[5^,7^,10^,7v,1v]");
	}
}