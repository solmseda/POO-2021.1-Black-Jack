package View;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;

public class InitialScreenPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	private BufferedImage backgroundImage;
	private JTextField NomeJogador_1;
	private JTextField NomeJogador_2;
	private JTextField NomeJogador_3;
	private JTextField NomeJogador_4;
	public ArrayList<String> Jogadores;
	
	/**
	 * Create the panel.
	 */
	public InitialScreenPanel() {
		setLayout(null);
		
		JButton btnNovaPartida = new JButton("Nova Partida");
		btnNovaPartida.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNovaPartida.setBounds(652, 165, 143, 32);
		add(btnNovaPartida);
		
		JButton btnCarregarPartida = new JButton("Carregar Partida");
		btnCarregarPartida.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCarregarPartida.setBounds(652, 223, 143, 32);
		add(btnCarregarPartida);
		
		JSpinner NumJogadores = new JSpinner();
		NumJogadores.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		NumJogadores.setFont(new Font("Tahoma", Font.BOLD, 12));
		NumJogadores.setBounds(662, 134, 82, 20);
		((JSpinner.DefaultEditor) NumJogadores.getEditor()).getTextField().setEditable(false);
		NumJogadores.setVisible(false);
		add(NumJogadores);
		
		JLabel lblNúmeroJogadores = new JLabel("N\u00FAmero de Jogadores:");
		lblNúmeroJogadores.setForeground(Color.BLACK);
		lblNúmeroJogadores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNúmeroJogadores.setBounds(638, 104, 167, 32);
		lblNúmeroJogadores.setVisible(false);
		add(lblNúmeroJogadores);
		
		JLabel lblNomesJogadores = new JLabel("Nomes dos Jogadores:");
		lblNomesJogadores.setForeground(Color.BLACK);
		lblNomesJogadores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomesJogadores.setBounds(638, 164, 167, 32);
		lblNomesJogadores.setVisible(false);
		add(lblNomesJogadores);
		
		NomeJogador_1 = new JTextField();
		NomeJogador_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NomeJogador_1.setColumns(10);
		NomeJogador_1.setBounds(662, 193, 143, 20);
		NomeJogador_1.setVisible(false);
		add(NomeJogador_1);
		
		NomeJogador_2 = new JTextField();
		NomeJogador_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NomeJogador_2.setColumns(10);
		NomeJogador_2.setBounds(662, 218, 143, 20);
		NomeJogador_2.setVisible(false);
		add(NomeJogador_2);
		
		NomeJogador_3 = new JTextField();
		NomeJogador_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NomeJogador_3.setColumns(10);
		NomeJogador_3.setBounds(662, 242, 143, 20);
		NomeJogador_3.setVisible(false);
		add(NomeJogador_3);
		
		NomeJogador_4 = new JTextField();
		NomeJogador_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NomeJogador_4.setColumns(10);
		NomeJogador_4.setBounds(662, 267, 143, 20);
		NomeJogador_4.setVisible(false);
		add(NomeJogador_4);
		
		JLabel lblP1 = new JLabel("P1:");
		lblP1.setForeground(Color.BLACK);
		lblP1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblP1.setBounds(638, 192, 24, 20);
		lblP1.setVisible(false);
		add(lblP1);
		
		JLabel lblP2 = new JLabel("P2:");
		lblP2.setForeground(Color.BLACK);
		lblP2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblP2.setBounds(638, 217, 24, 20);
		lblP2.setVisible(false);
		add(lblP2);
		
		JLabel lblP3 = new JLabel("P3:");
		lblP3.setForeground(Color.BLACK);
		lblP3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblP3.setBounds(638, 241, 24, 20);
		lblP3.setVisible(false);
		add(lblP3);
		
		JLabel lblP4 = new JLabel("P4:");
		lblP4.setForeground(Color.BLACK);
		lblP4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblP4.setBounds(638, 266, 24, 20);
		lblP4.setVisible(false);
		add(lblP4);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(688, 222, 92, 20);
		btnVoltar.setVisible(false);
		add(btnVoltar);
		
		JButton btnComecarPartida = new JButton("Come\u00E7ar partida");
		btnComecarPartida.setEnabled(false);
		btnComecarPartida.setForeground(Color.RED);
		btnComecarPartida.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnComecarPartida.setBounds(364, 333, 157, 32);
		btnComecarPartida.setVisible(false);
		add(btnComecarPartida);
		
		//Carrega Imagem Inicial
		try {
			backgroundImage = ImageIO.read(getClass().getResourceAsStream("/Blackjack-Game.png"));
		} catch(IOException e) {
			System.out.println("Não carregou imagem de entrada");
			System.exit(-1);
		}
		
		btnNovaPartida.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        btnNovaPartida.setVisible(false);
		        btnCarregarPartida.setVisible(false);
		        NumJogadores.setVisible(true);
		        lblNúmeroJogadores.setVisible(true);
		        lblNomesJogadores.setVisible(true);
		        NomeJogador_1.setVisible(true);
		        lblP1.setVisible(true);
		        btnVoltar.setVisible(true);
		        btnComecarPartida.setVisible(true);
		    }
		});
		
		btnVoltar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnNovaPartida.setVisible(true);
		        btnCarregarPartida.setVisible(true);
		        NumJogadores.setVisible(false);
		        NumJogadores.setValue(1);
		        lblNúmeroJogadores.setVisible(false);
		        lblNomesJogadores.setVisible(false);
		        NomeJogador_1.setVisible(false);
		        NomeJogador_1.setText("");
		        NomeJogador_2.setVisible(false);
		        NomeJogador_2.setText("");
		        NomeJogador_3.setVisible(false);
		        NomeJogador_3.setText("");
		        NomeJogador_4.setVisible(false);
		        NomeJogador_4.setText("");
		        lblP1.setVisible(false);
		        btnVoltar.setVisible(false);
		        btnComecarPartida.setVisible(false);
		    }
		});
		
		NumJogadores.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {
					NomeJogador_1.setVisible(true);
			        lblP1.setVisible(true);
			        NomeJogador_2.setVisible(false);
			        lblP2.setVisible(false);
			        NomeJogador_3.setVisible(false);
			        lblP3.setVisible(false);
			        NomeJogador_4.setVisible(false);
			        lblP4.setVisible(false);
			        btnVoltar.setBounds(688, 222, 92, 20);
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					NomeJogador_1.setVisible(true);
			        lblP1.setVisible(true);
			        NomeJogador_2.setVisible(true);
			        lblP2.setVisible(true);
			        NomeJogador_3.setVisible(false);
			        lblP3.setVisible(false);
			        NomeJogador_4.setVisible(false);
			        lblP4.setVisible(false);
			        btnVoltar.setBounds(688, 247, 92, 20);
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					NomeJogador_1.setVisible(true);
			        lblP1.setVisible(true);
			        NomeJogador_2.setVisible(true);
			        lblP2.setVisible(true);
			        NomeJogador_3.setVisible(true);
			        lblP3.setVisible(true);
			        NomeJogador_4.setVisible(false);
			        lblP4.setVisible(false);
			        btnVoltar.setBounds(688, 272, 92, 20);
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					NomeJogador_1.setVisible(true);
			        lblP1.setVisible(true);
			        NomeJogador_2.setVisible(true);
			        lblP2.setVisible(true);
			        NomeJogador_3.setVisible(true);
			        lblP3.setVisible(true);
			        NomeJogador_4.setVisible(true);
			        lblP4.setVisible(true);
			        btnVoltar.setBounds(688, 297, 92, 20);
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
		});
		
		
		//Tentar criar uma função só para as chamadas dos 4 jogadores para não repitir código...
		//Depois nós podemos fazer uma limitação para que 2 jogadores não tenham o mesmo nome ou então adicionar um "(2), (3), (4)" no jogador repetido.
		
		NomeJogador_1.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			@Override
			public void insertUpdate(DocumentEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {	
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {	
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
		});
		
		NomeJogador_2.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			@Override
			public void insertUpdate(DocumentEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {	
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {	
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
		});
		
		NomeJogador_3.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			@Override
			public void insertUpdate(DocumentEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {	
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {	
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
		});
		
		NomeJogador_4.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			@Override
			public void insertUpdate(DocumentEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {	
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				if((Integer)NumJogadores.getValue() == 1) {	
					if(NomeJogador_1.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 2) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else if((Integer)NumJogadores.getValue() == 3) {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
				else {
					if(NomeJogador_1.getText().length() > 0 && NomeJogador_2.getText().length() > 0 && NomeJogador_3.getText().length() > 0 && NomeJogador_4.getText().length() > 0)
						btnComecarPartida.setEnabled(true);
					else
						btnComecarPartida.setEnabled(false);
				}
			}
		});
		
		btnComecarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogadores = new ArrayList<String>();
				for(int i=1; i<=(Integer)NumJogadores.getValue(); i++) {
					if(i==1)
						Jogadores.add(NomeJogador_1.getText());
					else if(i==2)
						Jogadores.add(NomeJogador_2.getText());
					else if(i==3)
						Jogadores.add(NomeJogador_3.getText());
					else
						Jogadores.add(NomeJogador_4.getText());
				}
				System.out.println(Jogadores);
				System.exit(0);
			}
		});
		
	}
	
	public void paint(Graphics G) {
		G.drawImage(backgroundImage, 0,0,backgroundImage.getWidth(),backgroundImage.getHeight(),null);
		setOpaque(false);
		super.paint(G) ;
		//setOpaque(true);
	}
	
}

//Teste AA
