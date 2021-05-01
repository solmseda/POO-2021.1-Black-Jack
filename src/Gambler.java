public class Gambler extends Player{
	public int Quant_100;
	public int Quant_50;
	public int Quant_20;
	public int Quant_10;
	public int Quant_5;
	
	public int Make_Bet() {
		
		return 0;
	}
	
	public void Stand() {
		
	}
	public void Hit(Deck deck, Card card) 
	{
		card = deck.GiveCard();
	}
	public void Double_Bet() {
		
	}
	public void Split() {
		
	}
	public void Surrender() {
		
	}
}
