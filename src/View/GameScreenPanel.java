package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class GameScreenPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private BufferedImage bg;
	public GameScreenPanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(449, 5, 2, 2);
		add(scrollPane);
		
		JButton btnEncerrarPartida = new JButton("Encerrar Partida");
		btnEncerrarPartida.setBounds(376, 553, 132, 39);
		btnEncerrarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnEncerrarPartida);
		
		JButton btnNovaRodada = new JButton("Nova rodada");
		btnNovaRodada.setBounds(77, 553, 132, 39);
		btnNovaRodada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNovaRodada);
		
		JButton btnSalvarJogo = new JButton("Salvar Jogo");
		btnSalvarJogo.setBounds(670, 553, 132, 39);
		btnSalvarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnSalvarJogo);
		
		try {
			bg= ImageIO.read(getClass().getResourceAsStream("/blackjackBKG.png"));
		} catch(IOException e) {
			System.out.println("Não carregou imagem");
		}
		repaint();
	}
	
	
	public void paint(Graphics G) {
		G.drawImage(bg, 0,0,bg.getWidth(),bg.getHeight(),null);
		setOpaque(false);
		super.paint(G) ;
		//setOpaque(true);
	}
}
