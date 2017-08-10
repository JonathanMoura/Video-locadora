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

public class telaPrincipal extends JFrame {

	private JPanel contentPane;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFilmes = new JButton("Filmes");
		btnFilmes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaFilmes.getInstance().setVisible(true);
            }
        });
		btnFilmes.setBounds(48, 80, 89, 51);
		contentPane.add(btnFilmes);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaClientes.getInstance().setVisible(true);
			}
		});
		btnClientes.setBounds(186, 80, 89, 51);
		contentPane.add(btnClientes);
		
		JLabel lblBemVindoSelecione = new JLabel("Bem vindo, selecione a \u00E1rea de trabalho");
		lblBemVindoSelecione.setBounds(48, 29, 227, 14);
		contentPane.add(lblBemVindoSelecione);
	}
}
