package de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.Devisenkonto;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit-Test zur Klasse Konto
 * 
 * @see de.hs_mannheim.IB.TPE.WS14.Czogalla_Caballero.Devisenkonto.Konto
 * 
 * @author Miguel Caballero (Matr.Nr.1414163), Dennis Czogalla (Matr.Nr.1410116)
 * 
 * @date 15.10.2014
 */
public class KontoTest {

	Waehrungen testWaehrungen = new Waehrungen();

	Konto kundenKonto = new Konto(testWaehrungen.usDollar, "TestKunde");

	Betrag[] zielKontostand = new Betrag[1000];

	Betrag betrag0 = new Betrag(testWaehrungen.usDollar, 52.33);
	Betrag betrag1 = new Betrag(testWaehrungen.usDollar, 12.42);
	Betrag betrag2 = new Betrag(testWaehrungen.usDollar, -32.11);
	Betrag betrag3 = new Betrag(testWaehrungen.usDollar, 22);
	Betrag zielSaldo = new Betrag(testWaehrungen.usDollar, 54.64);
	Betrag zielGebuehren = new Betrag(testWaehrungen.usDollar, 0.08);

	/**
	 * erstellt eine Testumgebung
	 */
	public void initialisieren() {

		zielKontostand[0] = betrag0;
		zielKontostand[1] = betrag1;
		zielKontostand[2] = betrag2;
		zielKontostand[3] = betrag3;

		kundenKonto.buche(betrag0);
		kundenKonto.buche(betrag1);
		kundenKonto.buche(betrag2);
		kundenKonto.buche(betrag3);

	}

	/**
	 * testet die Methode buche
	 */
	@Test
	public void testBuche() {

		initialisieren();

		assertArrayEquals(zielKontostand, kundenKonto.getKontostand());

	}

	/**
	 * testet die Methode saldo
	 */
	@Test
	public void testSaldo() {

		initialisieren();

		assertEquals(zielSaldo, kundenKonto.saldo());
	}

	/**
	 * testet die Methode gebuehren
	 */
	@Test
	public void testGebuehren() {

		initialisieren();

		kundenKonto.gebuehren(1.5);

		assertEquals(zielGebuehren, kundenKonto.getKontostand()[4]);
	}

	/**
	 * testet die Methode toString
	 */
	@Test
	public void TestToString() {

		initialisieren();

		// Zielstring
		String zielAusgabe = "INTERNATIONAL LIES AND DECEPTION BANK COROPORATION \n\n";
		zielAusgabe += "Kontoauszug von: TestKunde\n----------\n";
		zielAusgabe += "52,33 $\n12,42 $\n-32,11 $\n22,00 $\n";
		zielAusgabe += "----------\nSaldo: 54,64 $";

		// Ausführen der toString() Methode
		String Testausgabe = "INTERNATIONAL LIES AND DECEPTION BANK COROPORATION \n\n";

		Testausgabe += "Kontoauszug von: " + kundenKonto.getInhaber()
				+ "\n----------\n";

		for (int index = 0; kundenKonto.getKontostand()[index] != null
				&& index < kundenKonto.getKontostand().length; index++) {

			Testausgabe += kundenKonto.getKontostand()[index].toString() + "\n";
		}

		Testausgabe += "----------\n" + "Saldo: "
				+ kundenKonto.saldo().toString();

		assertEquals(zielAusgabe, Testausgabe);

	}

}
