package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.GameScreen;

public class InitialScreen {
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
							InitialScreen();
						}
					}
			);
		} catch (Exception exc) {
			System.out.println("Não pode criar a janela inicial devido a " + exc);
		}
	}
	
	private void InitialScreen() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		gambler1 = new JTextField(15);
		gambler2 = new JTextField(15);
		gambler3 = new JTextField(15);
		gambler4 = new JTextField(15);
		
		add(gambler1);
		add(gambler2);
		add(gambler3);
		add(gambler4);
		
		gambler1.addActionListener(new ActionListener() { showStatys(gambler1.getText()); });
		
		gambler2.addActionListener(new ActionListener() { showStatys(gambler2.getText()); });
		
		gambler3.addActionListener(new ActionListener() { showStatys(gambler3.getText()); });
		
		gambler4.addActionListener(new ActionListener() { showStatys(gambler4.getText()); });
		
	}

	public static void main(String args[]) {
		
		(new InitialScreen()).setVisible(true);
	 
 
	}
}
