package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import anneaux.AnneauListeChainee;


class AnneauListeChaineeTest {
	LinkedList<Integer> a1= new LinkedList<Integer>();
	LinkedList<Integer> a2= new LinkedList<Integer>();
	LinkedList<Integer> a3= new LinkedList<Integer>();
	LinkedList<Integer> a4= new LinkedList<Integer>();
	LinkedList<Integer> a5= new LinkedList<Integer>();
	
	AnneauListeChainee<Integer> anneau1; 
	AnneauListeChainee<Integer> anneau2; 
	AnneauListeChainee<Integer> anneau3;
	AnneauListeChainee<Integer> anneau4;
	AnneauListeChainee<Integer> anneau5;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
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

	@Test
	void testInsere() {
		//anneau1
		anneau1.insere(4);
		assertEquals(new Integer(4), anneau1.getAnneau().getLast());
		//anneau2
		anneau2.insere(10);
		assertEquals(new Integer(10), anneau2.getAnneau().getLast());
		//anneau3 
		anneau3.insere(1);
		assertEquals(new Integer(1), anneau3.getAnneau().getLast());
	}

	@Test
	void testSupprime() {
		//anneau1 
		int i = anneau1.getAnneau().size();
		anneau1.supprime(1); 
		assertEquals(3, i-1);	
		//anneau3
		int j = anneau3.taille(); 
		anneau3.supprime(2);
		assertEquals(1, j-1);
		//anneau4
		int k = anneau4.taille(); 
		anneau3.supprime(3);
		anneau3.supprime(1);
		assertEquals(2, k-2);
	}

	@Test
	void testSuivantE() {
		//anneau1
		int i = anneau1.suivant(3); 
		assertEquals(2, i);
		//anneau2
		int j = anneau2.suivant(6); 
		assertEquals(3, j);
	}

	@Test
	void testSuivantEInt() {
		//anneau1 
		int i = anneau1.suivant(1, 2); 
		assertEquals(3, i);
		//anneau4 
		int j = anneau4.suivant(1, 5); 
		assertEquals(3, j);
	}

	@Test
	void testContient() {
		//anneau2 
		assertTrue(anneau2.contient(1)); 
		assertFalse(anneau2.contient(50));
	}

	@Test
	void testEstVide() {
		assertFalse(anneau1.estVide());
		assertTrue(anneau5.estVide());
	}

	@Test
	void testTaille() {
		// pour anneau1
		int i = anneau1.taille(); 
		assertEquals(4,i);
		//anneau4 
		anneau4.insere(5);
		anneau4.insere(7);
		int j = anneau4.taille(); 
		assertEquals(6, j);
	}

	@Test
	void testCoupeEnDeux() {
		
		//System.out.println(anneau1.coupeEnDeux());
	}

	@Test
	void testEqualsObject() {
		assertFalse(anneau1.equals("ASD"));
		assertFalse(anneau1.equals(anneau4));
		assertTrue(anneau1.equals(anneau2));
		assertFalse(anneau1.equals(anneau3));
		anneau4.insere(11);
		anneau4.supprime(1);
		assertFalse(anneau1.equals(anneau4));
	}
}
