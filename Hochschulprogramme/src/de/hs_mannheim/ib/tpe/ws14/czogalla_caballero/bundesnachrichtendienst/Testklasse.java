package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CryptionMethod;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.CrypterException;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;

public class Testklasse {

	
	public static void main(String[] args) throws CrypterException {


	
		Crypter xor = CrypterFactory.createCrypter("TPERULES",CryptionMethod.XOR);
		Crypter rev = CrypterFactory.createCrypter("abcdefg",CryptionMethod.REVERSE);
		Crypter sub = CrypterFactory.createCrypter("UFLPWDRASJMCONQYBVTEXHZKGI", CryptionMethod.SUBSTITUTION);
		Crypter caes = CrypterFactory.createCrypter("C", CryptionMethod.CAESAR);
		
		System.out.println(rev.encrypt("asc12 VAS"));
		System.out.println(sub.encrypt("WIKIPEDIAISTINFORMATIV"));
		System.out.println(xor.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		System.out.println(caes.encrypt("CAESAR"));
		
		/*
		Crypter caesar = CrypterFactory.createCrypter("U", CryptionMethod.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL", CryptionMethod.XOR);
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		IterableCrypter iterableCrypter = new IterableCrypter(
		new IterableCrypter(liste, caesar),
		xor);
		for (String cypherText : iterableCrypter) {
		System.out.println(cypherText);
		}*/
	}

}