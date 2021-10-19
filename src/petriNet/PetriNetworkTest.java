package petriNet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Error.NegParException;
import Error.NullException;
import petriElement.ArcEntrant;
import petriElement.ArcSortant;
import petriElement.ArcVideur;
import petriElement.ArcZero;
import petriElement.Place;
import petriElement.Transition;

class PetriNetworkTest {
	
	private static PetriNetwork pn;
	
	@Test
	@BeforeEach
	void setUp() {
		Place.reset();
		Transition.reset();
		pn = new PetriNetwork();
	}
	
	@Test
	void testGetNbArcEntrant() {
		assertEquals(pn.getNbArcEntrant(), 0);
	}
	
	@Test
	void testGetNbArcSortant() {
		assertEquals(pn.getNbArcSortant(), 0);
	}
	
	@Test
	void testGetNbPlace() {
		assertEquals(pn.getNbPlace(), 0);
	}
	
	@Test
	void testGetNbTransition() {
		assertEquals(pn.getNbTransition(), 0);
	}
	@Test
	void testAddTransition() {
		pn.addTransition();
		assertEquals(pn.getNbTransition(), 1);
	}

	@Test
	void testAddArcSortant() throws NegParException, NullException {
		
		Transition t3 = new Transition();
		Place p2 = new Place(2);
		pn.addArcSortant(1,p2,t3);
		pn.addArcSortant(2, p2, t3);
		
		assertEquals(pn.getArcSortant(0).getWeight(),2);
		
		
		Place p3 = new Place(3);
		ArcSortant as2 = new ArcSortant(2, p3, t3);
		int index2 = pn.existingArcSortant(as2);
		
		assertEquals(index2,-1);
		
		Transition t = new Transition();
		Place p = new Place(0);
		pn.addArcSortant(1, p, t);
		assertEquals(pn.getNbArcSortant(), 2);
		
		Transition t1 = new Transition();
		pn.addArcSortant(-1,p,t1);
		
		Place p1 = null;
		pn.addArcSortant(1,p1,t);
		
		Transition t2 = null;
		pn.addArcSortant(1,p,t2);
		
	}

	@Test
	void testAddArcSortantZero() throws NegParException, NullException {
		
		Transition t = new Transition();
		Place p = new Place(2);
		pn.addArcSortantZero(p,t);
		pn.setArcSortantWeight(pn.getListArcSortant().get(0), 3);
		pn.addArcSortantZero(p,t);
		assertEquals(pn.getArcSortant(0).getWeight(),0);
		
		
		Place p2 = new Place(3);
		ArcSortant as2 = new ArcZero(p2, t);
		int index = pn.existingArcSortant(as2);
		
		assertEquals(index,-1);
		
		
		Transition t1 = new Transition();
		//Place p = new Place(1);
		Place p3 = new Place(0);
		pn.addArcSortantZero(p3, t1);
		assertEquals(pn.getNbArcSortant(),2);
		
		Place p4 = null;
		Transition t4 = null;
		pn.addArcSortantZero(p4, t1);
		pn.addArcSortantZero(p3, t4);
	}

	@Test
	void testAddArcSortantVideur() throws NegParException, NullException {
		
		Transition t = new Transition();
		Place p = new Place(2);
		pn.addArcSortantVideur(p,t);
		pn.setArcSortantWeight(pn.getListArcSortant().get(0), 3);
		pn.addArcSortantVideur(p,t);
		assertEquals(pn.getArcSortant(0).getWeight(),0);
		
		
		Place p1 = new Place(3);
		ArcSortant as2 = new ArcVideur(p1, t);
		int index = pn.existingArcSortant(as2);
		
		assertEquals(index,-1);
		
		Transition t1 = new Transition();
		Place p2 = new Place(0);
		pn.addArcSortantVideur(p2, t1);
		assertEquals(pn.getNbArcSortant(),2);
		
		Place p3 = null;
		Transition t2 = null;
		pn.addArcSortantVideur(p3,t1);
		pn.addArcSortantVideur(p2, t2);
		
		
	}

	@Test
	void testAddArcEntrant() throws NegParException, NullException {
		Transition t = new Transition();
		//Place p = new Place(1);
		Place p = new Place(0);
		pn.addArcEntrant(1, p, t);
		assertEquals(pn.getNbArcEntrant(),1);
		
		Place p1 = null;
		pn.addArcEntrant(1, p1, t);
		
		Transition t1 = null;
		pn.addArcEntrant(1, p, t1);
		
		pn.addArcEntrant(-1, p, t);
	}

	@Test
	void testAddPlace() {
		//pn.addPlace(1);
		pn.addPlace(-1);
		
	}
	
	@Test
	void testSetPlaceToken() throws NegParException {
		Place p = null;
		pn.setPlaceToken(p, 1);
		
		Place p1 = new Place(1);
		pn.setPlaceToken(p1, -2);
		
		pn.setPlaceToken(p1, 2);
	}
	
	@Test
	void testSetArcSortantWeight() throws NullException, NegParException {
		Transition t = new Transition();
		Place p = new Place(2);
		ArcSortant as1 = null;
		ArcSortant as2 = new ArcSortant(2, p,t);
		
		pn.setArcSortantWeight(as1, 0);
		pn.setArcSortantWeight(as2, -2);
	}
	
