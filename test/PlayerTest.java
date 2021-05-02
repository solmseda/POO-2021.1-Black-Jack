import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import java.util.*;

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

}
