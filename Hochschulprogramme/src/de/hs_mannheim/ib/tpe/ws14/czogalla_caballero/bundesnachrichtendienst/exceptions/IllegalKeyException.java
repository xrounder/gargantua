/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions;

/**
 * @author 1414163
 *
 */
@SuppressWarnings("serial")
public class IllegalKeyException extends CrypterException {

	public IllegalKeyException(){
		super();
	}
	
	public IllegalKeyException(String message){
		super(message);
	}
}
