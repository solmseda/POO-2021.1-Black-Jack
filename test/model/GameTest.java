// Raquel Olhobetchi Ferreira da Silva
// Sol Castilho Ara�jo de Moraes S�da
// Victor Nielsen Ribeirete

package model;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameTest {
	
	@Test(timeout = 5000)
	public void GameTestCreateGamblersNames() {
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Bank bank = new Bank();
		Game game = new Game();
		ArrayList<String> Names =new ArrayList<String>();
		Names.add("Sol");
		Names.add("Victor");
		Names.add("Raks");
		List<Gambler> gamblers = game.CreateGamblers(Names, bank);
		assertEquals("Sol foi criado",gamblers.get(0).Name, "Sol");
		assertEquals("Victor foi criado",gamblers.get(1).Name, "Victor");
		assertEquals("Raks foi criada",gamblers.get(2).Name, "Raks");
	}

	
	@Test(timeout = 5000)
	public void GameTestCreateGamblersNamesError() {
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Bank bank = new Bank();
		Game game = new Game();
		ArrayList<String> Names = new ArrayList<String>();
		Names.add("Sol");
		List<Gambler> gamblers = game.CreateGamblers(Names, bank);
		assertNotSame("Raks n�o foi criada",gamblers.get(0).Name, "Raks");
	}
	

}
