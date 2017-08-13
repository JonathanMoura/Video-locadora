import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.RepositorioFilmesArray;
import excecoes.*;
import negocio.Fachada;
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
	private Fachada fachada = new Fachada();
	
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
		setBounds(100, 100, 365, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(114, 92, 56, 20);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(114, 117, 56, 20);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setBounds(114, 68, 114, 20);
		contentPane.add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(114, 14, 198, 20);
		contentPane.add(textFieldNome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(36, 14, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(36, 71, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(36, 95, 75, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblValor = new JLabel("Valor (R$):");
		lblValor.setBounds(36, 120, 68, 14);
		contentPane.add(lblValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(36, 148, 109, 60);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme filme = new Filme();
				try{
					filme.setNome(textFieldNome.getText());
					filme.setGenero(textFieldGenero.getText());
					filme.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
					filme.setValor(Double.parseDouble(textFieldValor.getText()));
					fachada.getInstance().cadastrarFilme(filme);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
					textFieldNome.setText("");
					textFieldGenero.setText("");
					textFieldQuantidade.setText("");
					textFieldValor.setText("");
					telaFilmes.getInstance().setVisible(true);
					dispose();
				}
				catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Preencha os campos vazios");
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(203, 148, 109, 60);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaFilmes.getInstance().setVisible(true);
				dispose();
			}
		});
		
		JButton btnCadastrado = new JButton("Cadastrado?");
		btnCadastrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					fachada.getInstance().procurarFilme(textFieldNome.getText());
					JOptionPane.showMessageDialog(null, "Filme já cadastrado");
				}
				catch(NullPointerException npe){
					JOptionPane.showMessageDialog(null, "Insira o nome do filme");
				}
				catch(FilmeNaoEncontradoException fnee){
					JOptionPane.showMessageDialog(null, fnee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
		btnCadastrado.setBounds(114, 40, 114, 23);
		contentPane.add(btnCadastrado);
	}
}
