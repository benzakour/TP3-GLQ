package anneaux;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractAnneauListeChainee<E> implements Anneau<E> {

	private LinkedList<E> anneau;

	protected AbstractAnneauListeChainee(LinkedList<E> anneau) {
		// assert anneau != null;
		this.anneau = anneau;
	}

	// @Override
	// public void insere(E element) {
	// if (element != null) {
	// anneau.add(element);
	// }
	// }

	@Override
	public boolean supprime(E element) {
		return anneau.remove(element);
	}

	@Override
	public E suivant(E element) {
		try {
			return anneau.get(anneau.indexOf(element) + 1);
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public E suivant(E element, int pas) {
		try {
			return anneau.get(anneau.indexOf(element) + pas);
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean contient(E element) {
		try {
			return anneau.contains(element);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean estVide() {
		return anneau.isEmpty();
	}

	@Override
	public int taille() {
		return anneau.size();
	}

	@Override
	public List<Anneau<E>> coupeEnDeux() {

		List<Anneau<E>> liste = new ArrayList<Anneau<E>>();
		Anneau<E> a1 = new AnneauTrie<E>();
		Anneau<E> a2 = new AnneauTrie<E>();

		for (int i = 0; i < anneau.size(); i++) {
			if (i % 2 == 0) {
				a1.insere(anneau.get(i));
			} else {
				a2.insere(anneau.get(i));
			}
		}
		liste.add(a1);
		liste.add(a2);
		return liste;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public String toString() {
		return "AnneauListeChainee []";
	}

}
