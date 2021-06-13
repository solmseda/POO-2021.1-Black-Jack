package model;
import java.util.*;

public class Game {
	public static Bank bank;
	public static Dealer dealer;
	public static Deck deck;
	public static List<Gambler> gamblers;
	public static int vez;
	public static int apostaMinima;
	public static List<coins> currentbet;
	public static List<coins> splitbet;
	
	
	public static void CreateGame(ArrayList<String> jogadores, int apostaMinimaSpinner) {
		 bank= CreateBank();
		 dealer=CreateDealer();
		 gamblers= CreateGamblers(jogadores,bank);
		 apostaMinima = apostaMinimaSpinner;
		 deck= CreateDeck();
		 vez = -1;
	}
	
	public static void StartPlayerTurn(int currentPlayer) {
			for(int i=0;i<2;i++) {
				gamblers.get(currentPlayer).hand.add(dealer.GiveCard(deck));
			}
	}
	
	public static List<Gambler> CreateGamblers(ArrayList<String> Names, Bank bank) {
		List<Gambler> gamblers = new ArrayList<Gambler>();
		for(int i = 0; i < Names.size(); i++) {
			Gambler gambler = new Gambler(Names.get(i));
			gambler.allCoins=bank.GiveInitialMoney();
			gamblers.add(gambler);
		}
		return gamblers;
	}
	
	/* Cria a classe Bank do jogo */
	public static Bank CreateBank() {
		Bank bank = new Bank();
		return bank;
	}
	
	/* Cria a classe Deck do jogo */
	public static Deck CreateDeck() {
		Deck deck = new Deck();
		return deck;
	}
	
	/* Cria a classe Dealer do jogo */
	public static Dealer CreateDealer() {
		Dealer dealer = new Dealer();
		return dealer;
	}
	
	/* Cria a classe Player do jogo */
	public Player CreatePlayer() {
		Player player = new Player();
		return player;
	}
	
	public static boolean Busted(int player) {
		if(player == -1)
			return dealer.HandValue()<21;
		else
			return gamblers.get(player).HandValue()>21;
	}
	
	public static boolean BlackJack(int player) {
		if(player == -1)
			return dealer.HandValue()==21;
		else
			return gamblers.get(player).HandValue()==21;
	}
	public static void makeBet(int gamblerOfTheTurn, int[] bet) {
		gamblers.get(gamblerOfTheTurn).Make_Bet(bet[0], bet[1], bet[2], bet[3], bet[4], bet[5]);
	}
	
	public static void PlayerDouble(int i,int[] bet) {
		 gamblers.get(i). Double_Bet( dealer,  deck,bet[0], bet[1],  bet[2],  bet[3], bet[4], bet[5]);
	 }
	
	 public static String GetCard(int player, int card) {
		 String hand=Seecard(gamblers.get(player).hand.get(card));
		 return hand;
	 }
	 
	 public static int GetCardValue(int player,int card) {
			return gamblers.get(player).hand.get(card).valor;
	 }
	 
	 public static int GetHandSize(int player) {
		return gamblers.get(player).hand.size();
	 }
	 
	 public static int GetGamblerMoney(int i) {
		 return gamblers.get(i).GetTotalMoney();
	 }
	 
	 public static int GetGamblerHand(int i) {
		 return gamblers.get(i).HandValue();
	 }
	 
	 public static void  Split(int i){
		 gamblers.get(i).Split();
	 }
	 
	 public static void PlayerHit(int i) {
		 gamblers.get(i).Hit(dealer, deck);
	 }
	 
	 public static Integer GetBetAmount( int i) {
		 return gamblers.get(i).GetBetAmount(currentbet);
	 }
	 public static Boolean CanSplit(int i) {
		 if(GetGamblerMoney(i)- GetBetAmount(i)*2>0) {
	    		if(Game.GetHandSize(i)==2) {
	    			if(Game.GetCardValue(i,0)==Game.GetCardValue(i,1)) {
					
	    				return true;
	    				}
					}
				}
		 return false;
	 }
	 public static Boolean CanDouble(int i) {
		 if(GetGamblerMoney(i)- GetBetAmount(i)*2>0) {
			 return true;
		 }
		 return false;
		 }
	 public static void SetBet(int i, int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1) {
		 currentbet= gamblers.get(i).IntToCoins(Quant_100, Quant_50, Quant_20, Quant_10, Quant_5, Quant_1);
	 }
	 public static String Seecard(Card card) {
		 String name= "/";
	     if(card.valor >= 2 && card.valor<=9) {
	    	 name= name.concat(Integer.toString(card.valor));
	     }
	     else {
	    	 if(card.valor == 1) {
	    		 name=name.concat("a");
	         }
	         else if(card.valor == 10) {
	        	 name=name.concat("t");
	         }
	         else if(card.valor == 11) {
	        	 name=name.concat("j");
	         }          
	         else if(card.valor == 12) {
	        	 name=name.concat("q");
	         }
	         else if(card.valor == 13) {
	        	 name=name.concat("k");
	         }
	    }
	    if(card.naipe=="Copas") {
	    	name=name.concat("h");
	    }
        else if(card.naipe=="Paus") {
            name= name.concat("c");
        }
        else if(card.naipe=="Espadas") {
            name=name.concat("s");
        }
        else {
            name=name.concat("h");
        }
        
        name= name.concat(".gif");

        return name;
	}

	public int getTurn() {
		return vez;
	}
}