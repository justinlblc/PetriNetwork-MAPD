package petriElement;
import java.util.Vector;

public class Transition {
	private  String name;
	private static int nb;
	private Vector<ArcSortant> listArcSortant = new Vector<ArcSortant>();
	private Vector<ArcEntrant> listArcEntrant = new Vector<ArcEntrant>();
	
	public Transition() {
		this.name="T"+nb;
		nb++;
	}
	
	public ArcSortant getArcSortant(int index) {
		return listArcSortant.get(index);
	}
	
	
	public ArcEntrant getArcEntrant(int index) {
		return listArcEntrant.get(index);
	}
	
	
	public void addArcSortant(ArcSortant as) {
		this.listArcSortant.add(as);
	}
	
	public void addArcEntrant(ArcEntrant ae) {
		this.listArcEntrant.add(ae);
	}
	
	public boolean fireable() {
		
		// The transition is fireable if all the ArcSortant edges are activated 
		for (ArcSortant as:this.listArcSortant) {
			if (!(as.arcState())) {
				return false;
			}
		}
		return true;
	}
	
	
	public void fire() {
		for (ArcSortant as:this.listArcSortant) {
			as.substract();
		}
		for (ArcEntrant ae:this.listArcEntrant) {
			ae.add();
		}
		
	}
	
	public boolean  dellArcSortant(ArcSortant as) {
		return this.listArcSortant.remove(as);
	}
	
	public boolean  dellArcEntrant(ArcEntrant ae) {
		return this.listArcEntrant.remove(ae);
	}
	
	public String toString() {
		return name;
	}
}
