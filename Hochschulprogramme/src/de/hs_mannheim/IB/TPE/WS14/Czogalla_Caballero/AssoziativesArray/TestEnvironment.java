/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 * 
 */
public class TestEnvironment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AssociativeArray<String, Integer> arr = new AssociativeArray<String, Integer>();

		for (int i = 0; i < 10; i++) {

			arr.put("Test" + i, i + 5);

		}

		System.out.println(arr.toString());
		// System.out.println(arr.searchValue(arr.baum.getRoot(),
		// arr.baum.getRoot().getLeft(), arr.baum.getRoot().getRight(), 8));

		System.out.println(arr.containsKey("Test5"));
		System.out.println(arr.containsValue(14));

		System.out.println();
		// System.out.println(arr.baum.getRoot().getRight().getKey());
		System.out.println("funzt net:" + arr.get("Test1"));

		System.out.println(arr.toString());
		arr.update("Test3", 10002);

		System.out.println(arr.toString());

	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((key == null) ? 0 : key.hashCode()); result =
	 * prime * result + ((left == null) ? 0 : left.hashCode()); result = prime *
	 * result + ((right == null) ? 0 : right.hashCode()); result = prime *
	 * result + ((value == null) ? 0 : value.hashCode()); return result; }
	 */

}
