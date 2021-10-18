package petriNet;

import petriElement.*;
import java.util.Vector;

import Error.NegParException;
import Error.NullException;

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
		try {
			this.listArcSortant.add(new ArcSortant(weight,place,transition));
			transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
		}catch (NullException e) {
			System.out.println("NullException : "+e.getMessage());
		}catch (NegParException e) {
			System.out.println("NegParException : "+e.getMessage());
		}
	}
	
	@Override
	public void addArcSortantZero(Place place, Transition transition) {
		// TODO Auto-generated method stub
		try {
			this.listArcSortant.add(new ArcZero(place,transition));
			transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
		} catch (Exception e) {
			System.out.println("NullException : "+e.getMessage());
		}
	}

	@Override
	public void addArcSortantVideur(Place place, Transition transition) {
		// TODO Auto-generated method stub
		try {
			this.listArcSortant.add(new ArcVideur(place,transition));
			transition.addArcSortant(this.listArcSortant.get(this.listArcSortant.size()-1));
		} catch (Exception e) {
			System.out.println("NullException : "+e.getMessage());
		}
		
	}

	@Override
	public void addArcEntrant(int weight, Place place, Transition transition) {
		// TODO Auto-generated method stub
		try {
			this.listArcEntrant.add(new ArcEntrant(weight,place,transition));
			transition.addArcEntrant(this.listArcEntrant.get(this.listArcEntrant.size()-1));
		} catch (NullException e) {
			System.out.println("NullException : "+e.getMessage());
		} catch (NegParException e) {
			System.out.println("NegParException : "+e.getMessage());
		}
	}

	@Override
	public void addPlace(int nbToken)  {
		// TODO Auto-generated method stub
		try{
			this.listPlace.add(new Place(nbToken));
		} catch (Exception e) {
			System.out.println("NbTokenNegException :"+e.getMessage());
		}

	}

	@Override
	public void deleteTransition(int index) {
		// TODO Auto-generated method stub
		// To delete a transition, we need to remove it from the list of transition...
		Transition t = listTransition.get(index);
		listTransition.remove(index);
		
		// ... but we also need to remove all the edges (ArcSortant or ArcEntrant) which are linked to this transition 
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
		
		// Same process as a transition
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
		
		// To delete an edge, we just need to remove it from the list of edges (listArcSortant or listArcEntrant) 
		// and we also need to remove it from the transition linked to.
		ArcSortant as = this.listArcSortant.get(index);
		listArcSortant.remove(index);
		Transition t = as.getTransition();
		return t.dellArcSortant(as);
	}

	@Override
	public boolean deleteArcEntrant(int index) {
		// TODO Auto-generated method stub
		
		// Same process as deleteArcSortant()
		ArcEntrant ae = this.listArcEntrant.get(index);
		listArcEntrant.remove(index);
		Transition t = ae.getTransition();
		return t.dellArcEntrant(ae);
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		
		// First of all, we create a new list of fireable transition by calling fireable() for each transition of the network
		Vector<Transition> fireableTransition = new Vector<Transition>();
		for (Transition tran:this.listTransition) {
			if (tran.fireable()){
				fireableTransition.add(tran);
			}
		}
		
		// Then a random transition is chosen from the this new list
		int alea = (int) Math.random() * (fireableTransition.size());
		fireableTransition.get(alea).fire();
		
		if (fireableTransition.size()==0) System.out.println("No fireable transition");
	}
	
		
	public String toString() {
		String msg="";
		for (ArcSortant as:this.listArcSortant) {
			msg=msg+as.toString()+"/n";
		}
		for (ArcEntrant ae:this.listArcEntrant) {
			msg=msg+ae.toString()+"/n";
		}
		return msg;
		
	}
	@Override
	public ArcEntrant getArcEntrant(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >=listArcEntrant.size() ) {
			System.out.println("Exception : Index out of range");
			return null;
		}
		return listArcEntrant.get(index);
	}
	@Override
	public ArcSortant getArcSortant(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >=listArcSortant.size() ) {
			System.out.println("Exception : Index out of range");
			return null;
		}
		return listArcSortant.get(index);
	}
	@Override
	public Place getPlace(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >=listPlace.size() ) {
			System.out.println("Exception : Index out of range");
			return null;
		}
		return listPlace.get(index);
	}
	@Override
	public Transition getTransition(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >=listTransition.size() ) {
			System.out.println("Exception : Index out of range");
			return null;
		}
		return listTransition.get(index);
	}

}
