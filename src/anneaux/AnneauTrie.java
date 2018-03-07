package anneaux;

import java.util.Collections;
import java.util.Comparator;

/**
 * <h1>AnneauTrie</h1>
 * <p>
 * AnneauTrie qui représente les anneaux dont les éléments sont insérés dans
 * l'ordre naturel ou dans l'ordre donné par un comparateur.
 * </p>
 *
 * @author Anthony Gumb et Audrey Mommeja.
 *
 * @param <E>
 */
public class AnneauTrie<E> extends AbstractAnneauListeChainee<E> {

    /** Comparateur de l'anneau trié. */
    private Comparator<E> comparator;

    /**
     * <h1>AnneauTrie.java</h1>
     * <p>
     * Constructeur sans parametres.
     * </p>
     */
    public AnneauTrie() {
        super();
        this.comparator = null;
    }

    /**
     * <h1>AnneauTrie</h1>
     * <p>
     * Constructeur AnneauTrie.
     * </p>
     *
     * @param comparatorP
     *            le comparator qui permettra de trier l'anneau.
     */
    public AnneauTrie(final Comparator<E> comparatorP) {
        super();
        this.comparator = comparatorP;
    }

    /*
     * (non-Javadoc)
     *
     * @see anneaux.Anneau#insere(java.lang.Object)
     */
    @Override
    public void insere(final E element) {
        anneau.add(element);
        if (comparator != null) {
            Collections.sort(anneau, comparator);
        }
    }
}
