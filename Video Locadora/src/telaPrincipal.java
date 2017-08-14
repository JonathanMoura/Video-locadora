import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class telaPrincipal extends JFrame {

	private JPanel contentPane;
	private static telaPrincipal instance;
	
	public static JFrame getInstance(){
		if(instance == null)
			instance = new telaPrincipal();
		
		return instance;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal frame = new telaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public telaPrincipal() {
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("Locadora de filmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoSelecione = new JLabel("Bem-vindo");
		lblBemVindoSelecione.setFont(new Font("Arial", Font.BOLD, 21));
		lblBemVindoSelecione.setForeground(SystemColor.windowBorder);
		lblBemVindoSelecione.setBackground(SystemColor.windowText);
		lblBemVindoSelecione.setBounds(260, 11, 122, 30);
		contentPane.add(lblBemVindoSelecione);
		
		JLabel lblNewLabel = new JLabel("Selecione a \u00E1rea de trabalho");
		lblNewLabel.setBackground(new Color(255, 51, 51));
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(204, 52, 238, 30);
		contentPane.add(lblNewLabel);
						
		JLabel iconeFilme = new JLabel("New label");
		iconeFilme.setBounds(50, 113, 60, 60);
		contentPane.add(iconeFilme);
		ImageIcon filmes = new ImageIcon(telaPrincipal.class.getResource("/icones/filmes.png"));
		Image imag1 = filmes.getImage().getScaledInstance(iconeFilme.getWidth(), iconeFilme.getHeight(), Image.SCALE_DEFAULT);
		iconeFilme.setIcon(new ImageIcon(imag1));
		
		JLabel iconeLocacao = new JLabel("New label");
		iconeLocacao.setBounds(297, 113, 60, 60);
		contentPane.add(iconeLocacao);
		ImageIcon alugueis = new ImageIcon(telaPrincipal.class.getResource("/icones/alugueis.png"));
		Image imag2 = alugueis.getImage().getScaledInstance(iconeLocacao.getWidth(), iconeLocacao.getHeight(), Image.SCALE_DEFAULT);
		iconeLocacao.setIcon(new ImageIcon(imag2));
		
		JLabel iconeCliente = new JLabel("Icone");
		iconeCliente.setBounds(500, 113, 60, 60);
		contentPane.add(iconeCliente);
		ImageIcon clientes = new ImageIcon(telaPrincipal.class.getResource("/icones/clientes.png"));
		Image imag3 = clientes.getImage().getScaledInstance(iconeCliente.getWidth(), iconeCliente.getHeight(), Image.SCALE_DEFAULT);
		iconeCliente.setIcon(new ImageIcon(imag3));		
		
		JButton btnFilmes = new JButton("Filmes");
		btnFilmes.setForeground(SystemColor.windowBorder);
		btnFilmes.setFont(new Font("Arial", Font.BOLD, 18));
		btnFilmes.setBounds(31, 184, 111, 51);
		contentPane.add(btnFilmes);
		btnFilmes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaFilmes.getInstance().setVisible(true);
                telaPrincipal.this.setVisible(false);
            }
        });
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setForeground(SystemColor.windowBorder);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 18));
		btnClientes.setBounds(478, 184, 111, 51);
		contentPane.add(btnClientes);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaClientes.getInstance().setVisible(true);
                telaPrincipal.this.setVisible(false);
			}
		});
		
		JButton btnLocacao = new JButton("Loca\u00E7\u00E3o");
		btnLocacao.setForeground(SystemColor.windowBorder);
		btnLocacao.setFont(new Font("Arial", Font.BOLD, 18));
		btnLocacao.setBounds(271, 184, 111, 51);
		contentPane.add(btnLocacao);
		btnLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaLocacao.getInstance().setVisible(true);
				dispose();
			}
		});
	}
}
