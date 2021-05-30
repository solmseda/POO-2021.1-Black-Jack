package View;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class GameScreenPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	/**
	 * Create the panel.
	 */
	private BufferedImage backgroundImage;
	public GameScreenPanel() {
		setLayout(null);
			
		JButton btnEncerrarPartida = new JButton("Encerrar Partida");
		btnEncerrarPartida.setBounds(744, 111, 132, 39);
		btnEncerrarPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEncerrarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnEncerrarPartida);
		
		JButton btnNovaRodada = new JButton("Nova rodada");
		btnNovaRodada.setBounds(744, 11, 132, 39);
		btnNovaRodada.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNovaRodada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNovaRodada);
		
		JButton btnSalvarJogo = new JButton("Salvar Jogo");
		btnSalvarJogo.setBounds(744, 61, 132, 39);
		btnSalvarJogo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnSalvarJogo);
		
		try {
			backgroundImage = ImageIO.read(getClass().getResourceAsStream("/blackjackBKG.png"));
		} catch(IOException e) {
			System.out.println("Não carregou imagem de fundo");
		}
		
	}
	
	
	public void paint(Graphics G) {
		G.drawImage(backgroundImage, 0,0,backgroundImage.getWidth(),backgroundImage.getHeight(),null);
		setOpaque(false);
		super.paint(G) ;
		//setOpaque(true);
	}
}
