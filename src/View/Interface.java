package View;


public class Interface {
	
	public InitialScreen janelaInicial;
	public PlayerScreen janelaPlayer;
	public GameScreen janelaJogo;

	public Interface() {
		janelaInicial = new InitialScreen();
	}
	
	public void criaJanelajogo() {
		this.janelaJogo = new GameScreen();
	}
	
	public void criaJanelaPlayer(int player) {
		this.janelaPlayer = new PlayerScreen(player);
	}
}
