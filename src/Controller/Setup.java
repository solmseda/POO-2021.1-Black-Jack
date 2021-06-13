package Controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Observable;

import model.Game;
import View.Interface;

import java.util.Observer;


@SuppressWarnings("deprecation")
class Setup implements Observer {
	
	static ArrayList<String> Jogadores = new ArrayList<String>();
	static int apostaMinima;
	static Interface interfaceGrafica;
	static int playerDaVez = -1;
	static Setup setup = new Setup();
	static ArrayList<Boolean> turnosCompletos = new ArrayList<Boolean>();

	
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
		apostaMinima = interfaceGrafica.janelaInicial.panel.apostaMinima;
		
		Game.CreateGame(Jogadores, apostaMinima);
		interfaceGrafica.criaJanelajogo();
		interfaceGrafica.janelaJogo.panel.signal.addObserver(setup);
		interfaceGrafica.janelaJogo.setVisible(true);
		
		for(int player=0; player<Jogadores.size(); player++) {
			interfaceGrafica.criaJanelaPlayer(Jogadores,player);
			interfaceGrafica.janelasPlayers.get(player).panel.signal.addObserver(setup);
			turnosCompletos.add(false);
		}
	}
	
	public static void NextPlayer() {
		Game.vez++;
		playerDaVez++;
		if(playerDaVez<Jogadores.size()) {
			System.out.println(playerDaVez);
			Game.StartPlayerTurn(playerDaVez);
			interfaceGrafica.janelasPlayers.get(playerDaVez).setVisible(true);
		}
		else {
			EndRound();
		}
	}
	
	public static void UpdateGamblersTable() {
		
	}
	
	public static void EndRound() {
		/*
		 * Acionar o dealer para virar sua segunda carta e poder comprar outras
		*/
		interfaceGrafica.janelaJogo.panel.btnNovaRodada.setVisible(true);
		interfaceGrafica.janelaJogo.panel.btnSalvarJogo.setBounds(744, 61, 132, 39);
		interfaceGrafica.janelaJogo.panel.btnEncerrarPartida.setBounds(744, 111, 132, 39);
		/*
		 * Salvar dados em um arquivo para poder recarregar na nova partida a partir de uma flag
		 */
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(interfaceGrafica.janelaInicial.panel.gameReady == true)
			NewGame();
		
		if(interfaceGrafica.janelaJogo.panel.newMatch == true)
			NextPlayer();
		
		for(int player=0; player<Jogadores.size(); player++) {
			if(interfaceGrafica.janelasPlayers.get(player).panel.turnDone == true) {
				UpdateGamblersTable();
				NextPlayer();
			}
		}
	}	
	
	
	
}

