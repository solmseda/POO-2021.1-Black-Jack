package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
    class Gambler extends Player{
	String Name;
	coins Quant_100= new coins(0,100);
	coins Quant_50= new coins(0,50);
	coins Quant_20= new coins(0,20);
	coins Quant_10= new coins(0,10);
	coins Quant_5= new coins(0,5);
	public List<coins> allCoins= new ArrayList<coins>();	
	public List<Card>SplitHand = new ArrayList<Card>();
	
	Gambler(String name){ 
		Name=name;
		allCoins=GetMoney();
	}
	
	public void Split() {
		SplitHand.add(hand.get(1));
		hand.remove(1);
	}
	
	public Integer GetTotalMoney() {
		int totalmoney=0;
		for (int i=0;i< allCoins.size();i++) {
	    	totalmoney += (allCoins.get(i).value*allCoins.get(i).qtt);
	    } 
		return totalmoney;
	}
	public Integer GetBetAmount(List<coins> bet) {
		int betvalue=0;
		for (int i=0;i< bet.size();i++) {
	    	betvalue += (bet.get(i).value*bet.get(i).qtt);
	    } 
		
		return betvalue;
	}
	private List<coins> GetMoney() {
		List<coins> currentmoney=new ArrayList<coins>(Arrays.asList( Quant_100, Quant_50, Quant_20, Quant_10, Quant_5));
		return currentmoney;
	}
	public List<coins> Make_Bet(int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1) {
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
	
	public Boolean Stand() {
		/* No jogo finalizado essa função steá vinculada a um botão que irá passar a a vez do jogador através de uma booleana no controller */
		return true;
	}
	public void Hit(Dealer dealer, Deck deck) 
	{
		Card card = dealer.GiveCard(deck);
		hand.add(card);
	}
	//se não puder nem vai aparecer
	public List<coins> IntToCoins(int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1) {
		List<coins> bet= new ArrayList<coins>();
		bet.add(new coins(Quant_100,100));
		bet.add(new coins(Quant_50,50));
		bet.add(new coins(Quant_20,20));
		bet.add(new coins(Quant_10,10));
		bet.add(new coins(Quant_5,5));
		return bet;
	}
	
	public List<coins> Double_Bet(Dealer dealer, Deck deck,int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1) {
		List<coins> NewBet=Make_Bet(0,0,0,0,0,0);
		List<coins> InternalBet= IntToCoins(Quant_100, Quant_50,  Quant_20,  Quant_10, Quant_5,Quant_1);
		int betvalue= GetBetAmount(InternalBet);
		int doublebet=0;
		for(int i=0;i<InternalBet.size();i++) {
	    	//Retorna todo o valor pra mao do player
	    	allCoins.get(i).qtt+=InternalBet.get(i).qtt;
	    }
		
	    while(doublebet<betvalue*2) {
	    	for(int i=0;i<allCoins.size();i++) {
	    		int qtt=0;
	    		if(allCoins.get(i).qtt>0) {
	        		while(doublebet+allCoins.get(i).value<=betvalue*2 && allCoins.get(i).qtt>0) {
	        			allCoins.get(i).qtt-=1;
	        			qtt++;	
	        			doublebet+=allCoins.get(i).value;
 
	        		}
	        		coins coin=new coins(qtt,allCoins.get(i).value);
	        		NewBet.add(i,coin);
	        	}
	    	}
	    }
	    Hit(dealer, deck);
	    return NewBet;
	}
	 
	
	public List<coins> Surrender(List<coins> bet) {	
		List<coins> NewBet=Make_Bet(0,0,0,0,0,0);
		int betvalue= GetBetAmount(bet);
		int halfbet=0;
	    
		  while(halfbet<betvalue/2) {
		    	for(int i=0;i<allCoins.size();i++) {
		    		int qtt=0;
		    		if(allCoins.get(i).qtt>0) {
		        		while(halfbet+allCoins.get(i).value<=betvalue/2 && allCoins.get(i).qtt>0) {
		        			allCoins.get(i).qtt-=1;
		        			qtt++;	
		        			halfbet+=allCoins.get(i).value;
 
		        		}
		        		coins coin=new coins(qtt,allCoins.get(i).value);
		        		NewBet.add(i,coin);
		        	}
		    	}
		    }
		    return NewBet;
		}
		 
	 
}