package View;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

import model.Game;
import javax.swing.SwingConstants;


public class GameScreenPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public GameScreenPanelSignal signal = new GameScreenPanelSignal();
	public boolean newMatch = false;
	public JButton btnNovaRodada;
	public JButton btnSalvarJogo;
	public JButton btnEncerrarPartida;
	public boolean endRound = false;
	boolean isDealer = false;
	boolean normalTurn = false;
	boolean showDealerLastCards = false;
	boolean haVencedor = false;
	String vencedor;
	ArrayList<Integer> handSizesPlayers = new ArrayList<Integer>();
	ArrayList<Boolean> listBoolBustedPlayers = new ArrayList<Boolean>();
	ArrayList<ArrayList<String>> playersHands = new ArrayList<ArrayList<String>>();
	ArrayList<String> dealerHand = new ArrayList<String>();
	JLabel lblVencedor;

	/**
	 * Create the panel.
	 */
	private BufferedImage backgroundImage;
	public GameScreenPanel() {
		setLayout(null);
		
		btnNovaRodada = new JButton("Nova rodada");
		btnNovaRodada.setBounds(744, 11, 132, 39);
		btnNovaRodada.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNovaRodada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMatch = true;
				signal.send(newMatch);
				newMatch = false;
				btnNovaRodada.setVisible(false);
				btnSalvarJogo.setBounds(744, 11, 132, 39);
				btnEncerrarPartida.setBounds(744, 61, 132, 39);
			}
		});
		add(btnNovaRodada);
		
		btnSalvarJogo = new JButton("Salvar Jogo");
		btnSalvarJogo.setBounds(744, 61, 132, 39);
		btnSalvarJogo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Depois
			}
		});
		add(btnSalvarJogo);
			
		btnEncerrarPartida = new JButton("Encerrar Partida");
		btnEncerrarPartida.setBounds(744, 111, 132, 39);
		btnEncerrarPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEncerrarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		add(btnEncerrarPartida);
		
		JLabel lblApostaMinimaTitulo = new JLabel("Aposta m\u00EDnima:");
		lblApostaMinimaTitulo.setForeground(Color.LIGHT_GRAY);
		lblApostaMinimaTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApostaMinimaTitulo.setBounds(138, 66, 115, 26);
		add(lblApostaMinimaTitulo);
		
		String sufix = " créditos";
		String apostaMin = String.valueOf(Game.apostaMinima)+sufix;
		
		JLabel lblCreditos = new JLabel("20 cr\u00E9ditos");
		lblCreditos.setForeground(Color.LIGHT_GRAY);
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreditos.setBounds(148, 87, 93, 26);
		add(lblCreditos);
		
		lblVencedor = new JLabel("lblVencedor");
		lblVencedor.setVisible(false);
		lblVencedor.setForeground(Color.BLACK);
		lblVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVencedor.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblVencedor.setBounds(115, 220, 611, 187);
		add(lblVencedor);
		
		try {
			backgroundImage = ImageIO.read(getClass().getResourceAsStream("/blackjackBKG.png"));
		} catch(IOException e) {
			System.out.println("Não carregou imagem de fundo");
		}
		
	}
	
	
	public void paint(Graphics G) {
		G.drawImage(backgroundImage, 0,0,backgroundImage.getWidth(),backgroundImage.getHeight(),null);
		
		int i = 0;
		if (isDealer == true || normalTurn == true)
			i = -1;
				
		while (i<listBoolBustedPlayers.size()) {
			
			if(i==-1) {
				try {
					if(endRound == false) {
						BufferedImage cardDealer = ImageIO.read(getClass().getResourceAsStream("/b.gif"));
						G.drawImage(cardDealer,380+25,110,73,97,null);
					}
					else {
						BufferedImage cardDealer = ImageIO.read(getClass().getResourceAsStream(dealerHand.get(0)));
						G.drawImage(cardDealer,380+25,110,73,97,null);
					}
					BufferedImage cardDealer2 = ImageIO.read(getClass().getResourceAsStream(dealerHand.get(1)));
					G.drawImage(cardDealer2,380+50,110,73,97,null);
					
					if(showDealerLastCards == true) {
						for(int l=2;l<dealerHand.size();l++) {
							BufferedImage restCard = ImageIO.read(getClass().getResourceAsStream(dealerHand.get(l)));
							G.drawImage(restCard,500+50*i,110,73,97,null);
						}
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(i == 0) {
				if(listBoolBustedPlayers.get(i) == false) {
					for(int j=0; j<handSizesPlayers.get(i); j++) {
						try {
							BufferedImage cardP1 = ImageIO.read(getClass().getResourceAsStream(playersHands.get(i).get(j)));
							G.drawImage(cardP1,10+50*j/handSizesPlayers.get(i),460,73,97,null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			else if(i == 1) {
				if(listBoolBustedPlayers.get(i) == false) {
					for(int j=0; j<handSizesPlayers.get(i); j++) {
						try {
							BufferedImage cardP2 = ImageIO.read(getClass().getResourceAsStream(playersHands.get(i).get(j)));
							G.drawImage(cardP2,250+50*j/handSizesPlayers.get(i),570,73,97,null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			else if(i == 2) {
				if(listBoolBustedPlayers.get(i) == false) {
					for(int j=0; j<handSizesPlayers.get(i); j++) {
						try {
							BufferedImage cardP3 = ImageIO.read(getClass().getResourceAsStream(playersHands.get(i).get(j)));
							G.drawImage(cardP3,600+50*j/handSizesPlayers.get(i),570,73,97,null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			else if(i == 3) {
				if(listBoolBustedPlayers.get(i) == false) {
					for(int j=0; j<handSizesPlayers.get(i); j++) {
						try {
							BufferedImage cardP4 = ImageIO.read(getClass().getResourceAsStream(playersHands.get(i).get(j)));
							G.drawImage(cardP4,820+50*j/handSizesPlayers.get(i),460,73,97,null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			i++;
		}
		
		if(haVencedor == true) {
			G.setFont(new Font("TimesRoman", Font.BOLD, 50));
			G.setColor(Color.ORANGE);
			G.drawString(vencedor, 200, 370);
		}
		
		
		setOpaque(false);
		super.paint(G);
		setOpaque(true);
	}
	
	
	public void addPlayerCards(int player, boolean busted) {
		
		if(player == -1) {
			isDealer = true;
			for(int i=0; i<2; i++) {
				dealerHand.add(Game.GetCard(player, i, 0));
			}
		}
		
		else {
			isDealer = false;
			normalTurn = true;
			ArrayList<String> playerHand = new ArrayList<String>();
			playersHands.add(playerHand);
			
			handSizesPlayers.add(Game.GetHandSize(player,0));
			for(int i=0; i<handSizesPlayers.get(player); i++) {
			
				playersHands.get(player).add(Game.GetCard(player, i,Game.BestHand(player)));			
			}
			listBoolBustedPlayers.add(busted);
		}
		this.paint(getGraphics());
	}
	
	
	public void revealDealerCard() {
		endRound = true;
		this.paint(getGraphics());
	}
	
	public void finishDealer() {
		Game.DealerFinish();
		for(int i=2; i<Game.GiveDealerHand().size(); i++) {
			dealerHand.add(Game.GetCard(-1, i, 0));
		}
		showDealerLastCards = true;
		this.paint(getGraphics());
	}
	
	public void exibeVencedor(int player, ArrayList<String> Jogadores) {
		if(player == -2)
			vencedor = "Foi empate!";
		else if(player == -1)
			vencedor = "O vencedor foi o Dealer!";
		else
			vencedor = "O vencedor é "+Jogadores.get(player)+"!";
		haVencedor = true;
		this.paint(getGraphics());
	}
}
