package anneaux;

import java.util.LinkedList;

/**
 * <h1>AnneauListeChainee</h1>
 * <p>
 * Classe générique représentant un anneau avec une liste chainée. Hérite de la
 * classe abstraite AbstractAnneauListeChainee.
 * </p>
 *
 * @author Souha Benzakour et Denis Dimitrov
 * @param <E> le type générique de la classe.
 */
public class AnneauListeChainee<E> extends AbstractAnneauListeChainee<E> {

     /**
      * <h1>AnneauListeChainee</h1>
      * <p>
      * Constructeur AnneauListeChainee.
      * </p>
      *
      * @param anneau
      *            la liste contenant les éléments à insérer dans l'anneau.
      */
     public AnneauListeChainee(final LinkedList<E> anneau) {
          super(anneau);
     }

     /*
      * (non-Javadoc)
      *
      * @see anneaux.Anneau#insere(java.lang.Object)
      */
     @Override
     public void insere(final E element) {
          if (element != null) {
               anneau.add(element);
          }
     }
}
