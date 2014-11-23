/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 *  @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 *
 */
public class TestEnvironment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Tree<String, Integer> tree = new Tree<String,Integer>();
	
		tree.addNode("Test", 2);
		
		System.out.println(tree.getHeadnode().getValue());
		System.out.println(tree.getHeadnode().getKey());
	}

}
