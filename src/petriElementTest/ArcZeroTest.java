package petriElementTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Error.NegParException;
import Error.NullException;
import petriElement.ArcZero;
import petriElement.Place;
import petriElement.Transition;

class ArcZeroTest {
	private static Place p;
	private static ArcZero a0;
	private static Transition t;
	
	
	@Test
	@BeforeEach
	void testConstructor() throws NegParException, NullException {
		p = new Place(1);
		t = new Transition();
		a0 = new ArcZero(p,t);
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcZero(null,t);
		});
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcZero(null,null);
		});
		Assertions.assertThrows(NullException.class, () -> {
		    new ArcZero(p,null);
		});
	}
	
	@Test
	void testArcState() {
		assertEquals(a0.arcState(),false);
		p.substractToken(1);
		assertEquals(a0.arcState(),true);
	}
	
	@Test
	void testToString() {
		assertEquals(a0.toString(), "P38 : 1 --------Zero-------> T29" );
	}
	
	
	
	
	

}
