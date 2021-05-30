package Controller;

import java.awt.EventQueue;
import java.util.ArrayList;

import View.InitialScreen;


public class Setup {
	
	static ArrayList<String> Jogadores;
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
	
	
}

//Teste AA
