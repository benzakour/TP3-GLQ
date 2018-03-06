package anneaux;

/**
 * <h1>Appel</h1>
 * <p>
 * Classe des appels.
 * </p>
 *
 * @author Audrey Mommeja et Denis Dimitrov.
 */
public class Appel implements Comparable<Appel> {

    /** etage du batiment. */
    private Integer etage;
    /** sens de la montée ou de la descente. */
    private Sens sens;

    /**
     * <h1>Appel</h1>
     * <p>
     * Constructeur Appel.
     * </p>
     */
    public Appel() {
        etage = 0;
        sens = Sens.MONTEE;
    }

    /**
     * <h1>Appel</h1>
     * <p>
     * Constructeur Appel.
     * </p>
     *
     * @param etageP
     *            l'étage de l'ascenceur.
     * @param sensP
     *            la direction du deplacement.
     */
    public Appel(final int etageP, final Sens sensP) {
        this.etage = etageP;
        this.sens = sensP;
    }

    /**
     * <h1>getEtage</h1>
     * <p>
     * Retourne l'etage.
     * </p>
     *
     * @return l'etage.
     */
    public Integer getEtage() {
        return etage;
    }

    /**
     * <h1>setEtage</h1>
     * <p>
     * Set l'etage.
     * </p>
     *
     * @param etageP
     *            le nouvel etage.
     */
    public void setEtage(final int etageP) {
        this.etage = etageP;
    }

    /**
     * <h1>getSens</h1>
     * <p>
     * Retourne le sens.
     * </p>
     *
     * @return le sens.
     */
    public Sens getSens() {
        return sens;
    }

    /**
     * <h1>setSens</h1>
     * <p>
     * Set le sens.
     * </p>
     *
     * @param sensP
     *            le nouveau sens.
     */
    public void setSens(final Sens sensP) {
        this.sens = sensP;
    }

    /**
     * <h1>toString</h1>
     * <p>
     * Retourne la representation textuelle de l'appel.
     * </p>
     *
     * @return une chaine de caracteres representant l'appel.
     */
    public String toString() {
        if (sens == Sens.MONTEE) {
            return etage + "^";
        }
        return etage + "v";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Appel appel) {
        return this.compareTo(appel);
    }
}
