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
	coins Quant_1= new coins(0,1);
	public List<coins> allCoins= new ArrayList<coins>();	
	public List<List<Card>>AllHands = new ArrayList<List<Card>>();
	public int handNums=1;
	
	
	Gambler(String name){ 
		Name=name;
		allCoins=GetMoney();
	}
	
	public void Split(int handnum) {
 		
		List<Card> newhand = new ArrayList <Card>();
		AllHands.add(newhand);
		Card card= hand.get(1);
		AllHands.get(handnum).remove(card);
		newhand.add(card);
		System.out.println(AllHands.get(handnum).size()+"tama");
		handNums++;	
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
		List<coins> currentmoney=new ArrayList<coins>(Arrays.asList( Quant_100, Quant_50, Quant_20, Quant_10, Quant_5, Quant_1));
		return currentmoney;
	}
	public List<coins> Make_Bet(int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1) {
		List<coins> bet= new ArrayList<coins>();
		bet.add(new coins(Quant_100,100));
		bet.add(new coins(Quant_50,50));
		bet.add(new coins(Quant_20,20));
		bet.add(new coins(Quant_10,10));
		bet.add(new coins(Quant_5,5));
		bet.add(new coins(Quant_1,1));
		for(int i=0;i<bet.size();i++) {
			allCoins.get(i).qtt-=bet.get(i).qtt;
		}
		return bet;
	}
	

	public void Hit(Dealer dealer, Deck deck, int handnum) 
	{
		Card card = dealer.GiveCard(deck);
		card=CheckAs(card);
		AllHands.get(handnum).add(card);
 
	}
	//se n�o puder nem vai aparecer
	public List<coins> IntToCoins(int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1) {
		List<coins> bet= new ArrayList<coins>();
		bet.add(new coins(Quant_100,100));
		bet.add(new coins(Quant_50,50));
		bet.add(new coins(Quant_20,20));
		bet.add(new coins(Quant_10,10));
		bet.add(new coins(Quant_5,5));
		bet.add(new coins(Quant_1,1));

		return bet;
	}
	
	public List<coins> Double_Bet(Dealer dealer, Deck deck,int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1, int handnum) {
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
	    Hit(dealer, deck,handnum);
	    return NewBet;
	}
	 
	
	public List<coins> Surrender(int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1) {	
		List<coins> NewBet=Make_Bet(0,0,0,0,0,0);
		List<coins> InternalBet= IntToCoins(Quant_100, Quant_50,  Quant_20,  Quant_10, Quant_5,Quant_1);
		int betvalue= GetBetAmount(InternalBet);
		int halfbet=0;
		for(int i=0;i<InternalBet.size();i++) {
	    	//Retorna todo o valor pra mao do player
	    	allCoins.get(i).qtt+=InternalBet.get(i).qtt;
	    }
		if(halfbet%2==1) {
			halfbet++;
		}
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