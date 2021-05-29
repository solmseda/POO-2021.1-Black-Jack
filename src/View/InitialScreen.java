package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.GameScreen;

public class InitialScreen extends JFrame {
	JLabel str;
	JButton quant_1, quant_2, quant_3, quant_4;
	
	JTextField gambler1;
	JTextField gambler2;
	JTextField gambler3;
	JTextField gambler4;
	
	final int LARG_DEFAULT=800;
	final int ALT_DEFAULT=600;
	
	GameScreen gameScreen;
	
	public void init() {
		try {
			SwingUtilities.invokeAndWait(
					new Runnable() {
						public void run() {
							new InitialScreen();
						}
					}
			);
		} catch (Exception exc) {
			System.out.println("Não pode criar a janela inicial devido a " + exc);
		}
	}
	
	private InitialScreen() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		str = new JLabel("Selecione a quantidade de jogadores");
		add(str);
		
		quant_1 = new JButton("1 Jogador");
		quant_2 = new JButton("2 Jogadores");
		quant_3 = new JButton("3 Jogadores");
		quant_4 = new JButton("4 Jogadores");
		
		
		
		add(quant_1);
		add(quant_2);
		add(quant_3);
		add(quant_4);
		
		gambler1 = new JTextField(15);
		gambler2 = new JTextField(15);
		gambler3 = new JTextField(15);
		gambler4 = new JTextField(15);
		
		add(gambler1);
		add(gambler2);
		add(gambler3);
		add(gambler4);
	}

	public static void main(String args[]) {
		
		(new InitialScreen()).setVisible(true);
	 
 
	}
}
