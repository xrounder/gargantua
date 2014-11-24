/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;


/**
 * Assoziatives Array, das intern einen Binärbaum verwendet
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 *
 */
public class AssociativeArray<K,V> implements IAssociativeArray<K,V> {

	
	Tree<K,V> baum;
	private boolean foundKey;
	private boolean foundValue;
	private K key;
	private V value;
	private String saveData;
	
	public AssociativeArray(){
		
		this.baum = new Tree<K,V>();
		this.foundKey = false;
		this.foundValue = false;
		this.saveData = "";
	}
	
	//fertig
	@Override
	public void clear (){
		
		baum.clearTree();
		
	}
	
	
	
	
	
	
	public boolean searchValue(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild, V value){
		
		boolean found;
		
		if(parent.getValue().equals(value)){
			
			found = true;
		
		}else{
			
			found = false;
	 		
			if(leftChild != null){
			
				found = searchValue(leftChild, leftChild.getLeft(), leftChild.getRight(), value);
				
			}
			
			if(rightChild != null && !found){
				
				found = searchValue(rightChild, rightChild.getLeft(), rightChild.getRight(), value);
			}
		
		}
		
		return found;
	}
	
	
	
	
	
	
	//fertig
	/*private void searchValue(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild, V value){
		
		
		if(parent.getValue().equals(value)){
			
			foundValue = true;
	
		}
		
		if(leftChild != null){
			
			searchValue(leftChild, leftChild.getLeft(), leftChild.getRight(), value);
			
		}
		
		if(rightChild != null){
			
			searchValue(rightChild, rightChild.getLeft(), rightChild.getRight(), value);
		}
		
		
		
	}*/
	//fertig
	private void searchKey(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild,  K key){
		
		if(parent.getKey().equals(key)){
		
			foundKey = true;
		
		}
			
		if(leftChild != null){
			
			searchKey(leftChild, leftChild.getLeft(), leftChild.getRight(), key);
				
		}
			
		if(rightChild != null){
				
			searchKey(rightChild, rightChild.getLeft(), rightChild.getRight(), key);
				
		}
		
	}
	//fertig
	private void getValueByKey(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild,  K key){
		
		if(parent.getKey().equals(key)){
			System.out.println("GEFUNDEN");
			this.value = parent.getValue();
		}
			
		if(leftChild != null){
			
			getValueByKey(leftChild, leftChild.getLeft(), leftChild.getRight(), key);
				
		}
			
		if(rightChild != null){
				
			getValueByKey(rightChild, rightChild.getLeft(), rightChild.getRight(), key);
				
		}
	}
	//fertig
	private void updateNode(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild, K key, V value){
		
		if(parent.getKey().equals(key)){
		
			parent.setValue(value);
		}
			
		if(leftChild != null){
			
			updateNode(leftChild, leftChild.getLeft(), leftChild.getRight(), key,value);
				
		}
			
		if(rightChild != null){
				
			updateNode(rightChild, rightChild.getLeft(), rightChild.getRight(), key,value);
				
		}
		
	}
	//fertig
	private void nodeToString(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild){
		
		saveData += "{KEY="+parent.getKey()+", VALUE="+parent.getValue()+"}\n";
		
		if(leftChild != null){
			
			nodeToString(leftChild, leftChild.getLeft(), leftChild.getRight());
				
		}
			
		if(rightChild != null){
				
			nodeToString(rightChild, rightChild.getLeft(), rightChild.getRight());
				
		}
		
		
	}
	
	/*
	private Node searchNode(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild){
		
		Node node = null;
		
		if(leftChild != null){
			
			searchNode(leftChild, leftChild.getLeft(), leftChild.getRight());
			continue;	
		}
			
		if(rightChild != null){
				
			searchNode(rightChild, rightChild.getLeft(), rightChild.getRight());
				
		}
		
		
		return node;
	}
	
	private Node searchNode(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild, K key){
			
			
		}
	
	private Node searchNode(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild, K key, V value){
		
		
	}
	
	
	private void removeNode()
	*/
	//fertig
	@Override
	public boolean containsValue (V value){
		
		foundValue = false;
		searchValue(baum.getRoot(), baum.getRoot().getLeft(),baum.getRoot().getRight(),value);
		return foundValue;
		
	}
	//fertig
	@Override
	public boolean containsKey(K key){
		
		foundKey = false;
		searchKey(baum.getRoot(), baum.getRoot().getLeft(),baum.getRoot().getRight(),key);
		return foundKey;
	}
	//fertig
	@Override
	public V get (K key){
		
		//this.value = null;
		getValueByKey(baum.getRoot(), baum.getRoot().getLeft(),baum.getRoot().getRight(),key);
		
		return this.value;
	}
	//fertig
	@Override
	public boolean isEmpty (){
		
		if(baum.getRoot() == null){
			
			return true;
		}else{
		
		return false;
		
		}
	}
	//fertig
	@Override
	public void put (K key, V value){
		
		baum.addNode(key, value);
		
	}
	
	
	
	@Override
	public void putAll (){
		
	}
	@Override
	public V remove (K key){
		
		return value;
	}
	
	//fertig
	@Override
	public int size (){
		
		return baum.getcountNodes();
	}
	//fertig
	@Override
	public void update (K key, V value){
		
		updateNode(baum.getRoot(), baum.getRoot().getLeft(), baum.getRoot().getRight(),key, value);
	}
	@Override
	public void forEach (){
		
	}
	@Override
	public void extractAll(){
		
	}
	@Override
	public void map (){
		
	}
	//fertig
	@Override
	public String toString() {
	
		saveData = "";
		nodeToString(baum.getRoot(), baum.getRoot().getLeft(), baum.getRoot().getRight());
		
		return saveData;
	}

	
	
}
