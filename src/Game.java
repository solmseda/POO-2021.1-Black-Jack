import java.lang.reflect.Array;
import java.util.*;

public class Game {
	
	/* Criar os jogadores e dar o dinheiro inicial */
	public static List<Gambler> CreatePlayers(String[] Names, Bank bank, Dealer dealer, Deck deck) {
		List<Gambler> gamblers = new ArrayList<Gambler>();
		
		for(int i = 0; i < Names.length; i++) {
			Gambler gambler = new Gambler(Names[i]);
			Card card = new Card();
			
			//dar o dinheiro
			gambler.allCoins=bank.GiveInitialMoney();
			
			//Dar a primeira carta
			card = dealer.GiveCard(deck);
			gambler.hand.add(card);
			
			//dar a segunda carta
			card = dealer.GiveCard(deck);
			gambler.hand.add(card);
			
			gamblers.add(gambler);
		}
		return gamblers;
	}
	
	public static void GiveCardsToDealer(Dealer dealer, Deck deck) {
		Card card = new Card();
		
		card = dealer.GiveCard(deck);
		dealer.hand.add(card);
		
		card = dealer.GiveCard(deck);
		dealer.hand.add(card);
	}
	
	
	
	public static void main(String args[]) {
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Bank bank = new Bank();
		String[] Names = {"Sol", "Victor", "Raks"};
		List<Gambler> gamblers = CreatePlayers(Names, bank, dealer, deck);
		
		
	}
}
