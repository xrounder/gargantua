/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 * Assoziatives Array, das intern einen Binärbaum verwendet
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 *
 */
public class AssociativeArray<K,V> implements IAssociativeArray {

	private Tree<K,V> baum;

	public AssociativeArray(){
		this.baum = new Tree<>();
	
		
	}
		
	public void clear (){
		
		baum.setRoot(null);
		
	}
	
	public boolean containsValue (V value){
		
		if(baum.getRoot().equals(value)){
			return true;
		}
		if()
		
		
	}
	
	
	
	
	
	public boolean containsKey (V value){
		
		if(baum.getRoot().getValue() == value){
			
			return true;
		
		}else{
			
			
		}
		
		
		return false;
	}
	
	public int get (String key){
		
		return 0;
	}
	
	public boolean isEmpty (){
		
		return false;
	}
	
	public void put (String key, int value){
		
	}
	
	public void putAll (){
		
	}
	
	public int remove (String key){
		
		return 0;
	}
	
	public int size (){
		
		return 0;
	}

	public void update (String key, int value){
		
	}
	
	public void forEach (){
		
	}
	
	public void extractAll(){
		
	}
	
	public void map (){
		
	}
	
	@Override
	public String toString() {
	
		
		
		return super.toString();
	}

	
	
}
