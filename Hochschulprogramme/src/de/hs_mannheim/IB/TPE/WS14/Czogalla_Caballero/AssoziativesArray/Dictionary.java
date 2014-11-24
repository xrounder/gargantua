/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 *
 */
public class Dictionary<K,V> extends AssociativeArray<String, String>{
	
	public String[] keys(){
		String[] keys = new String[size()];
		
		keys = fillWithKeys(keys, getTree().getRoot(), 0);
		
		return keys;
	}
	
	private String[] fillWithKeys(String[] keys, Tree<String,String>.Node parent, int keyIndex){
			
		if(parent==null && keyIndex < keys.length){
			
		}else if(parent.getLeft()==null && keyIndex < keys.length){
			
			keys[keyIndex] = parent.getRight().getKey().toString();
			fillWithKeys(keys, parent.getRight(), keyIndex++);
		
		}else if(parent.getRight()==null && keyIndex < keys.length){
			
			keys[keyIndex] = parent.getRight().getKey().toString();
			fillWithKeys(keys, parent.getLeft(), keyIndex++);
		}
		return keys;
	}
	
	public String[] values(){
		String[] values = new String[size()];
		
		values = fillWithValues(values, getTree().getRoot(), 0);
		
		return values;
	}
	
	private String[] fillWithValues(String[] values, Tree<String,String>.Node parent, int valueIndex){
			
		if(parent==null && valueIndex < values.length){
			
		}else if(parent.getLeft()==null && valueIndex < values.length){
			
			values[valueIndex] = parent.getRight().getKey().toString();
			fillWithValues(values, parent.getRight(), valueIndex++);
		
		}else if(parent.getRight()==null && valueIndex < values.length){
			
			values[valueIndex] = parent.getRight().getKey().toString();
			fillWithValues(values, parent.getLeft(), valueIndex++);
		}
		return values;
	}
	
}
