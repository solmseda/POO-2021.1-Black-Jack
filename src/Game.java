import java.lang.reflect.Array;
import java.util.*;

public class Game {
	
	/* Criar os jogadores e dar o e cartas iniciais dinheiro inicial */
	public static List<Gambler> CreatePlayers(String[] Names, Bank bank) {
		List<Gambler> gamblers = new ArrayList<Gambler>();
		
		for(int i = 0; i < Names.length; i++) {
			Gambler gambler = new Gambler(Names[i]);
			
			//dar o dinheiro
			gambler.allCoins=bank.GiveInitialMoney();
			gamblers.add(gambler);
		}
		
		return gamblers;
	}

	/*
	public static void NewRound(List<Gambler> gamblers, Deck deck, Dealer dealer) {
		Card card = new Card();

		for(int i = 0; i < gamblers.size(); i++) {

			if (...) {

			//Dar a primeira carta para o gambler
			card = dealer.GiveCard(deck);
			gamblers.get(i).hand.add(card);
			
			//Dar a segunda carta para o gambler
			card = dealer.GiveCard(deck);
			gamblers.get(i).hand.add(card);

			}
			
		}

		//Dar a primeira carta para o dealer
		card = dealer.GiveCard(deck);
		dealer.hand.add(card);
		
		//Dar a segunda carta para o dealer
		card = dealer.GiveCard(deck);
		dealer.hand.add(card);


	}
	*/


	
	
	public static void main(String args[]) {
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Bank bank = new Bank();
		String[] Names = {"Sol", "Victor", "Raks"};
		List<Gambler> gamblers = CreatePlayers(Names, bank, dealer, deck);
	}
}