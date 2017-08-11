import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.RepositorioFilmesArray;
import negocio.Filme;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastroFilmes extends JFrame {

	private JPanel contentPane;
	private static JFrame cadastroFilmesInstance;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;
	private JTextField textFieldGenero;
	private JTextField textFieldNome;
	private RepositorioFilmesArray repositorio = new RepositorioFilmesArray();
	
	public static JFrame getInstance(){
		if(cadastroFilmesInstance == null)
			cadastroFilmesInstance = new cadastroFilmes();
		
		return cadastroFilmesInstance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroFilmes frame = new cadastroFilmes();
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
	public cadastroFilmes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(88, 60, 56, 20);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(88, 85, 56, 20);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setBounds(88, 36, 118, 20);
		contentPane.add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(88, 14, 118, 20);
		contentPane.add(textFieldNome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(10, 39, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 63, 75, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblValor = new JLabel("Valor (R$):");
		lblValor.setBounds(10, 88, 68, 14);
		contentPane.add(lblValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme filme = new Filme();
				filme.setNome(textFieldNome.getText());
				filme.setGenero(textFieldGenero.getText());
				filme.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
				filme.setValor(Double.parseDouble(textFieldValor.getText()));
				repositorio.getInstance().inserir(filme);
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
				textFieldNome.setText("");
				textFieldGenero.setText("");
				textFieldQuantidade.setText("");
				textFieldValor.setText("");
				cadastroFilmes.this.setVisible(false);
				telaFilmes.getInstance().setVisible(true);
			}
		});

		btnCadastrar.setBounds(215, 13, 109, 60);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroFilmes.this.setVisible(false);
				telaFilmes.getInstance().setVisible(true);
			}
		});
		btnCancelar.setBounds(215, 84, 109, 23);
		contentPane.add(btnCancelar);
	}
}
