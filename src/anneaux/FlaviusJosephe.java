/**
 * 
 */
package anneaux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Utilisez la classe AnneauListeChainee pour écrire un programme qui simule le
 * problème de Flavius Josephe : étant donnés n soldats, placés en cercle aux
 * positions [0 ; n-1] avec 0 comme position de départ, il faut retirer chaque
 * p-ième soldat à gauche du soldat jusqu'à ce que tous les soldats soient
 * retirés, la position de départ à chaque tour est définie par le soldat à
 * droite du dernier retiré. Par exemple : • avec n = 8 et p = 3, les soldats
 * sont retirés dans l'ordre 3 6 1 5 2 0 4 7 • avec n = 10 et p = 2, ils sont
 * retirés dans l'ordre 2 4 6 8 0 3 7 1 9 5
 *
 */
public class FlaviusJosephe {

	protected Integer size, pas;

	public FlaviusJosephe(Integer size, Integer pas) {
		this.size = size;
		this.pas = pas;
	}

	public AnneauListeChainee<Integer> createList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		AnneauListeChainee<Integer> anneau = new AnneauListeChainee<>(list);
		return anneau;
	}
	
	public void flush() {
		// Liste à analyser
		AnneauListeChainee<Integer> listFlush = createList();
		
		// Liste résultat
		ArrayList<Integer> flushList = new ArrayList<Integer>();
		
		// Nombre de valeurs trouvées.
		Integer cpt = 0;
		
		// Position de départ à chaque début de boucle
		Integer index = 0;
		while(cpt < this.size) {
			// Position à analyser
			Integer idxToFlush = index;
			
			// Nombre de suivants non présents dans la liste résultat.
			Integer numOfSearches = 0;
			
			// Prochaine valeur à vérifier
			Integer valueFound;
			while(numOfSearches < this.pas) {
				// Allocation de la valeur à vérifier
				valueFound = listFlush.suivant(idxToFlush);
				
				// Vérification de la présence de la valeur
				// Si elle est déjà dans la liste, on prend le prochain suivant, et on n'augmente pas le nombre de
				// vérifications effectuées. Si elle n'est pas dedans, alors on continue.
				if(!flushList.contains(valueFound))
					numOfSearches++;
				
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

	/**
	 * <h1>main</h1>
	 * <p>
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

//		ArrayList<String> arr = new ArrayList<>();
//		arr.add("element1");
//		arr.add("element3");
//		arr.add("element2");
//		arr.add("element5");
//		arr.add("element6");
//		arr.add("element4");
//
//		System.out.println(arr);
//
//		Collections.sort(arr, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//
//				return o1.toString().compareTo(o2.toString());
//			}
//		});
//
//		System.out.println(arr);
//
//		System.out.println(5 / 2);
//		// souha 2

		FlaviusJosephe fJ1 = new FlaviusJosephe(8, 3);
		fJ1.flush();
		FlaviusJosephe fJ2 = new FlaviusJosephe(10, 2);
		fJ2.flush();
	}

}
