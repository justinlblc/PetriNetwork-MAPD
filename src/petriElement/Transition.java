package petriElement;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Transition.
 */
public class Transition {
	
	/** The name. */
	private  String name;
	
	/** The nb. */
	private static int nb;
	
	/** The list arc sortant. */
	private Vector<ArcSortant> listArcSortant = new Vector<ArcSortant>();
	
	/** The list arc entrant. */
	private Vector<ArcEntrant> listArcEntrant = new Vector<ArcEntrant>();
	
	/**
	 * Instantiates a new transition.
	 */
	public Transition() {
		this.name="T"+nb;
		nb++;
	}
	
	/**
	 * Gets the arc sortant.
	 *
	 * @param index the arc's position in list
	 * @return the arc sortant
	 */
	public ArcSortant getArcSortant(int index) {
		return listArcSortant.get(index);
	}
	
	
	/**
	 * Gets the arc entrant.
	 *
	 * @param index the arc's position in list
	 * @return the arc entrant
	 */
	public ArcEntrant getArcEntrant(int index) {
		return listArcEntrant.get(index);
	}
	
	
	/**
	 * Adds the arc sortant.
	 *
	 * @param as Arc Sortant to add
	 */
	public void addArcSortant(ArcSortant as) {
		this.listArcSortant.add(as);
	}
	
	/**
	 * Adds the arc entrant.
	 *
	 * @param ae Arc Entrant to add
	 */
	public void addArcEntrant(ArcEntrant ae) {
		this.listArcEntrant.add(ae);
	}
	
	/**
	 * The transition is fireable if all the ArcSortant which are linked to the current transition are passing.
	 *
	 * @return true, if successful
	 */
	public boolean fireable() {
		
		// The transition is fireable if all the ArcSortant edges are activated 
		if (this.listArcSortant.size()==0) {
			return true;
		}
		
		for (ArcSortant as:this.listArcSortant) {
			if (!(as.arcState())) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Fire the transition, and update tokens amoung the network
	 */
	public void fire() {
		for (ArcSortant as:this.listArcSortant) {
			as.substract();
		}
		for (ArcEntrant ae:this.listArcEntrant) {
			ae.add();
		}
		
	}
	
	/**
	 * Dell arc sortant.
	 *
	 * @param as the ArcSortant
	 * @return true, if successful
	 */
	public boolean  dellArcSortant(ArcSortant as) {
		return this.listArcSortant.remove(as);
	}
	
	/**
	 * Dell arc entrant.
	 *
	 * @param ae the ArcEntrant
	 * @return true, if successful
	 */
	public boolean  dellArcEntrant(ArcEntrant ae) {
		return this.listArcEntrant.remove(ae);
	}
	
	/**
	 * Reset name generator
	 */
	public static void reset() {
		nb = 0;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return name;
	}
}
