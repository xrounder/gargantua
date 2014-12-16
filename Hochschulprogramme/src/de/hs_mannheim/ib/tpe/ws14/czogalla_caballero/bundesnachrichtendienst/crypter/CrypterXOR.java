/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypter;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterBasis;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

/**
 * @author 1414163
 *
 */
public class CrypterXOR extends CrypterBasis implements Crypter{

	private String key;
	private final String ALPHABET = "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_";

	public CrypterXOR(String key){
		super(key);
	}
	
	public String getKey(){
		return this.key;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	//wird �berschrieben, da bei XOR die zus�tzlichen Zeichen [ @ \ ] ^ _ erlaubt sind und nicht gel�scht werden sollen
	@Override
	protected String removeChars(String text){
		
		text = text.trim();
		text = text.toUpperCase();
		String removed = "";
		
		for(int pos = 0; pos < text.length(); pos++){
			
			for(int posAlph = 0; posAlph < this.ALPHABET.length(); posAlph++){
				
				if(text.charAt(pos) == this.ALPHABET.charAt(posAlph)){
					
					removed += text.charAt(pos);
					
				}
				
			}
			
		}
		
		return removed;
	}
	private String xor(String message){
		
		//entfernt alle ung�ltigen Zeichen
		message = removeChars(message);
		
		String crypted = "";
		
		//falls Schl�ssel k�rzer als Nachricht, dann wiederhole Schl�ssel
		if(message.length() > key.length()){
			
			int missing = message.length() - key.length();
			
			for(int pos = 0; pos < missing; pos++){
				
				key += key.charAt(pos); 
			}
			
		}
		
		for(int pos = 0; pos < message.length(); pos++){
			
			int keyValue = 0;
			int textValue = 0;
			
			for(int posKey = 0; posKey < ALPHABET.length(); posKey++){
				
				//finde heraus, welche Stelle der Buchstabe von message im Alphabet hat
				if(message.charAt(pos) == ALPHABET.charAt(posKey)){
					
					textValue = (posKey);
				}
				
				//finde heraus, welche Stelle der Buchstabe von Key im Alphabet hat
				if(key.charAt(pos) == ALPHABET.charAt(posKey)){
					
					keyValue = (posKey);
				}
					
			}
			
			//f�ge den verschl�sselten Buchstaben hinzu
			crypted += ALPHABET.charAt(textValue ^ keyValue);
		}
		
		return crypted;
	}
	
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
		return xor(message);
	
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return xor(cypherText);
	}


}
