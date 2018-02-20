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
public class AnneauTrie<T> {

	/**
	 * <h1>AnneauTrie.java</h1><br>
	 * <p>
	 * Constructeur sans parametres.
	 * </p>
	 */
	public AnneauTrie() {
		
	}

	/**
	 * <h1>AnneauTrie.java</h1>
	 * <p>
	 * Constructeur surchargé. Utilisez- vous Comparable/Comparator<? super E>
	 * ou Comparable/Comparator <E> ?
	 * </p>
	 */
	public AnneauTrie(Comparator<T> comparator) {
		assert comparator != null;
	}
}
