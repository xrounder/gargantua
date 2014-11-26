package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.Dictionary;
import de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.Tree;

/**
 * @summary JUnit-TEst von Dictionary<K,V>
 * 
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 26.11.2014
 * 
 */
public class DictionaryTest {

	
	@Test
	public void testDatentyp() {
		
		Dictionary<String, String> dictTest = new Dictionary<>();
		Dictionary<Integer, Integer> dictInteger = new Dictionary<>();
		
		for(int i = 0; i < 10; i++){
			
			dictInteger.put("Test"+i, i+10+"");
			dictTest.put("Test"+i, i+10+"");
		}
		
		assertArrayEquals(dictTest.keys(), dictInteger.keys());
		assertArrayEquals(dictTest.values(), dictInteger.values());

	}

	@Test
	public void testMethoden(){
		
		Dictionary<String, String> dictTest = new Dictionary<>();
		
		String[] testKeys = new String[5];
		String[] testValues = new String[5];
		
		for(int i = 0; i < 5; i++){
			
			dictTest.put("Test"+i, i+10+"");
			
			testKeys[i] = "Test"+i;
			testValues[i] = (i+10)+"";
		}
	
		
		assertArrayEquals(testKeys, dictTest.keys());
		assertArrayEquals(testValues, dictTest.values());
	
		
	}
	
}
