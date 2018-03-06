package anneaux;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * <h1>AbstractAnneauListeChainee</h1>
 * <p>
 * Classe abstraite implémentant l'interface Anneau.
 * </p>
 *
 * @author Audrey Mommeja, Noémie Spina, Anthony Gumb, Denis Dimitrov et Souha
 *         Benzakour.
 *
 * @param <E>
 *            le type générique.
 */
public abstract class AbstractAnneauListeChainee<E> implements Anneau<E> {

    /**
     * Liste chainée de l'anneau. En théorie cette
     * variable devrait etre private et avoir des
     * Accesseurs et des Mutateur mais dans ce cas
     * précis il nous a semblé plus simple de
     * mettre la variable en protected.
     */
    protected LinkedList<E> anneau;

    /**
     * <h1>AbstractAnneauListeChainee</h1>
     * <p>
     * Constructeur AbstractAnneauListeChainee.
     * </p>
     */
    public AbstractAnneauListeChainee() {
        this.anneau = new LinkedList<E>();
    }

    /**
     * <h1>AbstractAnneauListeChainee</h1>
     * <p>
     * Constructeur AbstractAnneauListeChainee.
     * </p>
     *
     * @param anneauP
     *            la liste d'éléments à insérer dans l'anneau.
     */
    protected AbstractAnneauListeChainee(final LinkedList<E> anneauP) {
        this.anneau = anneauP;
    }

    /*
     * (non-Javadoc)
     *
     * @see anneaux.Anneau#supprime(java.lang.Object)
     */
    @Override
    public boolean supprime(final E element) {
        return anneau.remove(element);
    }

    /*
     * (non-Javadoc)
     *
     * @see anneaux.Anneau#suivant(java.lang.Object)
     */
    @Override
    public E suivant(final E element) {
        return this.suivant(element, 1);
    }

    /*
     * (non-Javadoc)
     *
     * @see anneaux.Anneau#suivant(java.lang.Object, int)
     */
    @Override
    public E suivant(final E element, final int pas) {
        int index = 0;

        try {
            // on récupère l'index de l'élement
            // si l'élément n'existe pas index sera égal à -1
            index = anneau.indexOf(element);

            // si l'élément n'existe pas
            // (donc si index est égal à -1)
            // on retourne null
            if (index < 0) {
                return null;
            }

            // on tente de prendre l'élément suivant
            return anneau.get(index + pas);
        } catch (IndexOutOfBoundsException e) {
            // si il n'existe pas d'élément
            // suivant c'est qu'on est déjà au
            // dernier élément. Dans ce cas on
            // applique la formule :
            // (index + pas) % taille = résultat
            return anneau.get(((index + pas) % anneau.size()));
        } catch (NullPointerException e) {
            // si l'élément passé en argument
            // est null on retourne null
            return null;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see anneaux.Anneau#contient(java.lang.Object)
     */
    @Override
    public boolean contient(final E element) {
        try {
            return anneau.contains(element);
        } catch (NullPointerException e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see anneaux.Anneau#estVide()
     */
    @Override
    public boolean estVide() {
        return anneau.isEmpty();
    }

    /*
     * (non-Javadoc)
     *
     * @see anneaux.Anneau#taille()
     */
    @Override
    public int taille() {
        return anneau.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see anneaux.Anneau#coupeEnDeux()
     */
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
    	int tmp = 0;
    	for (E e : anneau) {
			tmp += Objects.hash(e);
		}
        return tmp;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
	public boolean equals(final AbstractAnneauListeChainee<E> o) {
		if (o == null || !(o instanceof AbstractAnneauListeChainee)
				|| (o.getAnneau().size()
						!= this.getAnneau().size())
				|| (!o.contient(this.getAnneau().get(0)))) {
			return false;
		}
		int positionFirstElement = o.getAnneau().indexOf(
				this.getAnneau().get(0));
		boolean res = true;

		for (int i = 1; i < this.getAnneau().size(); i++) {
			E toBeEquals = this.getAnneau().get(i);
			E toMatch = o.suivant(o.getAnneau().get(
					positionFirstElement), i);
			if (!toMatch.equals(toBeEquals)) {
				res = false;
			}
		}
		return res;
	}

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String s = "[";
        for (E e : this.getAnneau()) {
            s += e.toString() + ",";
        }
        s = s.substring(0, s.length() - 1);
        s += "]";
        return s;
    }

    /**
     * <h1>getAnneau</h1>
     * <p>
     * Getter de l'anneau.
     * </p>
     *
     * @return la liste de cet anneau.
     */
    public LinkedList<E> getAnneau() {
        return anneau;
    }
}
