package View;

import java.util.ArrayList;
import java.util.List;

public class Interface {
	
	public InitialScreen janelaInicial;
	public ArrayList<PlayerScreen> janelasPlayers = new ArrayList<PlayerScreen>();
	public GameScreen janelaJogo;

	public Interface() {
		janelaInicial = new InitialScreen();
	}
	
	public void criaJanelajogo() {
		this.janelaJogo = new GameScreen();
	}
	
	public void criaJanelaPlayer(ArrayList<String> Jogadores, int player) {
		PlayerScreen janelaPlayer = new PlayerScreen(Jogadores, player);
		this.janelasPlayers.add(janelaPlayer);
	}
}
