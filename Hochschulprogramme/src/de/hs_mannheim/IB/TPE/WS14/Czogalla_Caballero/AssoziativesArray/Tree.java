/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;


/**
 * Binärbaum, der intern Knoten mit generischen Typen verwendet
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 *
 */
public class Tree<K,V> {
	
	private Node root;
	private int countNodes;
	
	public void setRoot(Node newRoot){
		this.root=newRoot;
	}
	
	public Tree(){
		
		root = null;
		countNodes = 0;
	}
	
	public int getcountNodes(){
		
		return countNodes;
	}
	/**
	 * neuer Knoten wird hinzugefügt
	 * @param nodeNew
	 */
	
	public void addNode(K key, V value){
			
		Node child = new Node(key, value);
		countNodes++;
		
		if(root == null){
			
			root = child;
			
		}else{
			
			sortNode(root, child);
			
		}
	}
	
	public Node getRoot(){
		
		return root;
	}
	
	
	
	public void clearTree(){
		
		root=null;
		countNodes = 0;
	}
		
	/**
	 * sortiert den neuen Knoten an die richtige Stelle im binären Baum ein
	 * @param parent
	 * @param child
	 */
	private void sortNode(Node parent, Node child){
		
		//überprüft den Hashwert des neuen Knoten und fügt ihn entsprechend links oder rechts ein
		
		//linker Kindknoten
		if(parent.hashCode() > child.hashCode()){
			
			//überprüft, ob der Kindknoten leer ist und fügt den neuen Knoten an dieser Stelle hinzu
			if(parent.getLeft() == null){
			
				parent.setLeft(child);
				
			}else{
				//Kindknoten war nicht leer, also werden die Kindknoten des aktuellen Kindknoten überprüft
				sortNode(parent.getLeft(),child);
			}
			
		//rechter Kindknoten	
		}else{
			
			
			if(parent.getRight() == null){
			
				parent.setRight(child);
				
			}else{
			
				sortNode(parent.getRight(), child);
				
			}
			
		
		}
	
	}
	
	
	
	class Node{
		
		private K key;
		private V value;
	
		private Node left;
		private Node right;

		
		public Node(K key, V value){
			
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			
		}
		
		public Node getLeft() {
			return left;
		}

		private void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		private void setRight(Node right) {
			this.right = right;
		}

		public void setValue(V value){
			
			this.value = value;
		}
		
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
		
	
		public V getValue(){
			
			return value;
		}
		
		public K getKey(){
			
			return key;
		}

		private Tree getOuterType() {
			return Tree.this;
		}
		
	}
	
	
	
}
