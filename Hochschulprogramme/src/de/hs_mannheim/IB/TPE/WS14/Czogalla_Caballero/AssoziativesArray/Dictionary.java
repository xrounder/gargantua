/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 * @summary
 * 
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 24.11.2014
 * 
 * @param <K>
 * @param <V>
 */
public class Dictionary<K, V> extends AssociativeArray<String, String> {

	/**
	 * @summary soll ein Array, welches alle Schlüssel enthält, zurückliefern
	 * 
	 * @return keys
	 * @returnType String[]
	 */
	public String[] keys() {
		String[] keys = new String[size()];
		
		keys[0] = getTree().getRoot().getKey();
		keys = fillWithKeys(keys, getTree().getRoot(), 1);

		return keys;
	}

	/**
	 * @summary füllt das Array mit Schüsseln; durchläuft den Baum dabei
	 *          rekursiv
	 * 
	 * @param keys
	 * @param parent
	 * @param keyIndex
	 * @return keys
	 * @returnType String[]
	 */
	private String[] fillWithKeys(String[] keys,
			Tree<String, String>.Node parent, int keyIndex) {

		if (parent != null && keyIndex < keys.length) {
					
			if (parent.getLeft() != null) {

				keys[keyIndex] = parent.getLeft().getKey().toString();
				fillWithKeys(keys, parent.getLeft(), keyIndex);
				keyIndex++;
			} 
			if (parent.getRight() != null) {

				keys[keyIndex] = parent.getRight().getKey().toString();
				fillWithKeys(keys, parent.getRight(), keyIndex);
				keyIndex++;
			}
		}
		return keys;
	}

	/**
	 * @summary soll ein Array, welches Werte enthält, zurückliefern
	 * 
	 * @return values
	 * @returnType String[]
	 */
	public String[] values() {
		String[] values = new String[size()];

		values[0] = getTree().getRoot().getValue();
		values = fillWithValues(values, getTree().getRoot(), 1);

		return values;
	}

	/**
	 * @summary füllt das Array mit Werten; durchläuft den Baum dabei rekursiv
	 * 
	 * @param values
	 * @param parent
	 * @param valueIndex
	 * @return values
	 * @returnType String[]
	 */
	private String[] fillWithValues(String[] values,
			Tree<String, String>.Node parent, int valueIndex) {

		if (parent == null && valueIndex < values.length) {

		} else if (parent.getLeft() == null && valueIndex < values.length) {

			values[valueIndex] = parent.getRight().getKey().toString();
			fillWithValues(values, parent.getRight(), valueIndex++);

		} else if (parent.getRight() == null && valueIndex < values.length) {

			values[valueIndex] = parent.getRight().getKey().toString();
			fillWithValues(values, parent.getLeft(), valueIndex++);
		}
		return values;
	}

}
