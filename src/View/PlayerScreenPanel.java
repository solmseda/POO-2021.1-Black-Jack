package View;

import javax.swing.JPanel;

import Controller.Setup;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.*;
	
public class PlayerScreenPanel extends JPanel implements MouseListener  {

	private static final long serialVersionUID = 1L;
    private BufferedImage card;
    private BufferedImage coin1;
    private BufferedImage coin5;
    private BufferedImage coin10;
    private BufferedImage coin20;
    private BufferedImage coin50;
    private BufferedImage coin100;
    private int player;
    int iClick,jClick;

	/**
	 * Create the panel.
	 */
    public void getplayer() {
    player= Setup.getplayer();
    }
	public PlayerScreenPanel() {
		addMouseListener(this);
		setBackground(new Color(0, 128, 0));
		setLayout(null);
		
		JLabel lblPontuacaoTitulo = new JLabel("Pontua\u00E7\u00E3o:");
		lblPontuacaoTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblPontuacaoTitulo.setBounds(332, 21, 107, 47);
		add(lblPontuacaoTitulo);
		
		JLabel lblPontuacao = new JLabel(Setup.Hand(player));
		lblPontuacao.setFont(new Font("Calibri", Font.BOLD, 26));
		lblPontuacao.setBounds(377, 57, 28, 47);
		add(lblPontuacao);
		
		JLabel lblValorDaApostaTitulo = new JLabel("Valor da aposta:");
		lblValorDaApostaTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblValorDaApostaTitulo.setBounds(20, 21, 153, 47);
		add(lblValorDaApostaTitulo);
		
		JLabel lblCreditosTitulo = new JLabel("Cr\u00E9ditos:");
		lblCreditosTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblCreditosTitulo.setBounds(207, 21, 88, 47);
		add(lblCreditosTitulo);
		
		JLabel lblCreditos = new JLabel(Setup.Money(player));
		lblCreditos.setFont(new Font("Calibri", Font.BOLD, 26));
		lblCreditos.setBounds(240, 57, 60, 47);
		add(lblCreditos);
		
		JLabel lblValorDaAposta = new JLabel("0");
		lblValorDaAposta.setFont(new Font("Calibri", Font.BOLD, 26));
		lblValorDaAposta.setBounds(88, 57, 28, 47);
		add(lblValorDaAposta);
		
		JButton btnStand = new JButton("Stand");
		btnStand.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStand.setBounds(28, 482, 88, 38);
		add(btnStand);
		
		JButton btnHit = new JButton("Hit");
		btnHit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHit.setBounds(136, 482, 88, 38);
		add(btnHit);
		
		JButton btnDouble = new JButton("Double");
		btnDouble.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDouble.setBounds(246, 482, 88, 38);
		add(btnDouble);
		
		JButton btnSplit = new JButton("Split");
		btnSplit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSplit.setBounds(358, 482, 88, 38);
		add(btnSplit);

		btnHit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    Setup.Hit(player);	
		    revalidate();
		    repaint();
		    lblPontuacao.setText(Setup.Hand(player));

		    }
		});
	}
	
	public void paint(Graphics G) {
		G.setColor(getBackground());
		G.fillRect(0, 0, getWidth(), getHeight());
        int x=90;
        int y=350;
       
        for(int i=0;i<Setup.Handsize(player);i++) {
        	String cardstring= Setup.GetCard(player,i);
	        try {
	            card= ImageIO.read(getClass().getResourceAsStream(cardstring));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        G.drawImage(card, x,130,card.getWidth()*2,card.getHeight()*2,null);
	        x+=card.getWidth()*2+20;
        }
        	 
        	try {
        		  
        		 coin1= ImageIO.read(getClass().getResourceAsStream("/ficha 1$.PNG"));
                 int coinx= (int) ((int)coin1.getWidth()*1.3f);
                 int coiny= (int) ((int)coin1.getHeight()*1.3f);
                 G.drawImage(coin1, 5,y,coinx,coiny,null);
                 coin5= ImageIO.read(getClass().getResourceAsStream("/ficha 5$.PNG"));
                 G.drawImage(coin5, 80,y,coinx,coiny,null);
                 coin10= ImageIO.read(getClass().getResourceAsStream("/ficha 10$.PNG"));
                 G.drawImage(coin10, 155,y,coinx,coiny,null);
                 coin20= ImageIO.read(getClass().getResourceAsStream("/ficha 20$.PNG"));
                 G.drawImage(coin20, 230,y,coinx,coiny,null);
                 coin50= ImageIO.read(getClass().getResourceAsStream("/ficha 50$.PNG"));
                 G.drawImage(coin50, 305,y,coinx,coiny,null);
                 coin100= ImageIO.read(getClass().getResourceAsStream("/ficha 100$.PNG"));
                 G.drawImage(coin100, 380,y,coinx,coiny,null);
             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
        
		setOpaque(false);
		super.paint(G) ;
		setOpaque(true);
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		Point clicked = e.getPoint();
	    Rectangle bounds_coin1 = new Rectangle(5, 350, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin5 = new Rectangle(80, 350, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin10 = new Rectangle(155, 350, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin20 = new Rectangle(230, 350, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin50 = new Rectangle(305, 350, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin100 = new Rectangle(380, 350, coin1.getWidth(), coin1.getHeight());
	    
	    if (bounds_coin1.contains(clicked)) {
	        // target image was clicked
	    	System.out.println("Clicou na moeda de 1");
	    }
	    if (bounds_coin5.contains(clicked)) {
	        // target image was clicked
	    	System.out.println("Clicou na moeda de 5");
	    }
	    if (bounds_coin10.contains(clicked)) {
	        // target image was clicked
	    	System.out.println("Clicou na moeda de 10");
	    }
	    if (bounds_coin20.contains(clicked)) {
	        // target image was clicked
	    	System.out.println("Clicou na moeda de 20");
	    }
	    if (bounds_coin50.contains(clicked)) {
	        // target image was clicked
	    	System.out.println("Clicou na moeda de 50");
	    }
	    if (bounds_coin100.contains(clicked)) {
	        // target image was clicked
	    	System.out.println("Clicou na moeda de 100");
	    }
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
        
}
