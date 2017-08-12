import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
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
		setTitle("Video-Locadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoSelecione = new JLabel("Bem-vindo");
		lblBemVindoSelecione.setFont(new Font("Arial", Font.BOLD, 21));
		lblBemVindoSelecione.setForeground(SystemColor.windowBorder);
		lblBemVindoSelecione.setBackground(SystemColor.windowText);
		lblBemVindoSelecione.setBounds(116, 11, 122, 30);
		contentPane.add(lblBemVindoSelecione);
		
		JButton btnFilmes = new JButton("Filmes");
		btnFilmes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFilmes.setBounds(30, 116, 89, 51);
		contentPane.add(btnFilmes);
		btnFilmes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaFilmes.getInstance().setVisible(true);
                telaPrincipal.this.setVisible(false);
            }
        });
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClientes.setBounds(233, 116, 89, 51);
		contentPane.add(btnClientes);
		
		JButton btnLocacao = new JButton("Loca\u00E7\u00E3o");
		btnLocacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLocacao.setBounds(131, 116, 89, 51);
		contentPane.add(btnLocacao);
		
		JLabel lblNewLabel = new JLabel("Selecione a \u00E1rea de trabalho");
		lblNewLabel.setBackground(new Color(255, 51, 51));
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 52, 238, 30);
		contentPane.add(lblNewLabel);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaClientes.getInstance().setVisible(true);
                telaPrincipal.this.setVisible(false);
			}
		});
	}
}
