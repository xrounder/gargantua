/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

import java.lang.reflect.GenericDeclaration;

import org.omg.CORBA.portable.ValueBase;

/**
 * Bin�rbaum, der intern Knoten mit generischen Typen verwendet
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 *
 */
public class Tree {
	
	private Node headNode;
	
	public Tree(){
		
		headNode = null;
	}
	
	/**
	 * neuer Knoten wird hinzugef�gt
	 * @param nodeNew
	 */
	public void addNode(Node nodeNew){
			
		if(headNode == null){
			
			headNode = nodeNew;
			
		}else{
			
			sortNode(headNode, nodeNew);
			
		}
	}
	
	
	/**
	 * sortiert den neuen Knoten an die richtige Stelle im bin�ren Baum ein
	 * @param nodeEnd
	 * @param nodeNew
	 */
	private void sortNode(Node nodeEnd, Node nodeNew){
		
		//�berpr�ft den Hashwert des neuen Knoten und f�gt ihn entsprechend links oder rechts ein
		
		//linker Kindknoten
		if(nodeEnd.getHash() > nodeNew.getHash()){
			
			//�berpr�ft, ob der Kindknoten leer ist und f�gt den neuen Knoten an dieser Stelle hinzu
			if(nodeEnd.getLeft() == null){
			
				nodeEnd.setLeft(nodeNew);
				
			}else{
				//Kindknoten war nicht leer, also werden die Kindknoten des aktuellen Kindknoten �berpr�ft
				sortNode(nodeEnd.getLeft(),nodeNew);
			}
			
		//rechter Kindknoten	
		}else{
			
			
			if(nodeEnd.getRight() == null){
			
				nodeEnd.setRight(nodeNew);
				
			}else{
			
				sortNode(nodeEnd.getRight(), nodeNew);
				
			}
			
		
		}
	
	}
	
	

	class Node<K,V>{
		
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
