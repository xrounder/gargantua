/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.assoziativesArray;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;


/**
 * 
 * Interface für die Methoden eines Assoziativen Arrays
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
	 * @summary soll überprüfen, ob der übergebene Wert im assoziativen Array
	 *          vorkommt
	 * 
	 * @param value
	 * @return boolean
	 */
	public boolean containsValue(V value);

	/**
	 * 
	 * @summary soll überprüfen, ob der übergebene Schlüssel im assoziativen
	 *          Array vorkommt 
	 * 
	 * @param key
	 * @return boolean
	 */
	public boolean containsKey(K key);

	/**
	 * 
	 * @summary soll den passenden Wert zum übergebenen Schlüssel zur uckgeben
	 * 
	 * @param key
	 * @return V
	 */
	public V get(K key);

	/**
	 * 
	 * @summary soll überprüfen, ob das assoziative Array leer ist
	 * 
	 * @return boolean
	 */
	public boolean isEmpty();

	/**
	 * 
	 * @summary soll den übergebenen Schlüssel und Wert im assoziativen Array
	 *          speichern
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value);

	/**
	 * 
	 * @summary soll alle Schlüssel-Wert-Paare des übergebenen assoziativen
	 *          Arrays zum aktuellen assoziativen Array hinzufügen
	 * 
	 * @param newArray
	 */
	public void putAll(AssociativeArray<K, V> newArray);

	/**
	 * 
	 * @summary soll das Schlüssel-Wert-Paar des übergebenen Schlüssels aus dem
	 *          assoziativen Array entfernen und den Wert zur uckliefern
	 * 
	 * @param key
	 * @return V
	 */
	public V remove(K key);

	/**
	 * 
	 * @summary soll die Anzahl der Schlüssel-Wert-Paare zurückgeben
	 * 
	 * @return int
	 */
	public int size();

	/**
	 * 
	 * @summary soll den Wert des übergebenen Schlüssels mit dem  ubergebenen
	 *          Wert aktualisieren
	 * 
	 * @param key
	 * @param value
	 */
	public void update(K key, V value);

	/**
	 * 
	 * @summary soll den übergebenen BiConsumer für alle Schl ussel-Wert-Paare
	 *          des assoziativen Arrays ausführen
	 * 
	 * @param biCon
	 */
	public void forEach(BiConsumer<K, V> biCon);

	/**
	 * 
	 * @summary soll alle Schlüssel-Wert-Paare des aktuellen assoziativen Arrays
	 *          zum übergebenen assoziativen Array hinzufügen
	 * 
	 * @param newArray
	 */
	public void extractAll(AssociativeArray<K, V> newArray);

	/**
	 * 
	 * @param <R>
	 * @summary soll die übergebene BiFunction für alle Schl ussel-Wert-Paare
	 *          des assoziativen Arrays ausführen und damit ein neues
	 *          assoziatives Array erzeugen, welches die ver anderten Werte auf
	 *          die alten Schlüssel abbildet
	 * 
	 * 
	 */
	public AssociativeArray<K,V> map(BiFunction<K, V, V> biFunc);
}
