package View;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class GameScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	GameScreenPanel gameP;
	final int LARG_DEFAULT=900;
	final int ALT_DEFAULT=700;

	/**
	 * Create the frame.
	 */
	public GameScreen() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/5;
		int y=sa/2-ALT_DEFAULT/2;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 900, 700);
		setTitle("BlackJack");
		gameP = new GameScreenPanel();
		getContentPane().add(gameP);
		gameP.setLayout(null);
	}
	
	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
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
	}*/
}
