package Controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import model.Game;
import View.InitialScreen;


public class Setup {
	
	public static ArrayList<String> Jogadores = new ArrayList<String>();
	public static int apostaMinima;
	static InitialScreen janelaInicial = new InitialScreen();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janelaInicial.setVisible(true);
				} catch (Exception e) {
					System.out.println("Erro ao gerar tela inicial");
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void NewGame() {
		Game.CreateGame(Jogadores, apostaMinima);
		 
	}
	public static int getplayer() {
		return 0;
	}
	public static void NewMatch() {
		Game.NewMatch();
	}
	public static void Hit(int i) {
		Game.PlayerHit(i);
	}
	public static void Double(int i,int[] bet) {
		System.out.println("AOI");
		Game.PlayerDouble(i,bet[0], bet[1], bet[2], bet[3], bet[4],bet[5]);
	}
	public static int Handsize(int i) {
	return Game.GetHandSize(i);
	}
	
	public static Boolean PreparePlayerSplit(int i, int bet) {
		if(Handsize(i)==2) {
			if(GetCardValue(i,0)==GetCardValue(i,1)) {
				if(Money(i)- bet*2>0) {
				return true;
				}
			}
		}
		return false;
	 }
	public static void Split(int i) {
		Game.PlayerHit(i);	
	}
	
	public static String GetCard(int i,int j) {
		String Hand =Game.GetCard(i,j);
		return Hand;
	}
	public static int GetCardValue(int i,int j) {
		return Game.GetCardValue(i, j);
		
	}
	public static String MoneyText(int i) {
		return ""+Game.GetGamblerMoney(i); 
	}
	public static int Money(int i) {
		return Game.GetGamblerMoney(i); 
	}
	public static String Hand(int i) {
		return ""+Game.GetGamblerHand(i); 
	}
	public static String GetBetAmount(int i) {
		return ""+Game.GetBetAmount(i);		 
	}
	public static int GetBetMoney(int i) {
		return Game.GetBetAmount(i);		 
	}
	
	
	
}

