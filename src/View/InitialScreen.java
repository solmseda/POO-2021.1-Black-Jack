// Raquel Olhovetchi Ferreira da Silva
// Sol Castilho Araújo de Moraes Sêda
// Victor Nielsen Ribeirete

package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class InitialScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	public InitialScreenPanel panel;
	final int LARG_DEFAULT=880;
	final int ALT_DEFAULT=504;
	
	
	public InitialScreen() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 880, 530);
		setTitle("BlackJack");
		panel = new InitialScreenPanel();
		setContentPane(panel);
		panel.setLayout(null);
	}

	
}
