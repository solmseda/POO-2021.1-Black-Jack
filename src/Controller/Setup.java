package Controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import model.Game;
import View.InitialScreen;


public class Setup {
	
	public static ArrayList<String> Jogadores = new ArrayList<String>();
	static InitialScreen janelaInicial = new InitialScreen();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janelaInicial.setVisible(true);
					System.out.println(Jogadores);
				} catch (Exception e) {
					System.out.println("Erro ao gerar tela inicial");
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void NewGame() {
		Game.CreateGame(Jogadores);
		System.out.println("OI");
		 
	}
	public static void NewRound() {
		Game.NewRound();
	}
	
}
