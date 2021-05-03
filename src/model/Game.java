package model;
import java.lang.reflect.Array;
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

}