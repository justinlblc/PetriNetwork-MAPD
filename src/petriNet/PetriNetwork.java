package petriNet;

import petriElement.*;
import java.util.Vector;

import Error.NegParException;
import Error.NullException;

// TODO: Auto-generated Javadoc
/**
 * The Class PetriNetwork.
 */
public class PetriNetwork implements PetriNet {
	
	/** The list arc entrant. */
	private Vector<ArcEntrant> listArcEntrant;
	
	/** The list arc sortant. */
	private Vector<ArcSortant> listArcSortant;
	
	/** The list place. */
	private Vector<Place> listPlace;
	
	/** The list transition. */
	private Vector<Transition> listTransition;
	
	/**
	 * Instantiates a new petri network.
	 */
	public PetriNetwork() {
		listArcEntrant = new Vector<ArcEntrant>();
		listArcSortant = new Vector<ArcSortant>();
		listPlace = new Vector<Place>();
		listTransition = new Vector<Transition>();
	}
	
	
	/**
	 * Gets the number arc entrant.
	 *
	 * @return the nb arc entrant
	 */
	@Override
	
	public int getNbArcEntrant() {
		return this.listArcEntrant.size();
	}
	
	/**
	 * Gets the nb arc sortant.
	 *
	 * @return the nb arc sortant
	 */
	public int getNbArcSortant() {
		return this.listArcSortant.size();
	}
	
	/**
	 * Gets the nb place.
	 *
	 * @return the nb place
	 */
	public int getNbPlace() {
		return this.listPlace.size();
	}
	
	/**
	 * Gets the nb transition.
	 *
	 * @return the nb transition
	 */
	public int getNbTransition() {
		return this.listTransition.size();
	}
	
	
	/**
	 * Adds the transition.
	 */
	public void addTransition() {
		// TODO Auto-generated method stub
		this.listTransition.add(new Transition());
	}

	/**
	 * Adds the arc sortant.
	 *
	 * @param weight the weight
	 * @param place the place
	 * @param transition the transition
	 */
	@Override
	public void addArcSortant(int weight, Place place, Transition transition) {
		// TODO Auto-generated method stub
		try {
			ArcSortant as = new ArcSortant(weight,place,transition);
			int index= this.existingArcSortant(as);
			if (index != -1) {
				ArcSortant eas=this.listArcSortant.get(index);
				transition.dellArcSortant(eas);
				this.replaceArcSortant(as, index);
			} else {
				this.listArcSortant.add(as);
			}
			transition.addArcSortant(as);
			
				
				
			
		}catch (NullException e) {
			System.out.println("NullException : "+e.getMessage());
		}catch (NegParException e) {
			System.out.println("NegParException : "+e.getMessage());
		}
	}
	
	/**
	 * Adds the arc sortant zero.
	 *
	 * @param place the place
	 * @param transition the transition
	 */
	@Override
	public void addArcSortantZero(Place place, Transition transition) {
		// TODO Auto-generated method stub
		try {
			ArcSortant as = new ArcZero(place,transition);
			int index= this.existingArcSortant(as);
			if (index != -1) {
				ArcSortant eas=this.listArcSortant.get(index);
				transition.dellArcSortant(eas);
				this.replaceArcSortant(as, index);
			} else {
				this.listArcSortant.add(as);
			}
			transition.addArcSortant(as);
		} catch (Exception e) {
			System.out.println("NullException : "+e.getMessage());
		}
	}

	/**
	 * Adds the arc sortant videur.
	 *
	 * @param place the place
	 * @param transition the transition
	 */
	@Override
	public void addArcSortantVideur(Place place, Transition transition) {
		// TODO Auto-generated method stub
		try {
			ArcSortant as = new ArcVideur(place,transition);
			int index= this.existingArcSortant(as);
			if (index != -1) {
				ArcSortant eas=this.listArcSortant.get(index);
				transition.dellArcSortant(eas);
				this.replaceArcSortant(as, index);
			} else {
				this.listArcSortant.add(as);
			}
			transition.addArcSortant(as);
		} catch (Exception e) {
			System.out.println("NullException : "+e.getMessage());
		}
		
	}

	/**
	 * Adds the arc entrant.
	 *
	 * @param weight the weight
	 * @param place the place
	 * @param transition the transition
	 */
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

	/**
	 * Adds the place.
	 *
	 * @param nbToken the nb token
	 */
	@Override
	public void addPlace(int nbToken)  {
		// TODO Auto-generated method stub
		try{
			this.listPlace.add(new Place(nbToken));
		} catch (Exception e) {
			System.out.println("NbTokenNegException :"+e.getMessage());
		}

	}
	
