/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions;

/**
 * @summary
 *
 * @author Miguel Caballero 1414163, Dennis Czogalla 1410116
 * @created 17.12.2014
 *
 */
@SuppressWarnings("serial")
public class CrypterException extends Throwable{

	private static final long serialVersionUID = 1L;
	
	public CrypterException(){
		super();
	}
	
	public CrypterException(String  message){
		super(message);
	}
	
}
