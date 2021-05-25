package model;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class PlayerScreen extends JPanel   implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	private BufferedImage bg;
	public PlayerScreen() {
		try {
			bg= ImageIO.read(getClass().getResourceAsStream("/blackjackBKG.png"));
		} catch(IOException e) {
			
		}
		repaint();
	}
	public void paint(Graphics G) {
 
		G.drawImage(bg, 0,0,bg.getWidth(),bg.getHeight(),null);
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

