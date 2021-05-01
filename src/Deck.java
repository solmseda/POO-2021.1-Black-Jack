import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Deck extends Card{
	public static List<Card> deck = new ArrayList<Card>();
	
	Deck() {
		for(int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				Card card = new Card();
				
				if(j >= 2 && j<=10) {
					card.valor = j;
					card.Name = Integer.toString(j);
				}
				else {
					if(j == 1) {
						card.valor = j;
						card.Name = "As";
					}
					else if(j == 11) {
						card.valor = 10;
						card.Name = "Valete";
					}
					else if(j == 12) {
						card.valor = 10;
						card.Name = "Dama";
					}
					else if(j == 13) {
						card.valor = 10;
						card.Name = "Reis";
					}
				}
					
					
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
	public Card RemoveCard() {
		Card card = new Card();
		card = deck.remove(0);
		return card;
	}

	public Deck getDeck() {
		return this;
	}

	public int size() {
		int size = deck.size();
		return size;
	}
}
