package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class PlayerScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	public PlayerScreenPanel panel;
	final int LARG_DEFAULT=480;
	final int ALT_DEFAULT=580;


	public PlayerScreen(int player) {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-3*LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, LARG_DEFAULT, ALT_DEFAULT);
		setTitle("Jogador");
		panel = new PlayerScreenPanel(player);
		getContentPane().add(panel);
		panel.setLayout(null);
	}

}
