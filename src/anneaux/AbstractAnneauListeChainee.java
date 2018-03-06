package anneaux;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractAnneauListeChainee<E> implements Anneau<E> {

	protected LinkedList<E> anneau;

	public LinkedList<E> getAnneau() {
		return anneau;
	}

	protected AbstractAnneauListeChainee(LinkedList<E> anneau) {
		// assert anneau != null;
		this.anneau = anneau;
	}

	public AbstractAnneauListeChainee() {
		this.anneau = new LinkedList<E>();
	}

	@Override
	public boolean supprime(E element) {
		return anneau.remove(element);
	}

	@Override
	public E suivant(E element) {
		try {
			if (anneau.indexOf(element) + 1 >= anneau.size())
				return anneau.get(0);
			else
				return anneau.get(anneau.indexOf(element) + 1);
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public E suivant(E element, int pas) {
		try {
			if (anneau.indexOf(element) != 0)
				pas += anneau.indexOf(element);
			if (anneau.indexOf(element) + pas >= anneau.size()) {
				pas = pas % anneau.size();
				return anneau.get(pas);
			} else
				return anneau.get(0 + pas);
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
		return Objects.hash(anneau);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof AbstractAnneauListeChainee) {
			AbstractAnneauListeChainee<E> listToCheck = (AbstractAnneauListeChainee<E>) o;
			if(listToCheck.getAnneau().size() != this.getAnneau().size()) {
				return false;
			}
			if(!listToCheck.contient(this.getAnneau().get(0))) {
				return false;
			}
			Integer positionFirstElement = listToCheck.getAnneau().indexOf(this.getAnneau().get(0));
			Boolean res = true;
			for(int i = 1; i<this.getAnneau().size(); i++) {
				E toBeEquals = this.getAnneau().get(i);
				E toMatch = listToCheck.suivant(listToCheck.getAnneau().get(positionFirstElement), i);
				if(!toMatch.equals(toBeEquals)) {
					res = false;
				}
			}
			return res;
		}
		return false;
	}

	/*
	@Override
	public String toString() {
		String s = "[";
		for(E e : this.getAnneau()) {
			s+=e.toString()+",";
		}
		s = s.substring(0, s.length()-1);
		s+="]";
		return s;
	}*/

}
