public class Game {
	public static void main(String args[]) {
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Gambler gambler = new Gambler();
		
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
