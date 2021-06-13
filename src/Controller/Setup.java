package Controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Observable;

import model.Game;
import View.Interface;

import java.util.Observer;


@SuppressWarnings("deprecation")
class Setup implements Observer{
	
	static ArrayList<String> Jogadores = new ArrayList<String>();
	static int apostaMinima;
	static Interface interfaceGrafica;
	static int playerDaVez;
	static Setup setup = new Setup();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceGrafica = new Interface();
					interfaceGrafica.janelaInicial.panel.signal.addObserver(setup);
					interfaceGrafica.janelaInicial.setVisible(true);
				} catch (Exception e) {
					System.out.println("Erro ao gerar tela inicial");
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void NewGame() {
		Jogadores = interfaceGrafica.janelaInicial.panel.Jogadores;
		apostaMinima = (int)interfaceGrafica.janelaInicial.panel.apostaMinima;
		Game.CreateGame(Jogadores, apostaMinima);
		interfaceGrafica.criaJanelajogo();
		interfaceGrafica.janelaJogo.panel.signal.addObserver(setup);
		interfaceGrafica.janelaJogo.setVisible(true);
	}
	

	public static void NewMatch() {
		Game.NewMatch();
		playerDaVez = Game.vez%4;
		interfaceGrafica.criaJanelaPlayer(playerDaVez);
		interfaceGrafica.janelaPlayer.panel.signal.addObserver(setup);
		interfaceGrafica.janelaPlayer.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(interfaceGrafica.janelaInicial.panel.gameReady == true)
			NewGame();
		
		if(interfaceGrafica.janelaJogo.panel.newMatch == true)
			NewMatch();
		
		
		
	}
	
	
	
}

