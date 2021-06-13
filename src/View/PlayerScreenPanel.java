package View;
import model.Game;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.*;
import javax.swing.SwingConstants;
	
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
    
    int iClick,jClick, bet = 0;
    int y=240;
    
    JLabel lblValorDaAposta;
    JButton btnDeal;
    JButton btnStand;
    JButton btnHit;
    JButton btnDouble;
    JButton btnSplit;
    JLabel lblCreditos;
    JLabel lblResultado;
    
    int quant_100 = 0;
	int quant_50 = 0;
	int quant_20 = 0;
	int quant_10 = 0;
	int quant_5 = 0;
	int quant_1 = 0;
    
    boolean betDone = false;
    public boolean HandTurnDone=false;
    public boolean turnDone = false;
    public int handNum=0;
    public int handstack=0;
    public int currhand=0;
    public boolean blackjack = false;
    public boolean busted = false;
    public PlayerScreenPanelSignal signal = new PlayerScreenPanelSignal();
    ArrayList<Integer> b = new ArrayList<Integer>();
     

	/**
	 * Create the panel.
	 */

	public PlayerScreenPanel(int player) {
		this.player = player;
		addMouseListener(this);
		setBackground(new Color(0, 128, 0));
		setLayout(null);
		
		JLabel lblMao = new JLabel("M\u00E3o:");
		lblMao.setFont(new Font("Calibri", Font.BOLD, 22));
		lblMao.setBounds(398, 27, 58, 34);
		add(lblMao);
		JLabel lblMaoNum = new JLabel("1");
		lblMaoNum.setFont(new Font("Calibri", Font.BOLD, 26));
		lblMaoNum.setBounds(414, 61, 32, 38);
		add(lblMaoNum);
		JLabel lblPontuacaoTitulo = new JLabel("Pontua\u00E7\u00E3o:");
		lblPontuacaoTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblPontuacaoTitulo.setBounds(271, 21, 107, 47);
		add(lblPontuacaoTitulo);
		
		JLabel lblPontuacao = new JLabel(""+0);
		lblPontuacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontuacao.setFont(new Font("Calibri", Font.BOLD, 26));
		lblPontuacao.setBounds(302, 57, 47, 47);
		add(lblPontuacao);
		
		JLabel lblValorDaApostaTitulo = new JLabel("Valor da aposta:");
		lblValorDaApostaTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblValorDaApostaTitulo.setBounds(10, 21, 153, 47);
		add(lblValorDaApostaTitulo);
		
		JLabel lblCreditosTitulo = new JLabel("Cr\u00E9ditos:");
		lblCreditosTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblCreditosTitulo.setBounds(173, 21, 88, 47);
		add(lblCreditosTitulo);
		
		lblCreditos = new JLabel(""+Game.GetGamblerMoney(player));
		lblCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditos.setFont(new Font("Calibri", Font.BOLD, 26));
		lblCreditos.setBounds(173, 57, 88, 47);
		add(lblCreditos);
		
		lblValorDaAposta = new JLabel(String.valueOf(bet));
		lblValorDaAposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorDaAposta.setFont(new Font("Calibri", Font.BOLD, 26));
		lblValorDaAposta.setBounds(46, 57, 68, 47);
		add(lblValorDaAposta);
		
		lblResultado = new JLabel("Queimou!");
		lblResultado.setVisible(false);
		lblResultado.setForeground(Color.ORANGE);
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Calibri", Font.BOLD, 70));
		lblResultado.setBounds(0, 178, 464, 115);
		add(lblResultado);
		
		btnStand = new JButton("Stand");
		btnStand.setEnabled(false);
		btnStand.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStand.setBounds(28, 482, 88, 38);
		add(btnStand);
		
		btnHit = new JButton("Hit");
		btnHit.setEnabled(false);
		btnHit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHit.setBounds(137, 482, 88, 38);
		add(btnHit);
		
		btnDouble = new JButton("Double");
		btnDouble.setEnabled(false);
		btnDouble.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDouble.setBounds(246, 482, 88, 38);
		add(btnDouble);
		
		btnSplit = new JButton("Split");
		btnSplit.setEnabled(false);
		btnSplit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSplit.setBounds(358, 482, 88, 38);
		add(btnSplit);
		
		btnDeal = new JButton("Deal");
		btnDeal.setForeground(Color.RED);
		btnDeal.setEnabled(false);
		btnDeal.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeal.setBounds(195, 364, 90, 38);
		add(btnDeal);
		
		JLabel lblAposta = new JLabel("Fa\u00E7a sua aposta:");
		lblAposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAposta.setForeground(Color.ORANGE);
		lblAposta.setFont(new Font("Calibri", Font.BOLD, 65));
		lblAposta.setBounds(0, 127, 464, 115);
		add(lblAposta);
		
		JLabel lblSurrender = new JLabel("<--- Surrender?! --->");
		lblSurrender.setVisible(false);
		lblSurrender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSurrender.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurrender.setBounds(139, 422, 196, 49);
		add(lblSurrender);
		
		JButton btnYesSurrender = new JButton("Yes...");
		btnYesSurrender.setVisible(false);
		btnYesSurrender.setForeground(Color.RED);
		btnYesSurrender.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnYesSurrender.setBounds(341, 430, 89, 39);
		add(btnYesSurrender);
		
		JButton btnNopeSurrender = new JButton("Nope");
		btnNopeSurrender.setVisible(false);
		btnNopeSurrender.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNopeSurrender.setForeground(Color.BLACK);
		btnNopeSurrender.setBounds(40, 430, 89, 39);
		add(btnNopeSurrender);
		
		btnDeal.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	betDone = true;
		    	btnStand.setEnabled(true);
		    	btnHit.setEnabled(true);
		    	 
		    	int[] b = {quant_100, quant_50, quant_20, quant_10, quant_5, quant_1};
				   Game.makeBet(player, b);
				   Game.SetBet(player, quant_100, quant_50, quant_20, quant_10, quant_5, quant_1);
				Boolean CanSplit = Game.CanSplit(player,handNum);
			    Boolean CanDouble= Game.CanDouble(player); 
		    	if(CanDouble) {
		    		btnDouble.setEnabled(true);;
		    	}
		    	else {
		    		btnDouble.setEnabled(false);
		    	}
				
		    	if(CanSplit) {
		    		btnSplit.setEnabled(true);
		    	}
		    	else {
		    		btnSplit.setEnabled(false);
		    	}
		    	
		    	lblAposta.setVisible(false);
		    	btnDeal.setVisible(false);
			    
			    lblResultado.setText(""+Game.GetBetAmount(player));
		    	lblCreditos.setText(""+Game.GetGamblerMoney(player));
			    lblPontuacao.setText(""+Game.GetGamblerHand(player));
			    lblSurrender.setVisible(true);
			    btnNopeSurrender.setVisible(true);
			    btnYesSurrender.setVisible(true);
		    }
		});

		btnHit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Game.PlayerHit(player,handNum);	
		    	btnSplit.setEnabled(false);
		    	revalidate();
		    	repaint();
		    	lblPontuacao.setText(""+Game.GetGamblerHand(player));
		    	if(Game.Busted(player)) {
		    		lblResultado.setText("Queimou!");
		    		lblResultado.setVisible(true);
		    		btnHit.setEnabled(false);
		    		btnStand.setEnabled(false);
		    		btnSplit.setEnabled(false);
		    		btnDouble.setEnabled(false);		
		    		Timer timer = new Timer();
		    		final long temp = 2500;
		    		TimerTask delay = new TimerTask() {
						@Override
						public void run() {
							busted = true;
							turnDone = true;
							signal.send(turnDone);
							turnDone = false;
							busted = false;
							JComponent comp = (JComponent) e.getSource();
							Window win = SwingUtilities.getWindowAncestor(comp);
							win.dispose();
						}
		    		};
		    		timer.schedule(delay, temp);
		    	}
		    	if(Game.BlackJack(player)) {
		    		lblResultado.setText("BLACKJACK!");
		    		lblResultado.setVisible(true);
		    		btnHit.setEnabled(false);
		    		btnStand.setEnabled(false);
		    		btnSplit.setEnabled(false);
		    		btnDouble.setEnabled(false);
		    		Timer timer = new Timer();
		    		final long temp = 2500;
		    		TimerTask delay = new TimerTask() {
						@Override
						public void run() {
							blackjack = true;
							turnDone = true;
							signal.send(turnDone);
							turnDone = false;
							blackjack = false;
							JComponent comp = (JComponent) e.getSource();
							Window win = SwingUtilities.getWindowAncestor(comp);
							win.dispose();
						}
		    		};
		    		timer.schedule(delay, temp);
		    	}
		    }
		    
		});
		
		btnStand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(handstack==0) {
				turnDone = true;
				signal.send(turnDone);
				turnDone = false;
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				}
				else {
					
					handNum++;
					currhand++;
					handstack--;
					Game.GiveCard(player,currhand);
					revalidate();
			    	repaint();
			    	lblValorDaAposta.setText(String.valueOf(bet));
			    	lblCreditos.setText(""+Game.GetGamblerMoney(player));
				}
				 
			}
		});
		btnSplit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int handcount= Game.CountHands(player);
				 
			     Game.Split(player,handNum);	  
			     handstack++;
				 Boolean CanSplit = Game.CanSplit(player,handNum);
				 if((Game.GetCardValue(player,0,handNum)==1 ||Game.GetCardValue(player,0,handNum)==11)||
						 Game.GetCardValue(player,0,handNum)==1 ||Game.GetCardValue(player,0,handNum)==11){
					btnHit.setEnabled(false);	
			    	btnDouble.setEnabled(false);
					}
			     if(CanSplit) {
			    		btnSplit.setEnabled(true);
			    	}
			    	else {
			    		btnSplit.setEnabled(false);
			    	}
				
		    	revalidate();
		    	repaint();
		    	
		    	int[] b = {quant_100, quant_50, quant_20, quant_10, quant_5, quant_1};
		    	Game.makeBet(player, b);
		    	bet=Game.GetBetAmount(player);
		    	lblValorDaAposta.setText(String.valueOf(bet));
		    	lblCreditos.setText(""+Game.GetGamblerMoney(player));
		     
		    	 
			}
		});
		btnDouble.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] b = {quant_100, quant_50, quant_20, quant_10, quant_5, quant_1};
				btnSplit.setEnabled(false);
				Game.PlayerDouble(player,b,handNum);	
				bet=Game.GetBetAmount(player);
				Game.SetBet(player, quant_100, quant_50, quant_20, quant_10, quant_5, quant_1);
		    	revalidate();
		    	repaint();
		    	lblValorDaAposta.setText(String.valueOf(bet));
			    lblPontuacao.setText(""+Game.GetGamblerHand(player));
		    	lblCreditos.setText(""+Game.GetGamblerMoney(player));
		    	if(Game.Busted(player)) {
		    		lblResultado.setText("Queimou!");
		    		lblResultado.setVisible(true);
		    		btnHit.setEnabled(false);
		    		btnStand.setEnabled(false);
		    		btnSplit.setEnabled(false);
		    		btnDouble.setEnabled(false);
		    		Timer timer = new Timer();
		    		final long temp = 2500;
		    		TimerTask delay = new TimerTask() {
						@Override
						public void run() {
							busted = true;
							turnDone = true;
							signal.send(turnDone);
							turnDone = false;
							busted = false;
							JComponent comp = (JComponent) e.getSource();
							Window win = SwingUtilities.getWindowAncestor(comp);
							win.dispose();
						}
		    		};
		    		timer.schedule(delay, temp);
		    	}
		    	if(Game.BlackJack(player)) {
		    		
		    		lblResultado.setText("BLACKJACK!");
		    		lblResultado.setVisible(true);
		    		btnHit.setEnabled(false);
		    		btnStand.setEnabled(false);
		    		btnSplit.setEnabled(false);
		    		btnDouble.setEnabled(false);
		    		Timer timer = new Timer();
		    		final long temp = 2500;
		    		TimerTask delay = new TimerTask() {
						@Override
						public void run() {
							blackjack = true;
							turnDone = true;
							signal.send(turnDone);
							turnDone = false;
							blackjack = false;
							JComponent comp = (JComponent) e.getSource();
							Window win = SwingUtilities.getWindowAncestor(comp);
							win.dispose();
						}
		    		};
		    		timer.schedule(delay, temp);
		    	}
		    	btnHit.setEnabled(false);
		    	btnDouble.setEnabled(false);
		    	 
			}
		});
	}
	
	public void paint(Graphics G) {
		G.setColor(getBackground());
		G.fillRect(0, 0, getWidth(), getHeight());
        int x=180;
        int totalCards = Game.GetHandSize(player,handNum);
        
        
        try {
        	coin1= ImageIO.read(getClass().getResourceAsStream("/ficha 1$.PNG"));
        	coin5= ImageIO.read(getClass().getResourceAsStream("/ficha 5$.PNG"));
        	coin10= ImageIO.read(getClass().getResourceAsStream("/ficha 10$.PNG"));
        	coin20= ImageIO.read(getClass().getResourceAsStream("/ficha 20$.PNG"));
        	coin50= ImageIO.read(getClass().getResourceAsStream("/ficha 50$.PNG"));
        	coin100= ImageIO.read(getClass().getResourceAsStream("/ficha 100$.PNG"));
		} catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	   }
        
        int coinx= (int) ((int)coin1.getWidth()*1.3f);
        int coiny= (int) ((int)coin1.getHeight()*1.3f);
        
        if(betDone == false) {
	        G.drawImage(coin1, 5,y,coinx,coiny,null);
	        G.drawImage(coin5, 80,y,coinx,coiny,null);
	        G.drawImage(coin10, 155,y,coinx,coiny,null);
	        G.drawImage(coin20, 230,y,coinx,coiny,null);
	        G.drawImage(coin50, 305,y,coinx,coiny,null);
	        G.drawImage(coin100, 380,y,coinx,coiny,null);
        }
        
        else {
	        for(int i=0;i<totalCards;i++) {
	        	String cardstring= Game.GetCard(player,i,handNum);
		        try {
		            card= ImageIO.read(getClass().getResourceAsStream(cardstring));
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        G.drawImage(card, x/totalCards+i*10,130,card.getWidth()*2,card.getHeight()*2,null);
		        x+=card.getWidth()*3+20;
	        }
	        
	        y=350;
	        int b2[] = {quant_100, quant_50, quant_20, quant_10, quant_5, quant_1};
	        int numFichasDiferentes = 0;
	        for(int i=0; i<b2.length; i++) {
	        	if(b2[i]>0)
	        		numFichasDiferentes++;
	        }
	        
	        for(int i=0; i<quant_1; i++) {
				G.drawImage(coin1, 5+i*(int)15/quant_1,y,coinx,coiny,null);
	        }
	        for(int i=0; i<quant_5; i++) {
	        	G.drawImage(coin5, 80+i*(int)15/quant_5,y,coinx,coiny,null);
	        }
	        for(int i=0; i<quant_10; i++) {
	        	G.drawImage(coin10, 155+i*(int)15/quant_10,y,coinx,coiny,null);
	        }
	        for(int i=0; i<quant_20; i++) {
	        	G.drawImage(coin20, 230+i*(int)15/quant_20,y,coinx,coiny,null);
	        }
	        for(int i=0; i<quant_50; i++) {
	        	G.drawImage(coin50, 305+i*(int)15/quant_50,y,coinx,coiny,null);
	        }
	         
	        for(int i=0; i<quant_100; i++) {
	        	G.drawImage(coin100, 380+i*(int)15/quant_100,y,coinx,coiny,null);
	        }
        }
        
        setOpaque(false);
		super.paint(G) ;
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		Point clicked = e.getPoint();
	    Rectangle bounds_coin1 = new Rectangle(5, y, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin5 = new Rectangle(80, y, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin10 = new Rectangle(155, y, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin20 = new Rectangle(230, y, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin50 = new Rectangle(305, y, coin1.getWidth(), coin1.getHeight());
	    Rectangle bounds_coin100 = new Rectangle(380, y, coin1.getWidth(), coin1.getHeight());
	    
		if(betDone == false) {
		    if (bounds_coin1.contains(clicked) && Game.GetGamblerMoney(player)-1-bet >= 0) {
		        // target image was clicked
		    	quant_1++;
		    	bet = bet + 1;
		    	lblCreditos.setText(String.valueOf(Game.GetGamblerMoney(player)-bet));
		    	if(bet>=Game.apostaMinima)
		    		btnDeal.setEnabled(true);
		    }
		    if (bounds_coin5.contains(clicked) && Game.GetGamblerMoney(player)-5-bet >= 0) {
		        // target image was clicked
		    	quant_5++;
		    	bet = bet + 5;
		    	lblCreditos.setText(String.valueOf(Game.GetGamblerMoney(player)-bet));
		    	if(bet>=Game.apostaMinima)
		    		btnDeal.setEnabled(true);
		    }
		    if (bounds_coin10.contains(clicked) && Game.GetGamblerMoney(player)-10-bet >= 0) {
		        // target image was clicked
		    	quant_10++;
		    	bet = bet + 10;
		    	lblCreditos.setText(String.valueOf(Game.GetGamblerMoney(player)-bet));
		    	if(bet>=Game.apostaMinima)
		    		btnDeal.setEnabled(true);
		    }
		    if (bounds_coin20.contains(clicked) && Game.GetGamblerMoney(player)-20-bet >= 0) {
		        // target image was clicked
		    	quant_20++;
		    	bet = bet + 20;
		    	lblCreditos.setText(String.valueOf(Game.GetGamblerMoney(player)-bet));
		    	if(bet>=Game.apostaMinima)
		    		btnDeal.setEnabled(true);
		    }
		    if (bounds_coin50.contains(clicked) && Game.GetGamblerMoney(player)-50-bet >= 0) {
		        // target image was clicked
		    	quant_50++;
		    	bet = bet + 50;
		    	lblCreditos.setText(String.valueOf(Game.GetGamblerMoney(player)-bet));
		    	if(bet>=Game.apostaMinima)
		    		btnDeal.setEnabled(true);
		    }
		    if (bounds_coin100.contains(clicked) && Game.GetGamblerMoney(player)-100-bet >= 0) {
		        // target image was clicked
		    	quant_100++;
		    	bet = bet + 100;
		    	lblCreditos.setText(String.valueOf(Game.GetGamblerMoney(player)-bet));
		    	if(bet>=Game.apostaMinima)
		    		btnDeal.setEnabled(true);
		    }
		}
	    lblValorDaAposta.setText(String.valueOf(bet));
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
