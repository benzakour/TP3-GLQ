package anneaux;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractAnneauListeChainee<E> implements Anneau<E> {

	protected LinkedList<E> anneau;

	protected AbstractAnneauListeChainee() {
		this.anneau = new LinkedList<E>();
	}

	@Override
	public boolean supprime(E element) {
		return anneau.remove(element);
	}

	@Override
	public E suivant(E element) {
		return this.suivant(element, 1);
	}

	@Override
	public E suivant(E element, int pas) {
		int index = 0;

		try {
			// on récupère l'index de l'élement
			// si l'élément n'existe pas index sera égal à -1
			index = anneau.indexOf(element);

			// si l'élément n'existe pas (donc si index est égal à -1)
			// on retourne null
			if (index < 0) {
				return null;
			}

			// on tente de prendre l'élément suivant
			return anneau.get(index + pas);
		} catch (IndexOutOfBoundsException e) {
			// si il n'existe pas d'élément suivant c'est qu'on est déjà au
			// dernier élément. Dans ce cas on applique la formule :
			// (index + pas) % taille = résultat
			return anneau.get(((index + pas) % anneau.size()));
		} catch (NullPointerException e) {
			// si l'élément passé en argument est null on retourne null
			return null;
		}
	}

	@Override
	public boolean contient(E element) {
		try {
			return anneau.contains(element);
		} catch (NullPointerException e) {
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
		return anneau.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		// TODO
		return false;
	}

	@Override
	public String toString() {
		return "AnneauListeChainee " + anneau.toString();
	}
}
