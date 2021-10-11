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
		
		this.listArcSortant.add(new ArcSortant(weight,place));
		transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
	}

	@Override
	public void addArcSortantZero(Place place, Transition transition) {
		// TODO Auto-generated method stub
		this.listArcSortant.add(new ArcZero(place));
		transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
	}

	@Override
	public void addArcSortantVideur(Place place, Transition transition) {
		// TODO Auto-generated method stub
		this.listArcSortant.add(new ArcVideur(place));
		transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
	}

	@Override
	public void addArcEntrant(int weight, Place place, Transition transition) {
		// TODO Auto-generated method stub
		this.listArcEntrant.add(new ArcEntrant(weight,place));
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
		
	}

	@Override
	public void deletePlace(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArcSortant(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArcEntrant(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		Vector<Transition> L = new Vector<Transition>();
		for (Transition)
		

}
