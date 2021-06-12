package model;
import java.util.*;

public class Game {
	public static Bank bank;
	public static Dealer dealer;
	public static Deck deck;
	public static List<Gambler> gamblers;
	public static int vez;
	public static int apostaMinima;
	
	/* Criar os jogadores e dar o e cartas iniciais dinheiro inicial */
	public static List<Gambler> CreateGamblers(ArrayList<String> Names, Bank bank) {
		List<Gambler> gamblers = new ArrayList<Gambler>();
		
		for(int i = 0; i < Names.size(); i++) {
			Gambler gambler = new Gambler(Names.get(i));
			
			//dar o dinheiro
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
	
	
	public static void CreateGame(ArrayList<String> jogadores, int apostaMinimaSpinner) {
		 bank= CreateBank();
		 dealer=CreateDealer();
		 gamblers= CreateGamblers(jogadores,bank);
		 deck= CreateDeck();
		 vez = 0;
		 apostaMinima = apostaMinimaSpinner;
	}
	public static void NewMatch() {
		for(int i=0;i<gamblers.size();i++) {
			for(int j=0;j<2;j++) {
				gamblers.get(i).hand.add(dealer.GiveCard(deck));
				System.out.println("JOGADOR "+i+ " " + gamblers.get(i).hand.get(j).Name);
			}
			 
		}
	}
	
	public static void makeBet(int gamblerOfTheTurn, int[] bet) {
		gamblers.get(gamblerOfTheTurn).Make_Bet(bet[0], bet[1], bet[2], bet[3], bet[4], bet[5]);
	}
	
	 public static String GetCard(int player, int card) {
		 String hand=Seecard(gamblers.get(player).hand.get(card));
		 return hand;
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
	 
	 public static void PlayerHit(int i) {
		 gamblers.get(i).Hit(dealer, deck);
		  
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