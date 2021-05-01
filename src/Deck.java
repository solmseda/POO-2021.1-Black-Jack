import java.util.List;
import java.util.Collections;

class Deck extends Card{
	public List<Card> deck;
	
	public Deck() {
		Card card = new Card();
		for(int i = 1; i <= 4; i++) {
			for (int j = 1; j < 13; j++) {
				card.valor = i;
				if(i == 1) {
					card.naipe = "Copas";
				}
				else if(i == 2) {
					card.naipe = "Espadas";
				}
				else if( i== 3) {
					card.naipe = "Ouros";
				}
				else {
					card.naipe = "Paus";
				}
				deck.add(card);
			}
		}
		List<Card> duplicate = deck;
		deck.addAll(duplicate);
		deck.addAll(duplicate);
		deck.addAll(duplicate);
		Collections.shuffle(deck);
	}
	
	
	
	// retorna uma carta retirada da primeira posição da lista
	public Card GiveCard() {
		Card card = new Card();
		card = deck.remove(0);
		return card;
	}
}
