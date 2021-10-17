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
	

	public void addArcSortant(ArcSortant as) {
		this.listArcSortant.add(as);
	}
	
	public void addArcEntrant(ArcEntrant ae) {
		this.listArcEntrant.add(ae);
	}
	
	public boolean fireable() {
		for (ArcSortant as:this.listArcSortant) {
			if (!(as.arcState())) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean fire() {
		if (!this.fireable()) {
			return false;
		}
		for (ArcSortant as:this.listArcSortant) {
			as.substract();
		}
		for (ArcEntrant ae:this.listArcEntrant) {
			ae.add();
		}
		return true;
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
