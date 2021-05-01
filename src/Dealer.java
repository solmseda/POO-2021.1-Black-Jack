import java.util.ArrayList;
import java.util.List;
public class Dealer extends Player{
	List<Card>hand = new ArrayList<Card>();

	public Card GiveCard(Deck deck) {
		Card card = deck.RemoveCard();
		return card;
	}
}

