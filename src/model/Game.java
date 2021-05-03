package model;
import java.util.*;

public class Game {
	
	/* Criar os jogadores e dar o e cartas iniciais dinheiro inicial */
	public List<Gambler> CreateGamblers(String[] Names, Bank bank) {
		List<Gambler> gamblers = new ArrayList<Gambler>();
		
		for(int i = 0; i < Names.length; i++) {
			Gambler gambler = new Gambler(Names[i]);
			
			//dar o dinheiro
			gambler.allCoins=bank.GiveInitialMoney();
			gamblers.add(gambler);
		}
		return gamblers;
	}
	
	/* Cria a classe Bank do jogo */
	public Bank CreateBank() {
		Bank bank = new Bank();
		return bank;
	}
	
	/* Cria a classe Deck do jogo */
	public Deck CreateDeck() {
		Deck deck = new Deck();
		return deck;
	}
	
	/* Cria a classe Dealer do jogo */
	public Dealer CreateDealer() {
		Dealer dealer = new Dealer();
		return dealer;
	}
	
	/* Cria a classe Player do jogo */
	public Player CreatePlayer() {
		Player player = new Player();
		return player;
	}

}