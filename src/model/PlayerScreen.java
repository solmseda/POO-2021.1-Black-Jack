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
	private BufferedImage card;
	public PlayerScreen() {
		try {
			bg= ImageIO.read(getClass().getResourceAsStream("/blackjackBKG.png"));
		} catch(IOException e) {
			
		}
		repaint();
	}
	public void paint(Graphics G) {
 
		G.drawImage(bg, 0,0,bg.getWidth(),bg.getHeight(),null);
		Dealer dealer= new Dealer();
		Deck deck= new Deck();
		int x=bg.getWidth()/3;
		for(int i=0;i<3;i++) {
		Card newcard=dealer.GiveCard( deck);
		String cardstring= seecard(newcard);
		try {
			card= ImageIO.read(getClass().getResourceAsStream(cardstring));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		G.drawImage(card, x,bg.getHeight()/2,card.getWidth(),card.getHeight(),null);
 		x+=card.getWidth();
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public String seecard(Card card) {
	 String name= "/";
	 if(card.valor >= 2 && card.valor<=9) {
	 name= name.concat(Integer.toString(card.valor));
	  }
	 else {
	 if(card.valor == 1) {
	 name=name.concat("a");
	 }
	 else if(card.valor == 10) {
	 name=name.concat("t");
	 }
	 else if(card.valor == 11) {
	 name=name.concat("j");
	 }
				 
	 else if(card.valor == 12) {
	 name=name.concat("q");
	 }
	 else if(card.valor == 13) {
	 name=name.concat("k");
	 }
	 }
	 if(card.naipe=="Copas") {
		 name=name.concat("h");
	 }
	 else if(card.naipe=="Paus") {
		 name= name.concat("c");
	 }
	 else if(card.naipe=="Espadas") {
		 name=name.concat("s");
	 }
	 else {
		 name=name.concat("h");
	 }
	 
	 name= name.concat(".gif");
	 
	 

	System.out.println(name);

	return name;
	}
}
