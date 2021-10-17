package petriElementTest;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import petriElement.Transition;

class TransitionTest {
	private static Transition t0;
	
	
	@Test
	@BeforeEach
	void testConstructor() {
		t0 = new Transition();
	}
	
	@Test 
	void testToString() {
		System.out.println(t0.toString());
	}
	


}
