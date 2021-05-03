package model;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GameTest {
	
	@Test(timeout = 5000)
	public void GameTestCreateGamblersNames() {
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Bank bank = new Bank();
		Game game = new Game();
		String[] Names = {"Sol", "Victor", "Raks"};
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
		String[] Names = {"Sol"};
		List<Gambler> gamblers = game.CreateGamblers(Names, bank);
		assertNotSame("Raks não foi criada",gamblers.get(0).Name, "Raks");
	}
	

}
