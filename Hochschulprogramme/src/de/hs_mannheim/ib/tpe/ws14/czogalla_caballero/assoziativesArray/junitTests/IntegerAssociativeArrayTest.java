package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.assoziativesArray.junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.assoziativesArray.Dictionary;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.assoziativesArray.IntegerAssociativeArray;

public class IntegerAssociativeArrayTest {

	@Test
	public void testDatentyp() {
		
		IntegerAssociativeArray<String, Integer> intArrTest = new IntegerAssociativeArray<>();
		IntegerAssociativeArray<String, String> intArrString = new IntegerAssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			intArrString.put("Test"+i, i+10);
			intArrTest.put("Test"+i, i+10);
		}
		
			assertEquals(intArrTest.getTree().getRoot().getKey(),intArrString.getTree().getRoot().getKey());
			assertEquals(intArrTest.getTree().getRoot().getValue(), intArrString.getTree().getRoot().getValue());
			
		}
	

}

