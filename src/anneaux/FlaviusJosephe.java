/**
 * 
 */
package anneaux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

	/**
	 * <h1>main</h1>
	 * <p>
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> arr = new ArrayList<>();
		arr.add("element1");
		arr.add("element3");
		arr.add("element2");
		arr.add("element5");
		arr.add("element6");
		arr.add("element4");
		
		System.out.println(arr);
		
		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.toString().compareTo(o2.toString());
			}
		});
		
		System.out.println(arr);
		
		System.out.println(5/ 2);

	}

}
