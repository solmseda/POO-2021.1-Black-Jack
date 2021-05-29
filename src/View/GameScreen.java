package View;
import java.awt.EventQueue;
import javax.swing.JFrame;


public class GameScreen extends JFrame {
	GameScreenPanel gameP;

	/**
	 * Create the frame.
	 */
	public GameScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setTitle("BlackJack");
		gameP = new GameScreenPanel();
		getContentPane().add(gameP);
		gameP.setLayout(null);
	}
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameScreen frame = new GameScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
