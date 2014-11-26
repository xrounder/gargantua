/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 * Binärbaum, der intern Knoten mit generischen Typen verwendet
 * 
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 * 
 */
public class Tree<K, V> {

	/**
	 * Attribute
	 */
	private Node root;
	private int countNodes;

	/**
	 * setzt root
	 * 
	 * @param newRoot
	 */
	public void setRoot(Node newRoot) {
		this.root = newRoot;
	}

	/**
	 * Konstruktor
	 * 
	 */
	public Tree() {

		root = null;
		countNodes = 0;
	}

	/**
	 * gibt countNodes zurück
	 * 
	 * @return countNodes
	 */
	public int getCountNodes() {

		return countNodes;
	}

	/**
	 * @summary setzt countNodes
	 * 
	 * @param number
	 * @returnType void
	 */
	public void setCountNodes(int number) {
		countNodes = number;
	}

	/**
	 * neuer Knoten wird hinzugefügt
	 * 
	 * @param nodeNew
	 */
	public void addNode(K key, V value) {

		Node child = new Node(key, value);
		countNodes++;

		if (root == null) {

			root = child;

		} else {

			sortNode(root, child);

		}
	}
	
	
	

	/**
	 * @summary gibt root zurück
	 * 
	 * @return root
	 * @returnType Node
	 */
	public Node getRoot() {

		return root;
	}

	/**
	 * @summary löscht dem Baum
	 * 
	 * @returnType void
	 */
	public void clearTree() {

		root = null;
		countNodes = 0;
	}

	/**
	 * sortiert den neuen Knoten an die richtige Stelle im binären Baum ein
	 * 
	 * @param parent
	 * @param child
	 */
	private void sortNode(Node parent, Node child) {

		// überprüft den Hashwert des neuen Knoten und fügt ihn entsprechend
		// links oder rechts ein

		// linker Kindknoten
		if (parent.hashCode() > child.hashCode()) {

			// überprüft, ob der Kindknoten leer ist und fügt den neuen Knoten
			// an dieser Stelle hinzu
			if (parent.getLeft() == null) {

				parent.setLeft(child);

			} else {
				// Kindknoten war nicht leer, also werden die Kindknoten des
				// aktuellen Kindknoten überprüft
				sortNode(parent.getLeft(), child);
			}

			// rechter Kindknoten
		} else {

			if (parent.getRight() == null) {

				parent.setRight(child);

			} else {

				sortNode(parent.getRight(), child);

			}

		}

	}

	/**
	 * @summary
	 * 
	 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
	 * @created 25.11.2014
	 * 
	 */
	public class Node {

		/**
		 * Attribute
		 */
		private K key;
		private V value;

		private Node left;
		private Node right;

		/**
		 * Konstruktor
		 * 
		 * @param key
		 * @param value
		 */
		public Node(K key, V value) {

			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;

		}

		/**
		 * @summary gibt left zurück
		 * 
		 * @return left
		 * @returnType Node
		 */
		public Node getLeft() {
			return left;
		}

		/**
		 * @summary setzt left
		 * 
		 * @param left
		 * @returnType void
		 */
		void setLeft(Node left) {
			this.left = left;
		}

		/**
		 * @summary gibt right zurück
		 * 
		 * @return right
		 * @returnType Node
		 */
		public Node getRight() {
			return right;
		}

		/**
		 * @summary setzt right
		 * 
		 * @param right
		 * @returnType void
		 */
		void setRight(Node right) {
			this.right = right;
		}

		/**
		 * @summary setzt value
		 * 
		 * @param value
		 * @returnType void
		 */
		public void setValue(V value) {

			this.value = value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (key == null) {
				if (other.key != null) {
					return false;
				}
			} else if (!key.equals(other.key)) {
				return false;
			}
			if (left == null) {
				if (other.left != null) {
					return false;
				}
			} else if (!left.equals(other.left)) {
				return false;
			}
			if (right == null) {
				if (other.right != null) {
					return false;
				}
			} else if (!right.equals(other.right)) {
				return false;
			}
			if (value == null) {
				if (other.value != null) {
					return false;
				}
			} else if (!value.equals(other.value)) {
				return false;
			}
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		/**
		 * @summary gibt value zurück
		 * 
		 * @return value
		 * @returnType V
		 */
		public V getValue() {

			return value;
		}

		/**
		 * @summary gibt key zurück
		 * 
		 * @return key
		 * @returnType K
		 */
		public K getKey() {

			return key;
		}

		/**
		 * @summary
		 * 
		 * @return
		 * @returnType Tree
		 */
		private Tree<K,V> getOuterType() {
			return Tree.this;
		}

	}

}
