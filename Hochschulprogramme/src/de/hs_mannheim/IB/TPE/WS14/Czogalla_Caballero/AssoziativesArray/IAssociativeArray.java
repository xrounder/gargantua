/**
 * 
 */
package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.AssoziativesArray;

/**
 *
 * Interface für die Methoden eines Assoziativen Arrays
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 *
 */
public interface IAssociativeArray {

	public void clear ();
	public boolean containsValue ();
	public boolean containsKey ();
	public int get (String key);
	public boolean isEmpty ();
	public void put (String key, int value);
	public void putAll ();
	public int remove (String key);
	public int size ();
	public void update (String key, int value);
	public void forEach ();
	public void extractAll();
	public void map ();
}
