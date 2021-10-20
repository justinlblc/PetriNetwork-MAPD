package petriElementTest;


import static org.junit.jupiter.api.Assertions.*;

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

class TransitionTest {
	private Transition t0;
	
	
	@Test
	@BeforeEach
	void setUp() {
		Transition.reset();
		Place.reset();
		t0 = new Transition();
	}
	
	@Test
	void testAddArcEntrant() throws NegParException, NullException {
		
		//Place p0 = new Place(1);
		//Place p1 = new Place(2);
		Place p2 = new Place(0);
		//Place p3 = new Place(3);
		ArcEntrant ae = new ArcEntrant(1,p2,t0);
		t0.addArcEntrant(ae);
	}
	
	@Test
	void testGetArcEntrant() throws NegParException, NullException {
		//Place p0 = new Place(1);
		//Place p1 = new Place(2);
		Place p2 = new Place(0);
		//Place p3 = new Place(3);
		ArcEntrant ae = new ArcEntrant(1,p2,t0);
		t0.addArcEntrant(ae);
		assertEquals(t0.getArcEntrant(0),ae);
	}
	
	@Test
	void testDellArcEntrant() throws NegParException, NullException {
		//Place p0 = new Place(1);
		//Place p1 = new Place(2);
		Place p2 = new Place(0);
		//Place p3 = new Place(3);
		ArcEntrant ae = new ArcEntrant(1,p2,t0);
		t0.addArcEntrant(ae);
		assertEquals(t0.dellArcEntrant(ae),true);
		assertEquals(t0.dellArcEntrant(null),false);
	}
	
	@Test
	void testAddArcSortant() throws NegParException, NullException {
		
		//Place p0 = new Place(1);
		//Place p1 = new Place(2);
		Place p2 = new Place(0);
		//Place p3 = new Place(3);
		ArcSortant as = new ArcSortant(1,p2,t0);
		t0.addArcSortant(as);
	}
	
	@Test
	void testGetArcSortant() throws NegParException, NullException {
		//Place p0 = new Place(1);
		//Place p1 = new Place(2);
		Place p2 = new Place(0);
		//Place p3 = new Place(3);
		ArcSortant as = new ArcZero(p2,t0);
		t0.addArcSortant(as);
		assertEquals(t0.getArcSortant(0),as);
	}
	
	@Test
	void testDellArcSOrtant() throws NegParException, NullException {
		//Place p0 = new Place(1);
		//Place p1 = new Place(2);
		Place p2 = new Place(0);
		//Place p3 = new Place(3);
		ArcSortant as = new ArcVideur(p2,t0);
		t0.addArcSortant(as);
		assertEquals(t0.dellArcSortant(as),true);
		assertEquals(t0.dellArcSortant(null),false);
	}
	
	
	@Test
	void testFireable() throws NegParException, NullException {
		Place p0 = new Place(1);
		Place p1 = new Place(2);
		Place p2 = new Place(0);
		//Place p3 = new Place(3);
		//Place p4 = new Place(0);
		
		ArcSortant as0 = new ArcSortant(1,p0,t0);
		ArcSortant as1 = new ArcZero(p1,t0);
		ArcSortant as2 = new ArcVideur(p2,t0);
		
		t0.addArcSortant(as0);
		t0.addArcSortant(as1);
		t0.addArcSortant(as2);
		
		assertEquals(t0.fireable(),false);
		
		p2.addToken(1);
		assertEquals(t0.fireable(),false);
		
		p1.substractToken(2);
		assertEquals(t0.fireable(),true);
		
		Transition t1 = new Transition();
		assertEquals(t1.fireable(),true);
	}
	
	@Test
	void testFire() throws NegParException, NullException {
		Place p0 = new Place(1);
		Place p1 = new Place(0);
		Place p2 = new Place(1);
		Place p3 = new Place(3);
		Place p4 = new Place(0);
		
		ArcSortant as0 = new ArcSortant(1,p0,t0);
		ArcSortant as1 = new ArcZero(p1,t0);
		ArcSortant as2 = new ArcVideur(p2,t0);
		ArcEntrant ae3 = new ArcEntrant(1,p3,t0);
		ArcEntrant ae4 = new ArcEntrant(10,p4,t0);

		t0.addArcSortant(as0);
		t0.addArcSortant(as1);
		t0.addArcSortant(as2);
		t0.addArcEntrant(ae4);
		t0.addArcEntrant(ae3);
		
		if (t0.fireable()) {
			t0.fire();
		}
		
		
		assertEquals(p0.getNbToken(),0);
		assertEquals(p1.getNbToken(),0);
		assertEquals(p2.getNbToken(),0);
		assertEquals(p3.getNbToken(),4);
		assertEquals(p4.getNbToken(),10);
		
		
		
	}
	
	
	
	
	@Test
	void testToString() {
		System.out.println(t0.toString());
	}
	


}
