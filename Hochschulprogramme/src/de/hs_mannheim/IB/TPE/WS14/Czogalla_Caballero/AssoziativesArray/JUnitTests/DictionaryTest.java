package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.JUnitTests;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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

	/**
	 * @summary testet ob der Datentyp richtig gesetzt wird ovn Generics eig.
	 *          sinnlos, da der Compiler Integer automatisch als String
	 *          darstellt bei Notwendigkeit
	 * 
	 * @returnType void
	 */
	@Test
	public void testDatentyp() {

		Dictionary<String, String> dictTest = new Dictionary<>();
		Dictionary<Integer, Integer> dictInteger = new Dictionary<>();

		for (int i = 0; i < 10; i++) {

			dictInteger.put("Test" + i, i + 10 + "");
			dictTest.put("Test" + i, i + 10 + "");
		}

		assertArrayEquals(dictTest.values(), dictInteger.values());

	}

	/**
	 * @summary testet beide Methoden keys und values aus
	 * 
	 * @returnType void
	 */
	@Test
	public void testMethoden() {

		Dictionary<String, String> dictTest = new Dictionary<>();

		String[] testKeys = new String[5];
		String[] testValues = new String[5];

		String[] actualKeys;
		String[] actualValues;

		boolean containsKey = false;
		boolean containsValue = false;

		for (int i = 0; i < 5; i++) {

			dictTest.put("Test" + i, i + 10 + "");

			testKeys[i] = "Test" + i;
			testValues[i] = (i + 10) + "";
		}

		actualKeys = dictTest.keys();
		actualValues = dictTest.values();

		// Test f�r Methode keys
		for (int i = 0; i < testKeys.length; i++) {
			for (int j = 0; j < actualKeys.length; j++) {
				if (testKeys[i].equals(actualKeys[j])) {
					containsKey = true;
				}
			}
			assertEquals(containsKey, true);
		}

		// Test f�r Methode values
		for (int i = 0; i < testValues.length; i++) {
			for (int j = 0; j < actualValues.length; j++) {
				if (testValues[i].equals(actualValues[j])) {
					containsValue = true;
				}
			}
			assertEquals(containsValue, true);
		}

	}

}
