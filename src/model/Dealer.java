package model;

class Dealer extends Player{
	
	public Card GiveCard(Deck deck) {
		Card card = deck.RemoveCard();
		return card;
	}
}

