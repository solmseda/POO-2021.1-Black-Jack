import java.lang.reflect.Array;
import java.util.*;

public class Game {
	public List<Gambler> CreatePlayers(String[] Names) {
		List<Gambler> gamblers = new ArrayList<Gambler>();
		
		for(int i = 0; i < Names.length; i++) {
			Gambler player = new Gambler("RAGEL");
			player.Name = Names[i];
			gamblers.add(player);
		}
		return gamblers;
	}
	
	
	public static void main(String args[]) {
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		

		Gambler gambler = new Gambler("RAQEL");
		Bank bank = new Bank();
		gambler.allCoins=bank.GiveInitialMoney();
		for (int i=0;i<gambler.allCoins.size();i++) {
			System.out.println(gambler.allCoins.get(i).qtt);
			System.out.println(gambler.allCoins.get(i).value);			 
		}
		System.out.println("APOSTANDO!!!!");
		gambler.Make_Bet(1,0,0,0,5);
		for (int i=0;i<gambler.allCoins.size();i++) {
			 
 			System.out.println(gambler.allCoins.get(i).qtt);
			System.out.println(gambler.allCoins.get(i).value);
		}
		
		for(int i = 0; i < deck.size(); i++) {
			Card card = new Card();
			card = deck.RemoveCard();
			/*System.out.println(card.naipe);
			System.out.println(card.valor);
			System.out.println(card.Name);*/
		}
		gambler.Hit(dealer, deck);
		
		
	}
}