	/**
	 * Sets the place token.
	 *
	 * @param p the p
	 * @param n the n
	 */
	public void setPlaceToken(Place p, int n) {
		try {
			p.setNbToken(n);
		} catch(Exception e) {
			System.out.println("Error"+ e.getMessage());
		}
	}
	
	
	/**
	 * Sets the arc sortant weight.
	 *
	 * @param as the as
	 * @param w the w
	 */
	public void setArcSortantWeight(ArcSortant as, int w) {
		try {
			as.setWeight(w);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	
	/**
	 * Sets the arc entrant weight.
	 *
	 * @param ae the ae
	 * @param w the w
	 */
	public void setArcEntrantWeight(ArcEntrant ae, int w) {
		try {
			ae.setWeight(w);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		
	}
	
	
	
	/**
	 * Existing arc sortant.
	 *
	 * @param as_test the as test
	 * @return the int
	 */
	public int existingArcSortant(ArcSortant as_test) {
		for (int index = 0 ; index < this.listArcSortant.size() ; index++ ) {
			if (this.listArcSortant.get(index).equals(as_test)) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	 * Replace arc sortant.
	 *
	 * @param as the as
	 * @param index the index
	 */
	public void replaceArcSortant(ArcSortant as,int index) {
		try {
			this.listArcSortant.setElementAt(as, index);
		}
		catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	/**
	 * Delete transition.
	 *
	 * @param index the index
	 */
	@Override
	public void deleteTransition(int index) {
		// TODO Auto-generated method stub
		// To delete a transition, we need to remove it from the list of transition...
		
		// ... but we also need to remove all the edges (ArcSortant or ArcEntrant) which are linked to this transition
		Transition t = listTransition.get(index);
		
		for (int i = 0; i<listArcSortant.size(); i++){
			ArcSortant as = listArcSortant.get(i);
			if (as.getTransition()==t) {
				int j = listArcSortant.indexOf(as);
				this.deleteArcSortant(j);
			}
		}
		for (int i = 0; i<listArcEntrant.size(); i++){
			ArcEntrant as = listArcEntrant.get(i);
			if (as.getTransition()==t) {
				int j = listArcEntrant.indexOf(as);
				this.deleteArcEntrant(j);
			}
		}
		listTransition.remove(index);
	}

	/**
	 * Delete place.
	 *
	 * @param index the index
	 */
	@Override
	public void deletePlace(int index) {
		// TODO Auto-generated method stub
		
		// Same process as a transition
		Place p = listPlace.get(index);
		listPlace.remove(index);
		for (int i = 0; i<listArcSortant.size(); i++){
			ArcSortant as = listArcSortant.get(i);
			if (as.getPlace()==p) {
				int j = listArcSortant.indexOf(as);
				this.deleteArcSortant(j);
			}
		}
		for (int i = 0; i<listArcEntrant.size(); i++){
			ArcEntrant as = listArcEntrant.get(i);
			if (as.getPlace()==p) {
				int j = listArcEntrant.indexOf(as);
				this.deleteArcEntrant(j);
			}
		}
	}

	/**
	 * Delete arc sortant.
	 *
	 * @param index the index
	 * @return true, if successful
	 */
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

	/**
	 * Delete arc entrant.
	 *
	 * @param index the index
	 * @return true, if successful
	 */
	@Override
	public boolean deleteArcEntrant(int index) {
		// TODO Auto-generated method stub
		
		// Same process as deleteArcSortant()
		ArcEntrant ae = this.listArcEntrant.get(index);
		listArcEntrant.remove(index);
		Transition t = ae.getTransition();
		return t.dellArcEntrant(ae);
	}
	
	
	/**
	 * Fire.
	 */
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
	
		
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String msg="";
		msg=msg+"List of place :\n";
		for (Place p:listPlace) {
			msg=msg+p.toString()+"\n";
		}
		msg=msg+"\n"+"List of transition : \n";
		for (Transition t:listTransition) {
			msg=msg+t.toString()+"\n";
		}
		msg=msg+"\n";
		for (ArcSortant as:this.listArcSortant) {
			msg=msg+as.toString()+"\n";
		}
		for (ArcEntrant ae:this.listArcEntrant) {
			msg=msg+ae.toString()+"\n";
		}
		return msg;
		
	}
	
	/**
	 * Gets the arc entrant.
	 *
	 * @param index the index
	 * @return the arc entrant
	 */
	@Override
	public ArcEntrant getArcEntrant(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >=listArcEntrant.size() ) {
			System.out.println("Exception : Index out of range");
			return null;
		}
		return listArcEntrant.get(index);
	}
	
	/**
	 * Gets the arc sortant.
	 *
	 * @param index the index
	 * @return the arc sortant
	 */
	@Override
	public ArcSortant getArcSortant(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >=listArcSortant.size() ) {
			System.out.println("Exception : Index out of range");
			return null;
		}
		return listArcSortant.get(index);
	}
	
	/**
	 * Gets the place.
	 *
	 * @param index the index
	 * @return the place
	 */
	@Override
	public Place getPlace(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >=listPlace.size() ) {
			System.out.println("Exception : Index out of range");
			return null;
		}
		return listPlace.get(index);
	}
	
	/**
	 * Gets the transition.
	 *
	 * @param index the index
	 * @return the transition
	 */
	@Override
	public Transition getTransition(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >=listTransition.size() ) {
			System.out.println("Exception : Index out of range");
			return null;
		}
		return listTransition.get(index);
	}
	
	/**
	 * Gets the list transition.
	 *
	 * @return the list transition
	 */
	//Uniquement pour tester les getteur: getTransition(), getPlace() ...
	public Vector<Transition> getListTransition(){
		return this.listTransition;
	}
	
	/**
	 * Gets the list arc entrant.
	 *
	 * @return the list arc entrant
	 */
	public Vector<ArcEntrant> getListArcEntrant(){
		return this.listArcEntrant;
	}
	
	/**
	 * Gets the list arc sortant.
	 *
	 * @return the list arc sortant
	 */
	public Vector<ArcSortant> getListArcSortant(){
		return this.listArcSortant;
	}
	
	/**
	 * Gets the list place.
	 *
	 * @return the list place
	 */
	public Vector<Place> getListPlace(){
		return this.listPlace;
	}

}
