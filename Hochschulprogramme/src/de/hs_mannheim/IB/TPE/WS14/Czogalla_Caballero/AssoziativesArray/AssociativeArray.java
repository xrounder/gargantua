/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 * @author Dennis
 *
 */
public class AssociativeArray implements IAssociativeArray {

	private Tree associativeArray;
	
	public AssociativeArray(int size){
		
		associativeArray = new Tree();
	}
	
	
	public void clear (){};
	public boolean containsValue (){
		
		return false;
	};
	public boolean containsKey (){
		
		return false;
	};
	public int get (String key){
		
		return 0;
	};
	public boolean isEmpty (){
		
		return false;
	};
	public void put (String key, int value){};
	public void putAll (){};
	public int remove (String key){
		
		return 0;
	};
	public int size (){
		
		return 0;
	};
	public void update (String key, int value){};
	public void forEach (){};
	public void extractAll(){};
	public void map (){};
	
	
	
}
