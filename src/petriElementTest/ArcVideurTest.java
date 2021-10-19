package petriElementTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Error.NegParException;
import Error.NullException;
import petriElement.ArcVideur;

import petriElement.Place;
import petriElement.Transition;

class ArcVideurTest {

	private static Place p;
	private static ArcVideur av;
	private static Transition t;
	
	
	@Test
	@BeforeEach
	void setUp() throws NullException, NegParException {
		Transition.reset();
		Place.reset();
		p = new Place(1);
		t = new Transition();
		av = new ArcVideur(p,t);
	}
	
	
	@Test
	void testConstructor() throws NegParException, NullException {
		
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcVideur(null,t);
		});
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcVideur(null,null);
		});
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcVideur(p,null);
		});
	}
	
	@Test
	void testArcState() {
		assertEquals(av.arcState(),true);
		assertEquals(av.getWeight(),1);
		p.substractToken(1);
		assertEquals(av.arcState(),false);
	}
	
	@Test
	void testToString() {
		assertEquals(av.toString(), "P0 : 1 -------Videur------> T0" );
	}
	
	
}
