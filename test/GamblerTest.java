import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import java.util.*;

public class GamblerTest {

	@Test
	public void MakeBetTest() {
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		Gambler gambler = new Gambler("Sol");
		int Quant_100 = 1, Quant_50 = 1, Quant_20 = 1, Quant_10 = 1, Quant_5 = 1;
		List<coins> bet = new ArrayList<coins>();
		
		bet = gambler.Make_Bet(Quant_100, Quant_50, Quant_20, Quant_10, Quant_5);
		
		assertEquals(bet.get(0).qtt, 1);
	}
	
	@Test
	public void MakeBetTestError() {
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		Gambler gambler = new Gambler("Sol");
		int Quant_100 = 1, Quant_50 = 1, Quant_20 = 1, Quant_10 = 1, Quant_5 = 1;
		List<coins> bet = new ArrayList<coins>();
		
		bet = gambler.Make_Bet(Quant_100, Quant_50, Quant_20, Quant_10, Quant_5);
		
		assertEquals("Valor diferente do esperado",bet.get(0).qtt, 2);
	}

}
