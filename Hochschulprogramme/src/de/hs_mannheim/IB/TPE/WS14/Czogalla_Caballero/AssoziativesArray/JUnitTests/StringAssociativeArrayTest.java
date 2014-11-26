package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.JUnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.StringAssociativeArray;
/**
 * @summary JUnit-TEst von StringAssociativeArray<K,V>
 * 
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 * @created 20.11.2014
 */

public class StringAssociativeArrayTest {

	@Test
	public void testDatentyp() {
		
		StringAssociativeArray<String, Integer> strArrTest = new StringAssociativeArray<>();
		StringAssociativeArray<Integer, Integer> strArrInteger = new StringAssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			strArrTest.put("Test"+i, i+10);
			strArrInteger.put("Test"+i, i+10);
		}
		
			assertEquals(strArrTest.getTree().getRoot().getKey(),strArrInteger.getTree().getRoot().getKey());
			assertEquals(strArrTest.getTree().getRoot().getValue(), strArrInteger.getTree().getRoot().getValue());
			
		}
	
	
}
