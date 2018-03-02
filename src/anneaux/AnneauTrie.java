/**
 * 
 */
package anneaux;

import java.util.Comparator;

/**
 * AnneauTrie qui représente les anneaux dont les éléments sont insérés dans
 * l'ordre naturel ou dans l'ordre donné par un comparateur.
 * 
 * @author explorer
 * @param <T>
 *
 */
public class AnneauTrie<E> extends AbstractAnneauListeChainee<E>{

	/**
	 * <h1>AnneauTrie.java</h1><br>
	 * <p>
	 * Constructeur sans parametres.
	 * </p>
	 */
	public AnneauTrie() {
		super();
	}

	/**
	 * <h1>AnneauTrie.java</h1>
	 * <p>
	 * Constructeur surchargé. Utilisez- vous Comparable/Comparator<? super E>
	 * ou Comparable/Comparator <E> ?
	 * </p>
	 */
	public AnneauTrie(Comparator<E> comparator) {
		super();
	}

	/* (non-Javadoc)
	 * @see anneaux.Anneau#insere(java.lang.Object)
	 */
	@Override
	public void insere(E element) {
		anneau.add(element);		
	}
}
