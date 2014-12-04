/**
 * 
 */
package de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.devisenkonto;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * JUnit-Test zur Klasse Waehrung
 * 
 * @see de.hs_mannheim.ib.tpe.ws14.czogalla_caballero.Devisenkonto.Waehrung
 * 
 * 
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 * 
 * @date 15.10.2014
 */
public class WaehrungTest {

	Waehrungen testwaehrungen = new Waehrungen();

	Betrag betrag = new Betrag(testwaehrungen.usDollar, 52.33);
	Betrag zielbetrag = new Betrag(testwaehrungen.euro, 41.23);

	Betrag betrag1 = new Betrag(testwaehrungen.euro, 12.42);
	Betrag zielbetrag1 = new Betrag(testwaehrungen.schweizerFranken, 14.99);

	Betrag betrag2 = new Betrag(testwaehrungen.rubel, -32.11);
	Betrag zielbetrag2 = new Betrag(testwaehrungen.yen, -89.97);

	Betrag betrag3 = new Betrag(testwaehrungen.schweizerFranken, 0.01);
	Betrag zielbetrag3 = new Betrag(testwaehrungen.rubel, 0.41);

	/**
	 * testet die Methode umrechnen
	 */
	@Test
	public void testUmrechnen() {
		assertEquals(
				zielbetrag.getBetrag(),
				betrag.getWaehrung().umrechnen(betrag.getBetrag(),
						zielbetrag.getWaehrung()));
		assertEquals(
				zielbetrag1.getBetrag(),
				betrag1.getWaehrung().umrechnen(betrag1.getBetrag(),
						zielbetrag1.getWaehrung()));
		assertEquals(
				zielbetrag2.getBetrag(),
				betrag2.getWaehrung().umrechnen(betrag2.getBetrag(),
						zielbetrag2.getWaehrung()));
		assertEquals(
				zielbetrag3.getBetrag(),
				betrag3.getWaehrung().umrechnen(betrag3.getBetrag(),
						zielbetrag3.getWaehrung()));

	}

}
