package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class InitialScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	InitialScreenPanel initialSc;
	final int LARG_DEFAULT=880;
	final int ALT_DEFAULT=504;
	
	/**
	 * Create the frame.
	 */
	public InitialScreen() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 880, 530);
		setTitle("BlackJack");
		initialSc = new InitialScreenPanel();
		setContentPane(initialSc);
		initialSc.setLayout(null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialScreen frame = new InitialScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
