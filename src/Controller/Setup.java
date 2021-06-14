// Raquel Olhovetchi Ferreira da Silva
// Sol Castilho Araújo de Moraes Sêda
// Victor Nielsen Ribeirete

package Controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Observable;

import model.Game;
import model.SaveSystem;
import View.Interface;

import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("deprecation")
class Setup implements Observer {
	
	static ArrayList<String> Jogadores = new ArrayList<String>();
	static int apostaMinima;
	static Interface interfaceGrafica;
	static int playerDaVez;
	static Setup setup = new Setup();
	static ArrayList<Boolean> turnosCompletos = new ArrayList<Boolean>();
	static boolean busted;

	
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
		playerDaVez = -1;
		Jogadores = interfaceGrafica.janelaInicial.panel.Jogadores;
		apostaMinima = interfaceGrafica.janelaInicial.panel.apostaMinima;
		
		Game.CreateGame(Jogadores, apostaMinima);
		interfaceGrafica.criaJanelajogo();
		interfaceGrafica.janelaJogo.panel.signal.addObserver(setup);
		interfaceGrafica.janelaJogo.setVisible(true);
		System.out.println(Jogadores.size()+"HGFDSFD");
		for(int player=0; player<Jogadores.size(); player++) {
			interfaceGrafica.criaJanelaPlayer(Jogadores,player);
			interfaceGrafica.janelasPlayers.get(player).panel.signal.addObserver(setup);
			turnosCompletos.add(false);
		}
	}
	
	public static void LoadGame() {
		playerDaVez = Game.vez;
		 
		Game.LoadGame(apostaMinima);
		Jogadores= Game.GetPlayers();

		interfaceGrafica.criaJanelajogo();
		interfaceGrafica.janelaJogo.panel.signal.addObserver(setup);
		interfaceGrafica.janelaJogo.setVisible(true);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		for(int player=0; player<Game.CountPlayers(); player++) {
			interfaceGrafica.criaJanelaPlayer(Jogadores,player);
			 
			interfaceGrafica.janelasPlayers.get(player).panel.signal.addObserver(setup);
			turnosCompletos.add(false);
			
		}
	}
	
	public static void NextPlayer() {
		if(playerDaVez == -1) {
			Game.DealerTurn();
			UpdateTable();
		}
		Game.vez++;
		playerDaVez++;
		if(playerDaVez<Jogadores.size()) {
			Game.StartPlayerTurn(playerDaVez);
			interfaceGrafica.janelasPlayers.get(playerDaVez).setVisible(true);
		}
		else {
			EndRound();
			
		}
	}
	 
	
	public static void UpdateTable() {
		
		if(playerDaVez!=-1)
			busted = interfaceGrafica.janelasPlayers.get(playerDaVez).panel.busted;
		else
			busted = false;
		interfaceGrafica.janelaJogo.panel.addPlayerCards(playerDaVez,busted);
	}
	
	public static void EndRound() {

		interfaceGrafica.janelaJogo.panel.revealDealerCard();
		Timer timer = new Timer();
		final long temp = 2000;
		TimerTask delay = new TimerTask() {
			@Override
			public void run() {
				interfaceGrafica.janelaJogo.panel.finishDealer();
				ArrayList<Integer> allPlayersHandValues = new ArrayList<Integer>();
				allPlayersHandValues.add(Game.GiveDealerHandValue());
				for(int i=0; i<Game.gamblers.size();i++) {
					allPlayersHandValues.add(Game.GetGamblerHand(i));
				}
				int playerVencedor = Game.CheckWinner(allPlayersHandValues);
				interfaceGrafica.janelaJogo.panel.exibeVencedor(playerVencedor-1,interfaceGrafica.janelaInicial.panel.Jogadores);
				interfaceGrafica.janelaJogo.panel.btnNovaRodada.setVisible(true);
				interfaceGrafica.janelaJogo.panel.btnSalvarJogo.setBounds(744, 61, 132, 39);
				interfaceGrafica.janelaJogo.panel.btnEncerrarPartida.setBounds(744, 111, 132, 39);
			}
		};
		timer.schedule(delay, temp);
		/*
		 * Salvar dados em um arquivo para poder recarregar na nova partida a partir de uma flag
		 */
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(interfaceGrafica.janelaInicial.panel.gameReady == true)
			NewGame();
		
		if(interfaceGrafica.janelaInicial.panel.LoadgameReady == true)
			LoadGame();
		if(interfaceGrafica.janelaJogo.panel.newMatch == true)
			NextPlayer();
		
		for(int player=0; player<Jogadores.size(); player++) {
			if(interfaceGrafica.janelasPlayers.get(player).panel.turnDone == true) {
				UpdateTable();
				NextPlayer();
			}
			
			 
		}
	}	
	
	
	
}

