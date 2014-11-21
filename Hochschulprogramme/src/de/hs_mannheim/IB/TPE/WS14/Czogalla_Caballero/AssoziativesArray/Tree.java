/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

import java.lang.reflect.GenericDeclaration;

import org.omg.CORBA.portable.ValueBase;

/**
 * Binärbaum, der intern Knoten mit generischen Typen verwendet
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 *
 */
public class Tree {
	
	private Node headNode;
	
	public Tree(){
		
		headNode = null;
	}
	
	public void addNode(Node node){
				
	}
	

	public class Node<K,V>{
		
		private K key;
		private V value;
		private int hash;
		
		private Node left;
		private Node right;

		
		public Node(K key, V value){
			
			this.key = key;
			this.value = value;
			
		}

		
		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getHash(){
			
			return hash;
		}
		
		public V getValue(){
			
			return value;
		}
		
		public K getKey(){
			
			return key;
		}
		
	}
	
	
	
}
