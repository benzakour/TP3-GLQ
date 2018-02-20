package anneaux;



import java.util.LinkedList;
import java.util.List;

public abstract class AbstractAnneauListeChainee implements Anneau {

	public LinkedList<Object> l = new LinkedList<>(); 
	Object element; 
	
	public AbstractAnneauListeChainee(LinkedList<Object> l) {
		assert(l != null); 
		this.l = l;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	@Override
	public void insere(Object element) {		
		if (element != null) {
			l.add(element); 
			assert(l.contains(element)); 
		} 
		
	}

	@Override
	public boolean supprime(Object element) {
		if (element != null) {
			l.remove(element);
			assert(!l.contains(element));
			return true;
		}else 
		return false;
	}

	@Override
	public Object suivant(Object element) {
		if(element != null) {
			return false; 
		}
		return null;
	}

	@Override
	public Object suivant(Object element, int pas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contient(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estVide() {
		if(l.size() == 0) {
			return true; 
		} else 
			return false; 
	}

	@Override
	public int taille() {
		int i = l.size();
		return  i ; 
	}

	@Override
	public List coupeEnDeux() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int hashCode() {
		return 0;	
	}

	@Override
	public boolean equals(Object o) {
		return false;	
	}

	@Override
	public String toString() {
		return "AnneauListeChainee []";
	}

}
