package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import java.util.EnumSet;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CryptionMethod;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;

public class Testklasse {

	
	public static void main(String[] args) throws CrypterException {


	
		Crypter xor = CrypterFactory.createCrypter("TPERULES",CryptionMethod.XOR);
		
		Crypter rev = CrypterFactory.createCrypter("abcdefg",CryptionMethod.REVERSE);
		
		System.out.println(rev.encrypt("asc12 VAS"));
		
		System.out.println(xor.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	}

}
