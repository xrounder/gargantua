/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.assoziativesArray;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;


/**
 * 
 * Interface f�r die Methoden eines Assoziativen Arrays
 * 
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 * 
 * @param <K>
 * @param <V>
 */
public interface IAssociativeArray<K, V> {

	/**
	 * @summary soll das assoziative Array leeren
	 *  
	 */
	public void clear();

	/**
	 * 
	 * @summary soll �berpr�fen, ob der �bergebene Wert im assoziativen Array
	 *          vorkommt
	 * 
	 * @param value
	 * @return boolean
	 */
	public boolean containsValue(V value);

	/**
	 * 
	 * @summary soll �berpr�fen, ob der �bergebene Schl�ssel im assoziativen
	 *          Array vorkommt 
	 * 
	 * @param key
	 * @return boolean
	 */
	public boolean containsKey(K key);

	/**
	 * 
	 * @summary soll den passenden Wert zum �bergebenen Schl�ssel zur uckgeben
	 * 
	 * @param key
	 * @return V
	 */
	public V get(K key);

	/**
	 * 
	 * @summary soll �berpr�fen, ob das assoziative Array leer ist
	 * 
	 * @return boolean
	 */
	public boolean isEmpty();

	/**
	 * 
	 * @summary soll den �bergebenen Schl�ssel und Wert im assoziativen Array
	 *          speichern
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value);

	/**
	 * 
	 * @summary soll alle Schl�ssel-Wert-Paare des �bergebenen assoziativen
	 *          Arrays zum aktuellen assoziativen Array hinzuf�gen
	 * 
	 * @param newArray
	 */
	public void putAll(AssociativeArray<K, V> newArray);

	/**
	 * 
	 * @summary soll das Schl�ssel-Wert-Paar des �bergebenen Schl�ssels aus dem
	 *          assoziativen Array entfernen und den Wert zur uckliefern
	 * 
	 * @param key
	 * @return V
	 */
	public V remove(K key);

	/**
	 * 
	 * @summary soll die Anzahl der Schl�ssel-Wert-Paare zur�ckgeben
	 * 
	 * @return int
	 */
	public int size();

	/**
	 * 
	 * @summary soll den Wert des �bergebenen Schl�ssels mit dem  ubergebenen
	 *          Wert aktualisieren
	 * 
	 * @param key
	 * @param value
	 */
	public void update(K key, V value);

	/**
	 * 
	 * @summary soll den �bergebenen BiConsumer f�r alle Schl ussel-Wert-Paare
	 *          des assoziativen Arrays ausf�hren
	 * 
	 * @param biCon
	 */
	public void forEach(BiConsumer<K, V> biCon);

	/**
	 * 
	 * @summary soll alle Schl�ssel-Wert-Paare des aktuellen assoziativen Arrays
	 *          zum �bergebenen assoziativen Array hinzuf�gen
	 * 
	 * @param newArray
	 */
	public void extractAll(AssociativeArray<K, V> newArray);

	/**
	 * 
	 * @param <R>
	 * @summary soll die �bergebene BiFunction f�r alle Schl ussel-Wert-Paare
	 *          des assoziativen Arrays ausf�hren und damit ein neues
	 *          assoziatives Array erzeugen, welches die ver anderten Werte auf
	 *          die alten Schl�ssel abbildet
	 * 
	 * 
	 */
	public AssociativeArray<K,V> map(BiFunction<K, V, V> biFunc);
}
