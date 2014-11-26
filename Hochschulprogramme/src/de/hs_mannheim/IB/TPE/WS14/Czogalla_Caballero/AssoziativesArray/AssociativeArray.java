/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

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
	 * @summary durchläuft den Baum anhand des übergebenen Keys rekursiv und
	 *          gibt den Knoten zurück
	 * 
	 * @param parent
	 * @param key
	 * @return foundNode
	 * @returnType Tree<K,V>.Node
	 */
	private Tree<K, V>.Node getNodeByKey(Tree<K, V>.Node parent, K key) {

		Tree<K, V>.Node foundNode = null;

		if (parent.getKey().equals(key)) {

			foundNode = parent;
			return foundNode;

		} else {

			foundNode = null;
			if (parent.getLeft() != null) {

				foundNode = getNodeByKey(parent.getLeft(), key);

			}

			if (parent.getRight() != null && foundNode == null) {

				foundNode = getNodeByKey(parent.getRight(), key);

			}
			

		}

		return foundNode;
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
	private void putAllRecursive(Tree<K, V>.Node parent) {
		
		if (parent != null) {

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

	private void doBiConsumer(Tree<K, V>.Node parent,
			Tree<K, V>.Node leftChild, Tree<K, V>.Node rightChild,
			BiConsumer<K, V> biCon) {

		// biCon.<?????WTF?_.|.,???>.getClass();
		biCon.accept(parent.getKey(), parent.getValue());

		if (leftChild != null) {

			doBiConsumer(leftChild, leftChild.getLeft(), leftChild.getRight(),
					biCon);

		}

		if (rightChild != null) {

			doBiConsumer(rightChild, rightChild.getLeft(),
					rightChild.getRight(), biCon);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray.
	 * IAssociativeArray#remove(java.lang.Object)
	 */
	@Override
	public V remove(K key) {

		V value = null;
		Tree<K, V> tempTree = new Tree<>();

		if (containsKey(key)) {
			value = this.get(key);
			tempTree.setRoot(getNodeByKey(tree.getRoot(), key));
			putAllRecursive(tempTree.getRoot().getLeft());
			putAllRecursive(tempTree.getRoot().getRight());

		}
		tree.setCountNodes(tree.getCountNodes() - 1);
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

		doBiConsumer(tree.getRoot(), tree.getRoot().getLeft(), tree.getRoot()
				.getRight(), biCon);

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
	public <R> R map(BiFunction<K, V, R> biFunc) {

		R bla = null;

		return bla;

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
