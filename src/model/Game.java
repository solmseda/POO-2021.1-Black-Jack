package model;
import java.util.*;

public class Game {
	
	/* Criar os jogadores e dar o e cartas iniciais dinheiro inicial */
	public List<Gambler> CreateGamblers(String[] Names, Bank bank) {
		List<Gambler> gamblers = new ArrayList<Gambler>();
		
		for(int i = 0; i < Names.length; i++) {
			Gambler gambler = new Gambler(Names[i]);
			
			//dar o dinheiro
			gambler.allCoins=bank.GiveInitialMoney();
			gamblers.add(gambler);
		}
		return gamblers;
	}
	
	/* Cria a classe Bank do jogo */
	public Bank CreateBank() {
		Bank bank = new Bank();
		return bank;
	}
	
	/* Cria a classe Deck do jogo */
	public Deck CreateDeck() {
		Deck deck = new Deck();
		return deck;
	}
	
	/* Cria a classe Dealer do jogo */
	public Dealer CreateDealer() {
		Dealer dealer = new Dealer();
		return dealer;
	}
	
	/* Cria a classe Player do jogo */
	public Player CreatePlayer() {
		Player player = new Player();
		return player;
	}
	
	 public String Seecard(Card card) {
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
	   }