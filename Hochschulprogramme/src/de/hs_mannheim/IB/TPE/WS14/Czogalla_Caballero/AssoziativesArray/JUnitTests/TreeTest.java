/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.JUnitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.Tree;

/**@summary JUnit-TEst von Tree<K,V>
 *
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 26.11.2014
 *
 */
public class TreeTest {
	
	@Test
	public void addNodeTest() {
		Tree<String,Integer> testTree = new Tree<>();
		
		testTree.addNode("TestKey", 42);
		testTree.addNode("TestKey2", 1);
		
		assertTrue(testTree.getRoot().getValue().equals(42));
		assertTrue(testTree.getRoot().getRight().getValue().equals(1));
		
		assertTrue(testTree.getRoot().getKey().equals("TestKey"));
		assertTrue(testTree.getRoot().getRight().getKey().equals("TestKey2"));
		
	}

}
