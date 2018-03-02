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
 */
public class FeuTricolore {

	protected Anneau<Couleur> feu;
	protected Couleur actual;

	public FeuTricolore(Couleur startingColor) {
		LinkedList<Couleur> colors = new LinkedList<Couleur>();
		colors.add(Couleur.VERT);
		colors.add(Couleur.ORANGE);
		colors.add(Couleur.ROUGE);
		feu = new AnneauListeChainee<Couleur>(colors);
		actual = startingColor;
	}

	public Couleur change() {
		actual = feu.suivant(actual);
		return actual;
	}
	
	public static void main(String[] args) {
		FeuTricolore ft = new FeuTricolore(Couleur.ROUGE);
		for(int i = 0; i<6; i++) {
			ft.change();
		}
	}

}
