import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.RepositorioFilmesArray;
import negocio.Filme;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class procurarFilmes extends JFrame {

	private JPanel contentPane;
	private static procurarFilmes procurarFilmesInstance = new procurarFilmes();
	private JTextField textFieldFilme;
	
	public static JFrame getInstance(){
		if(procurarFilmesInstance == null)
			procurarFilmesInstance = new procurarFilmes();
		
		return procurarFilmesInstance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					procurarFilmes frame = new procurarFilmes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public procurarFilmes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 239, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldFilme = new JTextField();
		textFieldFilme.setBounds(10, 11, 196, 20);
		contentPane.add(textFieldFilme);
		textFieldFilme.setColumns(10);
		
		JTextArea textAreaDados = new JTextArea();
		textAreaDados.setBounds(10, 81, 196, 100);
		contentPane.add(textAreaDados);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldFilme.equals(""))
					JOptionPane.showMessageDialog(null, "Insira o nome do filme");
				else{
					Filme achouFilme = RepositorioFilmesArray.getInstance().procurar(textFieldFilme.getText()); 
					if(achouFilme == null)
						JOptionPane.showMessageDialog(null, "Filme não encontrado");
					else
						textAreaDados.append(achouFilme.toString());
				}					
			}
		});
		btnProcurar.setBounds(10, 42, 97, 23);
		contentPane.add(btnProcurar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				procurarFilmes.this.setVisible(false);
				telaFilmes.getInstance().setVisible(true);
			}
		});
		btnCancelar.setBounds(117, 42, 89, 23);
		contentPane.add(btnCancelar);
	}
}
