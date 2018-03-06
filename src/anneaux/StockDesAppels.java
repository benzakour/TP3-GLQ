package anneaux;

import java.util.Comparator;

/**
 * <h1>StockDesAppels</h1>
 * <p>
 * Classe permettant de stocker des appels d'un ascenceur.
 * </p>
 *
 * @author Audrey Mommeja et Denis Dimitrov.
 *
 */
public class StockDesAppels {

    /** etages du batiment. */
    private AnneauTrie<Appel> etages;

    /**
     * <h1>StockDesAppels</h1>
     * <p>
     * Constructeur StockDesAppels.
     * </p>
     */
    public StockDesAppels() {
        etages = new AnneauTrie<Appel>();
    }

    /**
     * <h1>StockDesAppels</h1>
     * <p>
     * Constructeur surcharge StockDesAppels.
     * </p>
     *
     * @param anneau
     *            l'anneau trié des appels.
     */
    public StockDesAppels(final AnneauTrie<Appel> anneau) {
        super();
        etages = anneau;
    }

    /**
     * <h1>trierAppels</h1>
     * <p>
     * Méthode pour trier les appels avec des anneaux.
     * </p>
     *
     * @return l'anneau trié des appels.
     */
    public AnneauTrie<Appel> trierAppels() {

        AnneauTrie<Appel> montee = new AnneauTrie<Appel>(
                new Comparator<Appel>() {
            @Override
            public int compare(final Appel o1, final Appel o2) {
                return o1.getEtage().compareTo(o2.getEtage());
            }
        });

        AnneauTrie<Appel> descente = new AnneauTrie<Appel>(
                new Comparator<Appel>() {
            @Override
            public int compare(final Appel o1, final Appel o2) {
                return o2.getEtage().compareTo(o1.getEtage());
            }
        });

        AnneauTrie<Appel> etages2 = new AnneauTrie<Appel>();

        if (!etages.estVide()) {
            for (Appel appel : etages.getAnneau()) {
                if (appel.getSens().equals(Sens.MONTEE)) {
                    montee.insere(appel);
                } else {
                    descente.insere(appel);
                }
            }

            for (int i = 0; i < montee.taille(); i++) {
                etages2.insere(montee.getAnneau().get(i));
            }

            for (int i = 0; i < descente.taille(); i++) {
                etages2.insere(descente.getAnneau().get(i));
            }
        }
        return etages2;
    }
}
