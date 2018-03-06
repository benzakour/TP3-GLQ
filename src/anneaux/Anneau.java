package anneaux;

import java.util.List;

/**
 * <h1>Anneau</h1>
 * <p>
 * Un anneau ou liste circulaire est une liste linéaire dans laquelle le dernier
 * élément est suivi par le premier. Il n'y a donc ni premier ni dernier. Il
 * suffit de connaître la référence d'un élément pour parcourir les éléments de
 * l'anneau sans fin. Un anneau ne contient pas de valeur null, mais peut
 * contenir des doublons.
 * </p>
 *
 * @param <E> le type générique.
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
