package model;
import java.awt.*;
import javax.swing.*;
public class GameScreen  extends JFrame  {
	final int LARG_DEFAULT=800;
	final int ALT_DEFAULT=600;
	PlayerScreen s;
	
	public GameScreen(){
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTitle("BlackJack");
		s= new PlayerScreen();
		add(s);
//		setLayout(null);
	}
	
	public static void main(String args[]) {
		
		(new GameScreen()).setVisible(true);
	 
 
	}
}
