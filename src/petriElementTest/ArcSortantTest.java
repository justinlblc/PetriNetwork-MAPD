package petriElementTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Error.NegParException;
import Error.NullException;
import petriElement.ArcSortant;
import petriElement.Place;
import petriElement.Transition;

class ArcSortantTest {
	private static Place p;
	private static ArcSortant a0;
	private static Transition t;
	
	
	@Test
	@BeforeEach
	void testConstructor() throws NegParException, NullException {
		p = new Place(1);
		t = new Transition();
		a0 = new ArcSortant(2,p,t);
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcSortant(0,null,t);
		});
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcSortant(0,null,null);
		});
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcSortant(0,p,null);
		});
		Assertions.assertThrows(NegParException.class, () -> {
		    new ArcSortant(-1,p,t);
		});
	}
	
	
	@Test 
	void testGetWeight() {
		assertEquals(a0.getWeight(),2);
	}
	
	@Test
	void testGetPlace() {
		assertEquals(a0.getPlace(),p);
		
	}
	
	@Test
	void testGetTransition() {
		assertEquals(a0.getTransition(),t);
	}
	
	@Test
	void testArcState() {
		assertEquals(a0.arcState(),false);
		p.addToken(1);
		assertEquals(a0.arcState(),true);
	}
	
	
	@Test
	void testSubstract() {
		p.addToken(1);
		a0.substract();
		assertEquals(p.getNbToken(),0);
	}
	
	@Test
	void testToString() {
		assertEquals(a0.toString(),"-------"+2+"------>");
	}
}
