package View;

import Controller.Setup;

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
import javax.swing.JLabel;
import java.awt.Color;


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
		
		System.out.println(Setup.Jogadores);
			
		JButton btnEncerrarPartida = new JButton("Encerrar Partida");
		btnEncerrarPartida.setBounds(744, 111, 132, 39);
		btnEncerrarPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEncerrarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		add(btnEncerrarPartida);
		
		JButton btnNovaRodada = new JButton("Nova rodada");
		btnNovaRodada.setBounds(744, 11, 132, 39);
		btnNovaRodada.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNovaRodada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Setup.NewMatch(); 
				PlayerScreen game = new PlayerScreen();
				game.setVisible(true);
			}
		});
		add(btnNovaRodada);
		
		JButton btnSalvarJogo = new JButton("Salvar Jogo");
		btnSalvarJogo.setBounds(744, 61, 132, 39);
		btnSalvarJogo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Depois
			}
		});
		add(btnSalvarJogo);
		
		JLabel lblApostaMinimaTitulo = new JLabel("Aposta m\u00EDnima:");
		lblApostaMinimaTitulo.setForeground(Color.LIGHT_GRAY);
		lblApostaMinimaTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApostaMinimaTitulo.setBounds(138, 66, 115, 26);
		add(lblApostaMinimaTitulo);
		
		String sufix = " créditos";
		String apostaMin = String.valueOf(Setup.apostaMinima)+sufix;
		
		JLabel lblCreditos = new JLabel("0 cr\u00E9ditos");
		lblCreditos.setText(apostaMin);
		lblCreditos.setForeground(Color.LIGHT_GRAY);
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreditos.setBounds(148, 87, 93, 26);
		add(lblCreditos);
		
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
