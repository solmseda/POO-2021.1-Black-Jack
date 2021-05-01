public class Game {
	public static void main(String args[]) {
		Deck deck = new Deck();
		
		for(int i = 0; i < deck.size(); i++) {
			Card card = deck.GiveCard();
			System.out.println(card.naipe);
			System.out.println(card.valor);
			System.out.println(card.Name);
		}
	}
}
