package model;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class BankTest {

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
	
		assertEquals("A quantidade de moedas é diferente da esperada", expectedCoins.get(0).qtt, gambler.allCoins.get(0).qtt);
		assertEquals("A quantidade de moedas é diferente da esperada", expectedCoins.get(1).qtt, gambler.allCoins.get(1).qtt);
		assertEquals("A quantidade de moedas é diferente da esperada", expectedCoins.get(2).qtt, gambler.allCoins.get(2).qtt);
		assertEquals("A quantidade de moedas é diferente da esperada", expectedCoins.get(3).qtt, gambler.allCoins.get(3).qtt);
		assertEquals("A quantidade de moedas é diferente da esperada", expectedCoins.get(4).qtt, gambler.allCoins.get(4).qtt);
	}
	
	@Test
	void testGiveInitialMoneyERROR() {
		Bank bank = new Bank();
		Gambler gambler = new Gambler("Sol");
		
		gambler.allCoins = bank.GiveInitialMoney();
		List<coins> expectedCoins = new ArrayList<coins>();
		
		expectedCoins.add(new coins(1,100));
	
		assertNotSame("A quantidade de moedas é diferente da esperada", expectedCoins.get(0).qtt, gambler.allCoins.get(0).qtt);
	}
	
	@Test
	void give_moneyTest() {
		Bank bank = new Bank();
		Gambler gambler = new Gambler("Sol");
		List<coins> allcoins= new ArrayList<coins>();
		int Quant_100 = 1,  Quant_50 = 1, Quant_20 = 1, Quant_10 = 1, Quant_5 = 1;

		allcoins.add(new coins(Quant_100,100));
		allcoins.add(new coins(Quant_50,50));
		allcoins.add(new coins(Quant_20,20));
		allcoins.add(new coins(Quant_10,10));
		allcoins.add(new coins(Quant_5,5));
		
		gambler.allCoins = bank.give_money(Quant_100, Quant_50, Quant_20, Quant_10, Quant_5);
		
		assertEquals("A quantidade de moedas é diferente da esperada", allcoins.get(0).qtt, gambler.allCoins.get(0).qtt);
		}
	
	@Test
	void give_moneyTestERROR() {
		Bank bank = new Bank();
		Gambler gambler = new Gambler("Sol");
		List<coins> allcoins= new ArrayList<coins>();
		int Quant_100 = 1,  Quant_50 = 1, Quant_20 = 1, Quant_10 = 1, Quant_5 = 1;

		allcoins.add(new coins(Quant_100,100));
		allcoins.add(new coins(Quant_50,50));
		allcoins.add(new coins(Quant_20,20));
		allcoins.add(new coins(Quant_10,10));
		allcoins.add(new coins(Quant_5,5));
		
		gambler.allCoins = bank.give_money(Quant_100, Quant_50, Quant_20, Quant_10, Quant_5);
		
		assertNotSame("A quantidade de moedas é diferente da esperada", 2, gambler.allCoins.get(0).qtt);
		
		}

}
