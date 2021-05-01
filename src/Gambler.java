import java.util.*;
    class Gambler extends Player{
	String Name;
	coins Quant_100= new coins(0,100);
	coins Quant_50= new coins(0,50);
	coins Quant_20= new coins(0,20);
	coins Quant_10= new coins(0,10);
	coins Quant_5= new coins(0,5);
	public List<coins> allCoins= new ArrayList<coins>();	
	
	Gambler(String name){ 
		Name=name;
		allCoins=GetMoney();
	}
	
	private List<coins> GetMoney() {
		List<coins> currentmoney=new ArrayList<coins>(Arrays.asList( Quant_100, Quant_50, Quant_20, Quant_10, Quant_5));
		return currentmoney;
	}
	public List<coins> Make_Bet(int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5) {
		List<coins> bet= new ArrayList<coins>();
		bet.add(new coins(Quant_100,100));
		bet.add(new coins(Quant_50,50));
		bet.add(new coins(Quant_20,20));
		bet.add(new coins(Quant_10,10));
		bet.add(new coins(Quant_5,5));
		for(int i=0;i<bet.size();i++) {
			allCoins.get(i).qtt-=bet.get(i).qtt;
		}
		return bet;
	}
	
	public void Stand() {
		
	}
	public void Hit(Dealer dealer, Deck deck) 
	{
		Card card = dealer.GiveCard(deck);
		hand.add(card);
		System.out.println("Cartas antigas "+hand.get(0).Name+ " e "+hand.get(1).Name+"  Nova carta "+card.Name);
		System.out.println("Somatorio:  "+(hand.get(0).valor+hand.get(1).valor+card.valor));
	}
	//se não puder nem vai aparecer
	public void Double_Bet(Dealer dealer, Deck deck,List<coins> bet) {
		Hit(dealer, deck);
		List<Integer> NewBet=new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
		int betvalue= 0;
		int doublebet=0;
	    for (int i=0;i< bet.size();i++) {
	    	betvalue += (bet.get(i).value*bet.get(i).qtt);
	    } 

	    while(doublebet<betvalue*2) {
	    	for(int i=0;i<allCoins.size();i++) {
	    		if(allCoins.get(i).qtt>0) {
	        		int qtt=0;
	        		while(doublebet+allCoins.get(i).value<betvalue*2 && allCoins.get(i).qtt>0) {
	        			allCoins.get(i).qtt-=1;
	        			qtt++;	
	        		}
	        		NewBet.add(i,qtt);
	        	}
	    	}
	    }
	}
	 
	public void Split() {
	}
	public void Surrender() {	
	}
	public Boolean Busted() {
		int sum=0;
		for (int i=0;i<hand.size();i++) {
			sum+=hand.get(i).valor;
			}
		if (sum>21) {
			return true;
		}
		return false;
	}
}