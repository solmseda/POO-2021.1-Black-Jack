import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class BankTeste {

	@Test
	void testGiveInitialMoney() {
		Bank bank = new Bank();
		Gambler gambler = new Gambler("Sol");
		
		gambler.allCoins = bank.GiveInitialMoney();
		List<coins> expectedCoins = new ArrayList<coins>();
		
		expectedCoins.add(new coins(2,100));
		expectedCoins.add(new coins(2,50));
		expectedCoins.add(new coins(5,20));
		expectedCoins.add(new coins(5,10));
		expectedCoins.add(new coins(8,5));
	
		assertEquals(expectedCoins.get(0).qtt, gambler.allCoins.get(0).qtt);
		assertEquals(expectedCoins.get(1).qtt, gambler.allCoins.get(1).qtt);
		assertEquals(expectedCoins.get(2).qtt, gambler.allCoins.get(2).qtt);
		assertEquals(expectedCoins.get(3).qtt, gambler.allCoins.get(3).qtt);
		assertEquals(expectedCoins.get(4).qtt, gambler.allCoins.get(4).qtt);
	}
	
	@Test
	void testGiveInitialMoneyFalha() {
		Bank bank = new Bank();
		Gambler gambler = new Gambler("Sol");
		
		gambler.allCoins = bank.GiveInitialMoney();
		List<coins> expectedCoins = new ArrayList<coins>();
		
		expectedCoins.add(new coins(1,100));
	
		assertEquals("A quantidade de moedas é diferente da esperada", expectedCoins.get(0).qtt, gambler.allCoins.get(0).qtt);
	}
	
	
	void give_money() {
		List<coins> allcoins= new ArrayList<coins>();
		int Quant_100,  Quant_50, Quant_20, Quant_10, Quant_5;

		allcoins.add(new coins(Quant_100,100));
		allcoins.add(new coins(Quant_50,50));
		allcoins.add(new coins(Quant_20,20));
		allcoins.add(new coins(Quant_10,10));
		allcoins.add(new coins(Quant_5,5));
		return allcoins;
		}

}
