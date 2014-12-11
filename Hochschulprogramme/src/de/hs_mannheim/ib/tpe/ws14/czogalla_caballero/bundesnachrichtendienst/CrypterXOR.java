/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;

/**
 * @author 1414163
 *
 */
public class CrypterXOR implements Crypter{

	private String key;
	
	public CrypterXOR(String key){
		this.key = key;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

}
