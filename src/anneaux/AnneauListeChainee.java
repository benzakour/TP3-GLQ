package anneaux;

import java.util.LinkedList;

public class AnneauListeChainee<E> extends AbstractAnneauListeChainee<E> {

	public AnneauListeChainee(LinkedList<E> anneau) {
		super(anneau);
	}

	@Override
	public void insere(E element) {
		if (element != null) {
			anneau.add(element);
	  }
	}

}
