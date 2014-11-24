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

	
	Tree<K,V> tree;
	private boolean foundKey;
	private boolean foundValue;
	//private String saveData;
	
	public AssociativeArray(){
		
		this.tree = new Tree<K,V>();
		
	}
	
	//fertig
	@Override
	public void clear (){
		
		tree.clearTree();
		
	}
	
	
	
	

	//fertig
	private boolean searchValue(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild, V value){
		
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
	
	private Tree<K,V>.Node getNodeByKey(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild,  K key){
		
		boolean found =false;
		Tree<K,V>.Node foundNode = null;
		
		if(parent.getKey().equals(key)){
			
			foundNode = parent;
			return foundNode;
		
		}else{
			
			foundNode = null;
			if(leftChild != null){
				
				foundNode = getNodeByKey(leftChild, leftChild.getLeft(), leftChild.getRight(), key);
					
			}
				
			if(rightChild != null && foundNode.equals(null)){
					
				foundNode = getNodeByKey(rightChild, rightChild.getLeft(), rightChild.getRight(), key);
					
			}
			
			
		}
		
		return foundNode;
	}
	
	//fertig
	private boolean searchKey(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild,  K key){
		
		boolean found;
		
		if(parent.getKey().equals(key)){
		
			found = true;
		
		}else{
			
			found = false;
			
			if(leftChild != null){
				
				found = searchKey(leftChild, leftChild.getLeft(), leftChild.getRight(), key);
					
			}
				
			if(rightChild != null && !found){
					
				found = searchKey(rightChild, rightChild.getLeft(), rightChild.getRight(), key);
					
			}
			
		}
		
		return found;
		
	}
	//fertig
	private V getValueByKey(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild,  K key){
		
		V value;
		
		if(parent.getKey().equals(key)){
			
			value = parent.getValue();
			
		}else{
			
			value = null;
			
			if(leftChild != null){
				
				getValueByKey(leftChild, leftChild.getLeft(), leftChild.getRight(), key);
					
			}
				
			if(rightChild != null && value == null){
					
				getValueByKey(rightChild, rightChild.getLeft(), rightChild.getRight(), key);
					
			}
		}
		
		return value;
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
	private String nodeToString(Tree<K,V>.Node parent, Tree<K,V>.Node leftChild, Tree<K,V>.Node rightChild){
		
		String saveData = "";
		
		saveData += "{KEY="+parent.getKey()+", VALUE="+parent.getValue()+"}\n";
		
		if(leftChild != null){
			
			saveData += nodeToString(leftChild, leftChild.getLeft(), leftChild.getRight());
				
		}
			
		if(rightChild != null){
				
			saveData += nodeToString(rightChild, rightChild.getLeft(), rightChild.getRight());
				
		}
		
		return saveData;
		
	}
	

	//fertig
	@Override
	public boolean containsValue (V value){
		
		return searchValue(tree.getRoot(), tree.getRoot().getLeft(),tree.getRoot().getRight(),value);
		
	}
	//fertig
	@Override
	public boolean containsKey(K key){
		
		return searchKey(tree.getRoot(), tree.getRoot().getLeft(),tree.getRoot().getRight(),key);
	}
	//fertig
	@Override
	public V get (K key){
		
		return getValueByKey(tree.getRoot(), tree.getRoot().getLeft(),tree.getRoot().getRight(),key);
	}
	//fertig
	@Override
	public boolean isEmpty (){
		
		if(tree.getRoot() == null){
			
			return true;
		}else{
		
		return false;
		
		}
	}
	//fertig
	@Override
	public void put (K key, V value){
		
		tree.addNode(key, value);
		
	}
	
	private void putAllRecursive(Tree<K,V>.Node parent){
	
		if(parent==null){
			
		}else if(parent.getLeft()==null){
			put(parent.getRight().getKey(), parent.getRight().getValue());
			putAllRecursive(parent.getRight());
		
		}else if(parent.getRight()==null){
			put(parent.getLeft().getKey(), parent.getLeft().getValue());	
			putAllRecursive(parent.getLeft());
		}
	}
	
	@Override
	public void putAll (AssociativeArray<K,V> newArray){
		
		Tree<K,V>.Node root = newArray.tree.getRoot();
		
		putAllRecursive(root);
	}
	
	@Override
	public V remove (K key){
		
		V value = null;
		Tree<K,V> tempTree = new Tree<>();
		
		if (containsKey(key)){
			value = get(key);
			tempTree.setRoot( getNodeByKey(tree.getRoot(), tree.getRoot().getLeft(), tree.getRoot().getRight(), key) );
			putAllRecursive(tempTree.getRoot().getLeft());
			putAllRecursive(tempTree.getRoot().getRight());
			
		}
		return value;
	}
	
	//fertig
	@Override
	public int size (){
		
		return tree.getcountNodes();
	}
	//fertig
	@Override
	public void update (K key, V value){
		
		updateNode(tree.getRoot(), tree.getRoot().getLeft(), tree.getRoot().getRight(),key, value);
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
	
	
	
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((tree == null) ? 0 : tree.hashCode());
	result = prime * result + (foundKey ? 1231 : 1237);
	result = prime * result + (foundValue ? 1231 : 1237);
	return result;
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
	AssociativeArray other = (AssociativeArray) obj;
	if (tree == null) {
		if (other.tree != null) {
			return false;
		}
	} else if (!tree.equals(other.tree)) {
		return false;
	}
	if (foundKey != other.foundKey) {
		return false;
	}
	if (foundValue != other.foundValue) {
		return false;
	}
	return true;
}


	
	//fertig
	@Override
	public String toString() {
	
		return nodeToString(tree.getRoot(), tree.getRoot().getLeft(), tree.getRoot().getRight());
	}

	
	
}
