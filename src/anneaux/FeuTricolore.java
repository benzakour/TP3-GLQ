package anneaux;

import java.util.LinkedList;

/**
 * <h1>FeuTricolore</h1>
 * <p>
 * Classe FeuTricolore munie d'une méthode change qui change la couleur du feu
 * en lui attribuant la couleur suivant la sienne dans la liste circulaire {
 * Couleur.VERT, Couleur.ORANGE, Couleur.ROUGE }.
 * </p>
 *
 * @author Souha Benzakour et Anthony Gumb.
 *
 */
public class FeuTricolore {

    /** Les couleurs du feu tricolore. */
    private Anneau<Couleur> feu;
    /** la couleur actuelle. */
    private Couleur actual;

    /**
     * <h1>FeuTricolore</h1>
     * <p>
     * Constructeur pour créer un feuTricolore
     * de 3 couleurs à partir de l'Enum
     * Couleur.
     * </p>
     *
     * @param startingColor
     *            la couleur du feu.
     */
    public FeuTricolore(final Couleur startingColor) {
        LinkedList<Couleur> colors = new LinkedList<Couleur>();
        colors.add(Couleur.VERT);
        colors.add(Couleur.ORANGE);
        colors.add(Couleur.ROUGE);
        feu = new AnneauListeChainee<Couleur>(colors);
        actual = startingColor;
    }

    /**
     * <h1>change</h1>
     * <p>
     * Méthode permettant de changer de couleur du feu.
     * </p>
     *
     * @return la nouvelle couleur.
     */
    public Couleur change() {
        actual = feu.suivant(actual);
        return actual;
    }
}
