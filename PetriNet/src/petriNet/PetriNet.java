package petriNet;
import petriElement.*;

public interface PetriNet {
	
	public void addTransition();
	
	public void addArcSortant(int weight, Place place, Transition transition);
	
	public void addArcSortantZero(Place place, Transition transition);
	
	public void addArcSortantVideur(Place place, Transition transition);
	
	public void addArcEntrant(int weight, Place place, Transition transition);
	
	public void addPlace(int nbToken);
	
	public void deleteTransition(int index);
	
	public void deletePlace(int index);
	
	public void deleteArcSortant(int index);
	
	public void deleteArcEntrant(int index);
	
	public void fire();
	
}
