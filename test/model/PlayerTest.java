// Raquel Olhobetchi Ferreira da Silva
// Sol Castilho Araújo de Moraes Sêda
// Victor Nielsen Ribeirete

package model;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerTest {

	@Test(timeout=5000)
	public void HandValueTest() {
		Player player= new Player();
		player.hand = new ArrayList<Card>();
		Card card1 = new Card();
		card1.valor=1;
		card1.Name="1";
		card1.naipe = "Copas";
		Card card2 = new Card();
		card2.valor=5;
		card2.Name="5";
		card2.naipe = "Copas";
		player.hand.add( card1);
		player.hand.add(card2);
		assertTrue("Soma das cartas é diferente de 6",player.HandValue() == 6);

	}
	@Test(timeout=5000)
	public void HandValueTestERROR() {
		Player player= new Player();
		player.hand = new ArrayList<Card>();
		Card card1 = new Card();
		card1.valor=1;
		card1.Name="1";
		card1.naipe = "Copas";
		player.hand.add(card1);
		player.hand.add(card1);
		assertFalse("Soma das cartas é diferente de 6",player.HandValue() == 6);

	}
	
	@Test(timeout=5000)
	public void BustedTest() {
		Deck deck=new Deck();
		Player player= new Player();
		player.hand = new ArrayList<Card>();
		Card card1 = new Card();
		card1.valor=1;
		card1.Name="1";
		card1.naipe = "Copas";
		Card card2 = new Card();
		card2.valor=5;
		card2.Name="5";
		card2.naipe = "Copas";
		player.hand.add(card1);
		player.hand.add(card2);
		
		assertTrue("A mão não queimou com menos de 21",!player.Busted());
	}
	@Test(timeout=5000)
	public void BustedTestERROR() {
		Player player= new Player();
		player.hand = new ArrayList<Card>();
		Card card1 = new Card();
		card1.valor=10;
		card1.Name="Reis";
		card1.naipe = "Copas";
		player.hand.add(card1);
		player.hand.add(card1);
		player.hand.add(card1);
		
		assertTrue("a mão queimou com mais de 21",player.Busted());
	}
	
	@Test(timeout = 5000)
	public void CheckAs() {
		Card As = new Card();
		Card other = new Card();
		Player player = new Player();
		
		As.naipe = "Copas";
		As.Name = "As";
		
		other.naipe = "Copas";
		other.valor = 10;
		
		player.hand.add(As);
		player.hand.add(other);
		
		player.CheckAs(As);
		
		assertEquals(player.hand.get(0).valor, 11);
	}
	
	@Test(timeout = 5000)
	public void CheckAsError() {
		Card As = new Card();
		Card other = new Card();
		Player player = new Player();
		
		As.naipe = "Copas";
		As.Name = "As";
		
		other.naipe = "Copas";
		other.valor = 10;
		
		player.hand.add(As);
		player.hand.add(other);
		
		player.CheckAs(As);
		
		assertNotSame("As deveria ser 11", player.hand.get(0).valor, 1);
	}

}
