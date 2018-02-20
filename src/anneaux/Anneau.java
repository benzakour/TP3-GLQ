/**
 * 
 */
package anneaux;

import java.util.List;

/**
 * @author explorer
 *
 */
public interface Anneau<E> {
	void insere(E element);

	boolean supprime(E element);

	E suivant(E element);

	E suivant(E element, int pas);

	boolean contient(E element);

	boolean estVide();

	int taille();

	List<Anneau<E>> coupeEnDeux();
}
