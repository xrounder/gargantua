/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 * @author Dennis
 *
 */
public class Tree {


	class Node{
		
		private String key;
		private int value;
		
		private Node left;
		private Node right;
	
		
		public Node(String key, Node node1st, Node node2nd){
			
			this.key = key;
			setNode(node1st, node2nd);
			
		}
		
		public Node(String key, Node node){
			
			this(key,node, null);
			
		}
		
		public Node(String key){
			
			this(key, null, null);
			
		}
		
		
		public void setNode(Node node){
		
			left = node;
			
		}
		
		public void setNode(Node node1st, Node node2nd){
			
			if((node1st != null && node2nd != null) && node1st.getValue() > node2nd.getValue()){
				
				setNode(node2nd,node1st);
			}
			
			left = node1st;
			right = node2nd;
		}

		
		
		
		public int getValue(){
			
			return value;
		}
		
		public String getKey(){
			
			return key;
		}
		
		
		
		
	}
	
	
	
}
