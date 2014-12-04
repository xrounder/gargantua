package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.assoziativesArray.junitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.assoziativesArray.AssociativeArray;
/**
 * @summary JUnit-TEst von AssociativeArray<K,V>
 * 
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 * @created 20.11.2014
 */
public class AssociativeArrayTest {

	
	@Test
	public void containsKey(){
		
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			testArray.put("Test"+i, i);
		}
		
		for(int i = 0; i < 10; i++){
			
			assertTrue("{KEY=Test"+i+"} nicht vorhanden",testArray.containsKey("Test"+i));
			
		}
		
	}
	
	@Test
	public void containsValue(){
		
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			testArray.put("Test"+i, i+13);
		}
		
		for(int i = 0; i < 10; i++){
			
			assertTrue("{VALUE="+(i+13)+"} nicht vorhanden",testArray.containsValue(i+13));
			
		}
		
	}
	
	@Test
	public void getValueByKey(){
		
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
			
		for(int i = 0; i < 10; i++){
			
			testArray.put("Test"+i, i+13);
		}
		
		
		for(int i = 0; i < 10; i++){
			
			int testValue = i+13;
			int actualValue = testArray.get("Test"+i);
			
			assertEquals("Werte sind ungleich!",testValue, actualValue);
		}
		
		
	}
	
	@Test 
	public void put(){
		
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
		
		String key = "IchBinEinSchlüssel";
		int value = 42;
		
		testArray.put(key, value);
		
		assertEquals(key, testArray.getTree().getRoot().getKey());
		
		int actualValue = testArray.getTree().getRoot().getValue();
		
		assertEquals(value, actualValue);
	}
	
	@Test
	public void isEmpty(){
		
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			testArray.put("Test"+i, i+13);
		}
		
		assertFalse(testArray.isEmpty());
		
		testArray.clear();
		
		assertTrue(testArray.isEmpty());
		
	}

	@Test
	public void clear(){
		
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			testArray.put("Test"+i, i+13);
		}
		
		testArray.clear();
		
		assertFalse(testArray.containsKey("Test5"));
		assertFalse(testArray.containsKey("Test8"));
		assertFalse(testArray.containsKey("Test1"));
		assertFalse(testArray.containsValue(13));
		assertFalse(testArray.containsValue(14));
		
	}

	@Test
	public void size(){
		
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
		
		int countPuts = 0;
		
		for(int i = 0; i < 10; i++){
			
			testArray.put("Test"+i+2, i+13);
			countPuts++;
		}
		
		assertEquals(countPuts, testArray.size());
		
	}

	@Test
	public void remove(){
		
		AssociativeArray<Integer, String> testArray =  new AssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			testArray.put(i, "Test"+i);
			
		}
		
		testArray.remove(5);
		
		assertFalse("Value noch vorhanden!",testArray.containsValue("Test5"));
		assertTrue("Value nicht mehr vorhanden!",testArray.containsValue("Test6"));
		
		
		assertTrue("Value nicht mehr vorhanden!",testArray.containsValue("Test9"));
		assertTrue("Value nicht mehr vorhanden!",testArray.containsValue("Test8"));
		assertTrue("Value nicht mehr vorhanden!",testArray.containsValue("Test7"));
	
	}
	
	@Test
	public void update(){
		
		
		AssociativeArray<Integer, String> testArray =  new AssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			testArray.put(i, "Test"+i);
			
		}
		
		int key = 5;
		String value = "Die Antwort auf alle Fragen ist 42";
		
		testArray.update(key, value);
		
		assertTrue("Schlüssel nicht vorhanden!",testArray.containsKey(key));
		assertTrue("Wert nicht vorhanden!",testArray.containsValue(value));
		
		
	}
	
	@Test
	public void putAll(){
		
		AssociativeArray<Integer, String> testArray =  new AssociativeArray<>();
		AssociativeArray<Integer, String> newArray =  new AssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			testArray.put(i, "Test"+i);
			newArray.put(i+10, "Test"+(i+10));
			
		}
		
		testArray.putAll(newArray);
		
		assertTrue("Key nicht vorhanden",testArray.containsKey(15));
		assertTrue("Key nicht vorhanden",testArray.containsKey(10));
		assertTrue("Key nicht vorhanden",testArray.containsKey(13));
		
		assertTrue("Value nicht vorhanden",testArray.containsValue("Test16"));
		assertTrue("Value nicht vorhanden",testArray.containsValue("Test18"));
		assertTrue("Value nicht vorhanden",testArray.containsValue("Test12"));
		
		
	}
	
	@Test
	public void biConsumer(){
		/*
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
		
		for(int i = 0; i < 10; i++){
			
			testArray.put("Test"+i, i);
			
		}
		
		BiConsumer<String, Integer> plus5 = (key, value) -> {testArray.update(key, value+5);};
		
		testArray.forEach(plus5);
		
		assertTrue(testArray.get("Test0").equals(5));
		assertTrue(testArray.get("Test1").equals(6));
		assertTrue(testArray.get("Test5").equals(10));*/
	}
	
	@Test
	public void extractAll(){
		
		AssociativeArray<String, Integer> testArray =  new AssociativeArray<>();
		AssociativeArray<String, Integer> newArray =  new AssociativeArray<>();
		
		
		for(int i = 0; i < 10; i++){
			
			testArray.put("Test"+i, i);
			newArray.put("Test"+(i+10), i+10);
		}
		
		testArray.extractAll(newArray);
		
		assertTrue(newArray.containsKey("Test1"));
		assertTrue(newArray.containsKey("Test5"));
		assertTrue(newArray.containsKey("Test9"));

		assertTrue(newArray.containsValue(2));		
		assertTrue(newArray.containsValue(6));
		assertTrue(newArray.containsValue(7));
	}
	

	
}
