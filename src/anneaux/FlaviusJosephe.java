package anneaux;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <h1>FlaviusJosephe</h1>
 * <p>
 * Classe qui simule le problème de Flavius Josephe : étant donnés n soldats,
 * placés en cercle aux positions [0 ; n-1] avec 0 comme position de départ, il
 * faut retirer chaque p-ième soldat à gauche du soldat jusqu'à ce que tous les
 * soldats soient retirés, la position de départ à chaque tour est définie par
 * le soldat à droite du dernier retiré. Par exemple : • avec n = 8 et p = 3,
 * les soldats sont retirés dans l'ordre 3 6 1 5 2 0 4 7 • avec n = 10 et p = 2,
 * ils sont retirés dans l'ordre 2 4 6 8 0 3 7 1 9 5.
 * </p>
 * 
 * @author Souha Benzakour et Denis Dimitrov.
 *
 */
public class FlaviusJosephe {

	/** taille */
	private int size;
	/** pas de parcours */
	private int pas;

	/**
	 * <h1>FlaviusJosephe</h1>
	 * <p>
	 * Constructeur pour créer object FlaviusJosephe.
	 * </p>
	 * 
	 * @param size
	 *            taille.
	 * @param pas
	 *            pas de parcours.
	 */
	public FlaviusJosephe(Integer size, Integer pas) {
		this.size = size;
		this.pas = pas;
	}

	/**
	 * <h1>createList</h1>
	 * <p>
	 * Méthode pour création d'un anneau.
	 * </p>
	 * 
	 * @return anneau un AnneauListeChainee.
	 */
	public AnneauListeChainee<Integer> createList() {
		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(i);
		}

		AnneauListeChainee<Integer> anneau = new AnneauListeChainee<>(list);
		return anneau;
	}

	/**
	 * <h1>flush</h1>
	 * <p>
	 * Méthode fluch qui permet d'afficher un anneau d'élements en fonction du
	 * pas.
	 * </p>
	 */
	public void flush() {
		// Liste à analyser
		AnneauListeChainee<Integer> listFlush = createList();

		// Liste résultat
		ArrayList<Integer> flushList = new ArrayList<Integer>();

		// Nombre de valeurs trouvées.
		int cpt = 0;

		// Position de départ à chaque début de boucle
		int index = 0;
		while (cpt < this.size) {
			// Position à analyser
			int idxToFlush = index;

			// Nombre de suivants non présents dans la liste résultat.
			int numOfSearches = 0;

			// Prochaine valeur à vérifier
			int valueFound;

			while (numOfSearches < this.pas) {
				// Allocation de la valeur à vérifier
				valueFound = listFlush.suivant(idxToFlush);

				// Vérification de la présence de la valeur
				// Si elle est déjà dans la liste, on prend le prochain suivant,
				// et on n'augmente pas le nombre de
				// vérifications effectuées. Si elle n'est pas dedans, alors on
				// continue.
				if (!flushList.contains(valueFound)) {
					numOfSearches++;
				}
				// Mise à jour de la position.
				idxToFlush = valueFound;
			}
			// Ajout de la bonne position dans la liste résultat
			flushList.add(idxToFlush);

			// On stocke la valeur de départ pour le prochain tour de boucle.
			index = idxToFlush;

			// Nombre de valeurs trouvées + 1
			cpt++;
		}
		System.out.println(flushList);
	}
}
