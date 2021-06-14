// Raquel Olhovetchi Ferreira da Silva
// Sol Castilho Araújo de Moraes Sêda
// Victor Nielsen Ribeirete

package View;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class GameScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	public GameScreenPanel panel;
	final int LARG_DEFAULT=900;
	final int ALT_DEFAULT=700;

	
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
		panel = new GameScreenPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
	}
	
}
