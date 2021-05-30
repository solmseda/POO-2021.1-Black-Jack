package View;

import javax.swing.JPanel;

import Controller.Setup;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class PlayerScreenPanel extends JPanel {

	private static final long serialVersionUID = 1L;
    private BufferedImage card;

	/**
	 * Create the panel.
	 */
	public PlayerScreenPanel() {
		setBackground(new Color(0, 128, 0));
		setLayout(null);
		
		JLabel lblPontuacaoTitulo = new JLabel("Pontua\u00E7\u00E3o:");
		lblPontuacaoTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblPontuacaoTitulo.setBounds(332, 21, 107, 47);
		add(lblPontuacaoTitulo);
		
		JLabel lblPontuacao = new JLabel("0");
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
		
		JLabel lblCreditos = new JLabel("0");
		lblCreditos.setFont(new Font("Calibri", Font.BOLD, 26));
		lblCreditos.setBounds(243, 57, 28, 47);
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

	}
	public void paint(Graphics G) {
		G.setColor(getBackground());
		G.fillRect(0, 0, getWidth(), getHeight());
        int x=90;
        for(int i=0;i<2;i++) {
        	String cardstring= Setup.GetCard(0,i);
	        try {
	            card= ImageIO.read(getClass().getResourceAsStream(cardstring));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        G.drawImage(card, x,150,card.getWidth()*2,card.getHeight()*2,null);
	        x+=card.getWidth()*2+20;
        }
		setOpaque(false);
		super.paint(G) ;
		setOpaque(true);
    }
}
