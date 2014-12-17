package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.junitTests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.IterableCrypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.IterableDecrypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.Crypter;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CrypterFactory;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.crypterframework.CryptionMethod;
import de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.bundesnachrichtendienst.exceptions.IllegalKeyException;
/**
 * 
 * 
 * @author 1414163 Miguel Caballero, 1410116 Dennis Czogalla
 *
 */
public class IterableCrypterTest {

	@Test
	public void IterableCrypterDemoTest() throws IllegalKeyException{
		
		Crypter rev = CrypterFactory.createCrypter("U", CryptionMethod.REVERSE);
		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL", CryptionMethod.XOR);
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		IterableCrypter iterableCrypter = new IterableCrypter(new IterableCrypter(liste, xor), rev);
		
		for (String cypherText : iterableCrypter) {
		
			System.out.println(cypherText);
		
		}
		
	}
	
	@Test
	public void IterableDecrypterTest() throws IllegalKeyException{
		
		Crypter rev = CrypterFactory.createCrypter("", CryptionMethod.REVERSE);
		Crypter xor = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CryptionMethod.XOR);
		Crypter sub = CrypterFactory.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", CryptionMethod.SUBSTITUTION);
		Crypter caes = CrypterFactory.createCrypter("L", CryptionMethod.CAESAR);
		
		List<String> liste = Arrays.asList("QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X");
		IterableDecrypter iterableDecrypter = new IterableDecrypter(new IterableDecrypter(new IterableDecrypter(new IterableDecrypter(liste, xor), rev), caes), sub);
		
		for (String cypherText : iterableDecrypter) {
			
			assertEquals("JETZTXISTXTPEXAUCHXBALDXGESCHAFFTXEINXFROHESXFESTXWUENSCHEXICH", cypherText);
		
		}
	}
	
	@Test
	public void IterableEncrypterTest() throws IllegalKeyException{
		
		Crypter rev = CrypterFactory.createCrypter("", CryptionMethod.REVERSE);
		Crypter xor = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CryptionMethod.XOR);
		Crypter sub = CrypterFactory.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", CryptionMethod.SUBSTITUTION);
		Crypter caes = CrypterFactory.createCrypter("L", CryptionMethod.CAESAR);
		
		List<String> liste = Arrays.asList("JETZTXISTXTPEXAUCHXBALDXGESCHAFFTXEINXFROHESXFESTXWUENSCHEXICH");
		IterableCrypter iterableCrypter = new IterableCrypter(new IterableCrypter(new IterableCrypter(new IterableCrypter(liste, sub), caes), rev), xor);
		
		for (String cypherText : iterableCrypter) {
			
			assertEquals("QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X", cypherText);
		
		}
		
	}
	
}
