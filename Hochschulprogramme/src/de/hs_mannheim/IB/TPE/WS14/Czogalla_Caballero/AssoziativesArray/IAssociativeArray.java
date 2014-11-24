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
public interface IAssociativeArray<K, V> {

	public void clear ();
	public boolean containsValue (V value);
	public boolean containsKey (K key);
	public V get (K key);
	public boolean isEmpty ();
	public void put (K key, V value);
	public void putAll ();
	public int remove (K key);
	public int size ();
	public void update (K key, V value);
	public void forEach ();
	public void extractAll();
	public void map ();
}