	@Test
	void testSetArcEntrantWeight() throws NullException, NegParException {
		Transition t = new Transition();
		Place p = new Place(2);
		ArcEntrant ae1 = null;
		ArcEntrant ae2 = new ArcEntrant(2, p,t);
		
		pn.setArcEntrantWeight(ae1, 0);
		pn.setArcEntrantWeight(ae2, -2);
		pn.setArcEntrantWeight(ae2,1);
	}
	
	@Test
	void testReplaceArcSortant() throws NegParException, NullException {
		Transition t1 = new Transition();
		Place p1 = new Place(1);
		
		Transition t2 = new Transition();
		Place p2 = new Place(4);
		
		ArcSortant as1 = null;
		ArcSortant as2 = new ArcSortant(2,p1,t1);
		
		pn.addArcSortant(3, p2, t2);
		
		pn.replaceArcSortant(as1, 0);
		
		pn.replaceArcSortant(as2, -3);
		
		pn.replaceArcSortant(as2, 0);
	}

	@Test
	void testDeleteTransition() throws NegParException, NullException {
		pn.addTransition();
		pn.deleteTransition(0);
		assertEquals(pn.getNbTransition(), 0);
		pn.addTransition();
		pn.addPlace(1);
		pn.addPlace(2);
		Place p0 = pn.getPlace(0);
		Place p1 = pn.getPlace(1);
		pn.addArcSortant(1, p0, pn.getTransition(0));
		pn.addArcEntrant(2, p1, pn.getTransition(0));
		
		System.out.println(pn.toString());
		
		pn.deleteTransition(0);
		System.out.println(pn.toString());
		
		System.out.println(pn.getListArcEntrant().size());
		assertEquals(pn.getListArcEntrant().size(), 0);
		assertEquals(pn.getListArcSortant().size(), 0);
	}

	@Test
	void testDeletePlace() {
		pn.addPlace(1);
		pn.deletePlace(0);
		assertEquals(pn.getNbPlace(),0);
	}

	@Test
	void testDeleteArcSortant() throws NegParException {
		Place p = new Place(1);
		Transition t = new Transition();
		pn.addArcSortant(1,p,t);
		pn.deleteArcSortant(0);
		assertEquals(pn.getNbArcSortant(), 0);
		
	}

	@Test
	void testDeleteArcEntrant() throws NegParException {
		Place p = new Place(1);
		Transition t = new Transition();
		pn.addArcEntrant(1,p,t);
		pn.deleteArcEntrant(0);
		assertEquals(pn.getNbArcEntrant(), 0);
	}

	@Test
	void testFire() throws NegParException, NullException {
		pn.addTransition();
		
		for (Transition t: pn.getListTransition()) {
			Place p0 = new Place(3);
			Place p1 = new Place(1);
			ArcSortant as = new ArcSortant(3,p0,t);
			ArcEntrant ae = new ArcEntrant(2,p1,t);
			t.addArcEntrant(ae);
			t.addArcSortant(as);
			//we know for sure, here, that t is fireable.
			pn.fire();
			assertEquals(p0.getNbToken(),0);
			assertEquals(p1.getNbToken(), 3);
		}
	}


	@Test
	void testToStringEntrant() throws NegParException {
		Transition t = new Transition();
		Place p = new Place(1);
		pn.addArcEntrant(1, p, t);
		assertEquals(pn.toString(),"T0 -------1------> P0 : 1/n");
	}
	
	@Test
	void testToStringSortant() throws NegParException {
		Transition t = new Transition();
		Place p = new Place(1);
		pn.addArcSortant(1, p, t);
		assertEquals(pn.toString(),"P0 : 1 -------1------> T0/n");
	}
	
	@Test
	void testGetArcEntrant() throws NegParException, NullException {
		Place p = new Place(1);
		Transition t = new Transition();
		ArcEntrant ae = new ArcEntrant(1, p, t);
		pn.getListArcEntrant().add(ae);
		
		int i1 = -1;
		assertEquals(pn.getArcEntrant(i1), null);
		
		int i2 = 2;
		assertEquals(pn.getArcEntrant(i2), null);
		
		int i3 = 0;
		assertEquals(pn.getArcEntrant(i3), ae);
	}
	
	@Test
	void testGetArcSortant() throws NegParException, NullException {
		Place p = new Place(1);
		Transition t = new Transition();
		ArcSortant as = new ArcSortant(1, p, t);
		pn.getListArcSortant().add(as);
		
		int i1 = -1;
		assertEquals(pn.getArcSortant(i1), null);
		
		int i2 = 2;
		assertEquals(pn.getArcSortant(i2), null);
		
		int i3 = 0;
		assertEquals(pn.getArcSortant(i3), as);
	}
	
	@Test
	void testGetPlace() throws NegParException {
		Place p = new Place(1);
		pn.getListPlace().add(p);
		
		int i1 = -1;
		assertEquals(pn.getPlace(i1), null);
		
		int i2 = -1;
		assertEquals(pn.getPlace(i2), null);
		
		int i3 = 0;
		assertEquals(pn.getPlace(i3), p);
	}
	
	@Test
	void testGetTransition() {
		Transition t = new Transition();
		pn.getListTransition().add(t);
		
		int i1 = -1;
		assertEquals(pn.getTransition(i1), null);
		
		int i2 = -1;
		assertEquals(pn.getTransition(i2), null);
		
		int i3 = 0;
		assertEquals(pn.getTransition(i3), t);
	}
	
	


}
