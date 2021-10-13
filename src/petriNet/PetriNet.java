package petriNet;
import petriElement.*;

public interface PetriNet {
	
	// Ajoute une transition au réseau
	public void addTransition();
	
	// Ajoute une Place au réseau
	public void addPlace(int nbToken);
	
	// Ajoute un arc normal d'une Place vers une Transition
	public void addArcSortant(int weight, Place place, Transition transition);
	
	
	// Ajoute un arc Zero d'une Place vers une Transition 
	public void addArcSortantZero(Place place, Transition transition);
	
	// Ajoute un arc Videur d'une Place vers une Transition
	public void addArcSortantVideur(Place place, Transition transition);
	
	// Ajoute un arc d'une Transition vers une Place
	public void addArcEntrant(int weight, Place place, Transition transition);
	
	// Supprime la Transition se trouvant à la position index de la liste des Transitions
	public void deleteTransition(int index);
	
	// Supprime la Place se trouvant à la position index
	public void deletePlace(int index);
	
	// Supprime l'Arc Sortant se trouvant à la position index de la liste des ArcSortants
	public boolean deleteArcSortant(int index);
	
	// Supprime l'ARrcEntrant se trouvant à la position index de la liste des ArcEntrants
	public boolean deleteArcEntrant(int index);
	
	// Tire une transition tirable de façon aléatoire 
	public void fire();

	
	
}
