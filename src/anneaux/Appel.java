package anneaux;

/**
 * 
 * @author denis & audrey
 *
 */
public class Appel implements Comparable<Appel> {
	
	private Integer etage;
	private Sens sens;
	
	/**
	 * <h1>Appel</h1>
	 * <p>Constructeur pour créer un object appel</p>
	 */
	public Appel() {
		etage = 0;
		sens = Sens.MONTEE;
	}
	/**
	 * <h1>Appel</h1>
	 * <p>Constructeur pour créer un object appel</p>
	 */
	public Appel(Integer etage, Sens sens) {
		this.etage = etage;
		this.sens = sens;
	}
	
	public Integer getEtage() {
		return etage;
	}

	public void setEtage(Integer etage) {
		this.etage = etage;
	}

	public Sens getSens() {
		return sens;
	}

	public void setSens(Sens sens) {
		this.sens = sens;
	}

	public String toString() {
		if (sens == Sens.MONTEE) {
			return etage + "^";
		}
		return etage + "v";
	}

	@Override
	public int compareTo(Appel appel) {
		return this.compareTo(appel);
	}
}
