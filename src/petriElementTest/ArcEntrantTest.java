
package petriElementTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Error.NegParException;
import Error.NullException;
import petriElement.ArcEntrant;
import petriElement.Place;
import petriElement.Transition;

class ArcEntrantTest {

	private static Place p;
	private static ArcEntrant ae;
	private static Transition t;
	
	
	@Test
	@BeforeEach
	void setUp() throws NegParException, NullException {
		Transition.reset();
		Place.reset();
		p = new Place(1);
		t = new Transition();
		ae = new ArcEntrant(2,p,t);
	}
	
	
	@Test
	@BeforeEach
	void testConstructor() throws NegParException, NullException {
		p = new Place(1);
		t = new Transition();
		ae = new ArcEntrant(2,p,t);
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcEntrant(0,null,t);
		});
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcEntrant(0,null,null);
		});
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcEntrant(0,p,null);
		});
		Assertions.assertThrows(NegParException.class, () -> {
		    new ArcEntrant(-1,p,t);
		});
	}

	
	@Test
	void testGetPlace() {
		assertEquals(ae.getPlace(),p);
		
	}
	
	@Test
	void testGetTransition() {
		assertEquals(ae.getTransition(),t);
	}
	

	
	@Test
	void testSubstract() {
		ae.add();
		assertEquals(p.getNbToken(),3);
	}
	
	@Test
	void testToString() {
		assertEquals(ae.toString(),"T1 -------"+2+"------> P1 : 1");
	}
}
