/*
Test IDL by Yaohua Franck XU
*/




package petriElementTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Error.NegParException;
import petriElement.Place;

class PlaceTest {
	
	private static Place p0;

	@Test
	@BeforeEach
	public void setUp() throws NegParException {
		Place.reset();
		p0 = new Place(1);
	}
	
	
	@Test
	public void testConstructor() throws NegParException{
		Assertions.assertThrows(NegParException.class, () -> {
		    new Place(-1);
		});
	}
	
	@Test
	public void testGetNbToken() {
		assertEquals(p0.getNbToken(),1);
	}
	
	@Test
	public void testAddToken() {
		p0.addToken(1);
		assertEquals(p0.getNbToken(),2);
	}
	
	@Test
	public void testSubstractToken() {
		p0.substractToken(1);
		assertEquals(p0.getNbToken(),0);
	}
	
	@Test
	public void testToString() {
		assertEquals(p0.toString(),"P0 : 1");
	}
	

}
