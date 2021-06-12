package model;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GamblerTest {

	@Test(timeout = 5000)
	public void MakeBetTest() {
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		Gambler gambler = new Gambler("Sol");
		int Quant_100 = 1, Quant_50 = 1, Quant_20 = 1, Quant_10 = 1, Quant_5 = 1, Quant_1 = 1;
		List<coins> bet = new ArrayList<coins>();
		
		bet = gambler.Make_Bet(Quant_100, Quant_50, Quant_20, Quant_10, Quant_5, Quant_1);
		
		assertEquals(bet.get(0).qtt, 1);
	}
	
	@Test(timeout = 5000)
	public void MakeBetTestError() {
		Gambler gambler = new Gambler("Sol");
		int Quant_100 = 1, Quant_50 = 1, Quant_20 = 1, Quant_10 = 1, Quant_5 = 1, Quant_1 = 1;
		List<coins> bet = new ArrayList<coins>();
		
		bet = gambler.Make_Bet(Quant_100, Quant_50, Quant_20, Quant_10, Quant_5, Quant_1);
		
		assertNotSame("Valor da aposta diferente do esperado", bet.get(0).qtt, 2);
	}
	
	@Test(timeout = 5000)
	public void Doble_BetTest() {
		int Quant_100 = 1, Quant_50 = 1, Quant_20 = 1, Quant_10 = 1, Quant_5 = 1, Quant_1 = 1;
		List<coins> bet = new ArrayList<coins>();
		List<coins> bet2 = new ArrayList<coins>();
		Gambler gambler = new Gambler("Sol");
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Bank bank = new Bank();
		
		gambler.allCoins = bank.give_money(2, 2, 5, 5, 8, 10);
		bet.add(new coins(Quant_100,100));
		bet.add(new coins(Quant_50,50));
		bet.add(new coins(Quant_20,20));
		bet.add(new coins(Quant_10,10));
		bet.add(new coins(Quant_5,5));
		bet.add(new coins(Quant_1,1));
		for(int i=0;i<bet.size();i++) {
			gambler.allCoins.get(i).qtt-=bet.get(i).qtt;
		}
		
		bet2 = gambler.Double_Bet(dealer, deck, Quant_100 , Quant_50 , Quant_20 , Quant_10 , Quant_5 , Quant_1 );
		
		assertEquals("Valor dobrado diferente do esperado", bet2.get(0).qtt, 2);
	}
	
	@Test(timeout = 5000)
	public void Doble_BetTestError() {
		int Quant_100 = 1, Quant_50 = 1, Quant_20 = 1, Quant_10 = 1, Quant_5 = 1, Quant_1 = 1;
		List<coins> bet = new ArrayList<coins>();
		List<coins> bet2 = new ArrayList<coins>();
		Gambler gambler = new Gambler("Sol");
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Bank bank = new Bank();
		
		gambler.allCoins = bank.give_money(2, 2, 5, 5, 8, 10);
		bet.add(new coins(Quant_100,100));
		bet.add(new coins(Quant_50,50));
		bet.add(new coins(Quant_20,20));
		bet.add(new coins(Quant_10,10));
		bet.add(new coins(Quant_5,5));
		bet.add(new coins(Quant_1,1));
		for(int i=0;i<bet.size();i++) {
			gambler.allCoins.get(i).qtt-=bet.get(i).qtt;
		}
		
		bet2 = gambler.Double_Bet(dealer, deck, Quant_100, Quant_50, Quant_20, Quant_10, Quant_5, Quant_1);
		
		assertNotSame("Valor dobrado diferente do esperado", bet2.get(0).qtt, 3);
	}

}
