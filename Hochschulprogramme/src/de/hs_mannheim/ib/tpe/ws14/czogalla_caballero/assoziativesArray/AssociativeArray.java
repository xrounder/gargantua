/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.assoziativesArray;

import java.util.ArrayList;

/**
 * Assoziatives Array, das intern einen Binärbaum verwendet
 * 
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 * @created 20.11.2014
 * @param <K>
 * @param <V>
 */
public class AssociativeArray<K, V> implements IAssociativeArray<K, V> {

	/**
	 * Attribute
	 */
	private Tree<K, V> tree;

	/**
	 * 
	 * Konstruktor
	 */
	public AssociativeArray() {

		this.tree = new Tree<K, V>();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#clear()
	 */
	@Override
	public void clear() {

		tree.clearTree();

	}

	/**
	 * @summary gibt tree zurück
	 * 
	 *          Tree<K,V> @return tree
	 */
	public Tree<K, V> getTree() {

		return tree;
	}

	/**
	 * @summary durchsucht den Baum rekursiv nach dem übergebenen Wert
	 * 
	 * @param parent
	 * @param value
	 * @return <boolean> found
	 */
	private boolean searchValue(Tree<K, V>.Node parent, V value) {

		boolean found;

		if (parent.getValue().equals(value)) {

			found = true;

		} else {

			found = false;

			if (parent.getLeft() != null) {

				found = searchValue(parent.getLeft(), value);

			}

			if (parent.getRight() != null && !found) {

				found = searchValue(parent.getRight(), value);
			}

		}

		return found;
	}

	/**
	 * @summary durchsucht den übergebenen Schlüssel rekursiv im Baum
	 * 
	 * @param parent
	 * @param key
	 * @return found
	 * @returnType boolean
	 */
	private boolean searchKey(Tree<K, V>.Node parent, K key) {

		boolean found;

		if (parent.getKey().equals(key)) {

			found = true;

		} else {

			found = false;

			if (parent.getLeft() != null) {

				found = searchKey(parent.getLeft(), key);

			}

			if (parent.getRight() != null && !found) {

				found = searchKey(parent.getRight(), key);

			}

		}

		return found;

	}

	/**
	 * @summary findet anhand des übergebenen Schlüssels den dazugehörigen Wert
	 * 
	 * @param parent
	 * @param key
	 * @return value
	 * @returnType V
	 */
	private V getValueByKey(Tree<K, V>.Node parent, K key) {

		V value;

		if (parent.getKey().equals(key)) {

			value = parent.getValue();

		} else {

			value = null;
			if (parent.getLeft() != null) {

				value = getValueByKey(parent.getLeft(), key);

			}

			if (parent.getRight() != null && value == null) {

				value = getValueByKey(parent.getRight(), key);

			}
		}

		return value;
	}

	/**
	 * @summary ersetzt den Wert des übergebenen Schlüssel mit neuem übergebenen
	 *          Wert
	 * 
	 * @param parent
	 * @param key
	 * @param value
	 * @returnType void
	 */
	private void updateNode(Tree<K, V>.Node parent, K key, V value) {

		if (parent.getKey().equals(key)) {

			parent.setValue(value);
		}

		if (parent.getLeft() != null) {

			updateNode(parent.getLeft(), key, value);

		}

		if (parent.getRight() != null) {

			updateNode(parent.getRight(), key, value);

		}

	}

	/**
	 * @summary wandelt den Knoten als Zeichenkette um
	 * 
	 * @param parent
	 * @return saveData
	 * @returnType String
	 */
	private String nodeToString(Tree<K, V>.Node parent) {

		String saveData = "";

		/*
		saveData += "{KEY=" + parent.getKey() + ", VALUE=" + parent.getValue()
				+ "}\n";
		*/
		
		saveData += "" + parent.getKey() + "=" + parent.getValue()
				+ ", ";
		
		
		if (parent.getLeft() != null) {

			saveData += nodeToString(parent.getLeft());

		}

		if (parent.getRight() != null) {

			saveData += nodeToString(parent.getRight());

		}

		
		
		return saveData;

	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(V value) {
		
		if(isEmpty()){
			
			return false;
		
		}else{
		
			return searchValue(tree.getRoot(), value);
		
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {
		
		if(isEmpty()){
		
			return false;
		
		}else{
		
			return searchKey(tree.getRoot(), key);
		
		}
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#get(java.lang.Object)
	 */
	@Override
	public V get(K key) {

		return getValueByKey(tree.getRoot(), key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#isEmpty()
	 */
	@Override
	public boolean isEmpty() {

		if (tree.getRoot() == null) {

			return true;
		} else {

			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void put(K key, V value) {

		tree.addNode(key, value);

	}

	/**
	 * @summary fügt alle Knoten des übergebenen Baumes dem Baum an
	 * 
	 * @param parent
	 * @returnType void
	 */
	public void putAllRecursive(Tree<K, V>.Node parent) {
				
		if (parent != null){
			
			put(parent.getKey(),parent.getValue());
			
			if (parent.getRight() != null) {
				put(parent.getRight().getKey(), parent.getRight().getValue());
				putAllRecursive(parent.getRight());
			}
			if (parent.getLeft() != null) {
				put(parent.getLeft().getKey(), parent.getLeft().getValue());
				putAllRecursive(parent.getLeft());
			}
		}
	}

	/**
	 * 	@summary führt den BiConsumer aus
	 * 
	 * @param parent
	 * @param biCon
	 * @returnType void
	 */
	private void doBiConsumer(Tree<K, V>.Node parent, BiConsumer<K, V> biCon) {
		
		biCon.accept(parent.getKey(), parent.getValue());

		if (parent.getLeft() != null) {

			doBiConsumer(parent.getLeft(), biCon);

		}

		if (parent.getRight() != null) {

			doBiConsumer(parent.getRight(), biCon);

		}

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray
	 * #putAll(de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray
	 * .AssociativeArray)
	 */
	@Override
	public void putAll(AssociativeArray<K, V> newArray) {

		Tree<K, V>.Node root = newArray.tree.getRoot();

		putAllRecursive(root);
	}
	
	/**
	 * @summary rekursiv durhclaufen um zu löschen
	 * 
	 * @param parent
	 * @param key
	 * @return
	 * @returnType V
	 */
	public V removeRecursive(ArrayList<Tree<K,V>.Node> savedNodes, Tree<K,V>.Node parent, K key) {

		V value = null;
		
		if (parent != null){
			
			if(!(parent.getKey().equals(key))){
				savedNodes.add(parent);
			}else{
				value = parent.getValue();
			}
				
			if (parent.getRight() != null) {
				removeRecursive(savedNodes, parent.getRight(), key);
			}
			if (parent.getLeft() != null) {
				removeRecursive(savedNodes, parent.getLeft(), key);
				
			}

		}
		
		return value;

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#remove(java.lang.Object)
	 */
	@Override
	public V remove(K key) {
		V value = null;
		ArrayList<Tree<K,V>.Node> savedNodes = new ArrayList<>();
		
		value = removeRecursive(savedNodes, getTree().getRoot(), key);
		
		clear();
		
		for(Tree<K, V>.Node savedNode : savedNodes){
			getTree().addNode(savedNode.getKey(),savedNode.getValue());
		}
		
		return value;		

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#size()
	 */
	@Override
	public int size() {

		return tree.getCountNodes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#update(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void update(K key, V value) {
		
		if(containsKey(key)){
		
			updateNode(tree.getRoot(), key, value);
		
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<K, V> biCon) {

		doBiConsumer(tree.getRoot(), biCon);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray
	 * #extractAll(de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero
	 * .AssoziativesArray.AssociativeArray)
	 */
	@Override
	public void extractAll(AssociativeArray<K, V> newArray) {

		newArray.putAll(this);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#map()
	 */
	@Override
	public AssociativeArray<K,V> map(BiFunction<K, V, V> biFunc) {
		
		AssociativeArray<K,V> newArray = new AssociativeArray<>();
		/*
		if (!this.isEmpty()) {
			
			BiConsumer<K, V> biCon = (key, value) -> {
			
				value = biFunc.apply(key, value);
				newArray.put(key, value);
		
			};
			
			this.forEach(biCon);
		}*/
		
		return newArray;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "{ "+ nodeToString(tree.getRoot())+" }";
	}

}
