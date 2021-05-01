import java.lang.reflect.Array;
import java.util.*;

public class Game {
	
	/* Criar os jogadores e dar o e cartas iniciais dinheiro inicial */
	public static List<Gambler> CreatePlayers(String[] Names, Bank bank, Dealer dealer, Deck deck) {
		List<Gambler> gamblers = new ArrayList<Gambler>();
		Card card = new Card();
		
		for(int i = 0; i < Names.length; i++) {
			Gambler gambler = new Gambler(Names[i]);
			
			
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
		card = dealer.GiveCard(deck);
		dealer.hand.add(card);
		
		card = dealer.GiveCard(deck);
		dealer.hand.add(card);
		
		return gamblers;
	}
	
	
	
	public static void main(String args[]) {
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Bank bank = new Bank();
		String[] Names = {"Sol", "Victor", "Raks"};
		List<Gambler> gamblers = CreatePlayers(Names, bank, dealer, deck);
	}
}
