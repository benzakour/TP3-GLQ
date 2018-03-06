/**
 * 
 */
package anneaux;

import java.util.LinkedList;

/**
 * Ecrivez une classe FeuTricolore munie d'une méthode change qui change la
 * couleur du feu en lui attribuant la couleur suivant la sienne dans la liste
 * circulaire { Couleur.VERT, Couleur.ORANGE, Couleur.ROUGE }. Ecrivez un test
 * automatique pour la classe FeuTricolore.
 * 
 * @author benzakour & anthony
 * 
 */
public class FeuTricolore {

	protected Anneau<Couleur> feu;
	protected Couleur actual;

	/**
	 * <h1>FeuTricolore</h1>
	 * <p>Constructeur pour créer un feuTricolore de 3 couleurs à partir de l'Enum Couleur</p>
	 * @param startingColor
	 */
	public FeuTricolore(Couleur startingColor) {
		LinkedList<Couleur> colors = new LinkedList<Couleur>();
		colors.add(Couleur.VERT);
		colors.add(Couleur.ORANGE);
		colors.add(Couleur.ROUGE);
		feu = new AnneauListeChainee<Couleur>(colors);
		actual = startingColor;
	}
	/**
	 * <h1>change</h1>
	 * <p>Méthode change qui permet de changer de couleur simultanément
	 *  en choisissant de quel couleur commencer </p>
	 * @return
	 */
	public Couleur change() {
		actual = feu.suivant(actual);
		return actual;
	}
	
	/**
	 * <h1>main</h1>
	 * <p></p>
	 * @param args
	 */
	public static void main(String[] args) {
		FeuTricolore ft = new FeuTricolore(Couleur.ROUGE);
		for(int i = 0; i<6; i++) {
			ft.change();
		}
	}

}
