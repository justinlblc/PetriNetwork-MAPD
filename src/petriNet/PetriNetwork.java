package petriNet;

import petriElement.*;
import java.util.Vector;

public class PetriNetwork implements PetriNet {
	private Vector<ArcEntrant> listArcEntrant;
	private Vector<ArcSortant> listArcSortant;
	private Vector<Place> listPlace;
	private Vector<Transition> listTransition;
	
	public PetriNetwork() {
		listArcEntrant = new Vector<ArcEntrant>();
		listArcSortant = new Vector<ArcSortant>();
		listPlace = new Vector<Place>();
		listTransition = new Vector<Transition>();
	}
	@Override
	public void addTransition() {
		// TODO Auto-generated method stub
		this.listTransition.add(new Transition());
	}

	@Override
	public void addArcSortant(int weight, Place place, Transition transition) {
		// TODO Auto-generated method stub
		
		this.listArcSortant.add(new ArcSortant(weight,place,transition));
		transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
	}

	@Override
	public void addArcSortantZero(Place place, Transition transition) {
		// TODO Auto-generated method stub
		this.listArcSortant.add(new ArcZero(place,transition));
		transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
	}

	@Override
	public void addArcSortantVideur(Place place, Transition transition) {
		// TODO Auto-generated method stub
		this.listArcSortant.add(new ArcVideur(place,transition));
		transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
	}

	@Override
	public void addArcEntrant(int weight, Place place, Transition transition) {
		// TODO Auto-generated method stub
		this.listArcEntrant.add(new ArcEntrant(weight,place,transition));
		transition.addArcEntrant(this.listArcEntrant.get(this.listArcEntrant.size()-1));
	}

	@Override
	public void addPlace(int nbToken) {
		// TODO Auto-generated method stub
		this.listPlace.add(new Place(nbToken));

	}

	@Override
	public void deleteTransition(int index) {
		// TODO Auto-generated method stub
		Transition t = listTransition.get(index);
		listTransition.remove(index);
		for (ArcSortant as: listArcSortant) {
			if (as.getTransition()==t) {
				int j = listArcSortant.indexOf(as);
				this.deleteArcSortant(j);
			}
		}
		for (ArcEntrant as: listArcEntrant) {
			if (as.getTransition()==t) {
				int j = listArcEntrant.indexOf(as);
				this.deleteArcEntrant(j);
			}
		}
	}

	@Override
	public void deletePlace(int index) {
		// TODO Auto-generated method stub
		Place p = listPlace.get(index);
		listPlace.remove(index);
		for (ArcSortant as: listArcSortant) {
			if (as.getPlace()==p) {
				int j = listArcSortant.indexOf(as);
				this.deleteArcSortant(j);
			}
		}
		for (ArcEntrant as: listArcEntrant) {
			if (as.getPlace()==p) {
				int j = listArcEntrant.indexOf(as);
				this.deleteArcEntrant(j);
			}
		}
	}

	@Override
	public boolean deleteArcSortant(int index) {
		// TODO Auto-generated method stub
		ArcSortant as = this.listArcSortant.get(index);
		listArcSortant.remove(index);
		Transition t = as.getTransition();
		return t.dellArcSortant(as);
	}

	@Override
	public boolean deleteArcEntrant(int index) {
		// TODO Auto-generated method stub
		ArcEntrant ae = this.listArcEntrant.get(index);
		listArcEntrant.remove(index);
		Transition t = ae.getTransition();
		return t.dellArcEntrant(ae);
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		Vector<Transition> fireableTransition = new Vector<Transition>();
		for (Transition tran:this.listTransition) {
			if (tran.fireable()){
				fireableTransition.add(tran);
			}
		}
		
		int alea = (int) Math.random() * (fireableTransition.size());
		fireableTransition.get(alea).fire();
	}
	
	public static void main(String[] args) {
		
	}
		

}