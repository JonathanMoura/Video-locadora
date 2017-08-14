import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Fachada;
import negocio.Filme;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import excecoes.*;

public class telaFilmes extends JFrame {

	private JPanel contentPane;
	private static JFrame telaFilmesInstance;
	private JTextField textFieldNome;
	private Fachada fachada;
	private JTextField textFieldGenero;
	private JTextField textFieldQuantia;
	private JTextField textFieldValor;
	private JTextField textFieldProcurar;

	public static JFrame getInstance(){
        if(telaFilmes.telaFilmesInstance == null)
            telaFilmes.telaFilmesInstance = new telaFilmes();
         
        return telaFilmes.telaFilmesInstance;
         
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaFilmes frame = new telaFilmes();
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
	public telaFilmes() {
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("Banco de dados - Filmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel icone = new JLabel("Icone");
		icone.setBounds(10, 11, 60, 60);
		contentPane.add(icone);
		ImageIcon filmes = new ImageIcon(telaFilmes.class.getResource("/icones/filmes.png"));
		Image imag = filmes.getImage().getScaledInstance(icone.getWidth(), icone.getHeight(), Image.SCALE_DEFAULT);
		icone.setIcon(new ImageIcon(imag));
		
		textFieldProcurar = new JTextField();
		textFieldProcurar.setForeground(SystemColor.windowBorder);
		textFieldProcurar.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldProcurar.setBounds(108, 41, 179, 29);
		contentPane.add(textFieldProcurar);
		textFieldProcurar.setText("Insira o nome");
		textFieldProcurar.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setForeground(SystemColor.desktop);
		textFieldNome.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldNome.setBounds(108, 133, 356, 25);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setText("");
		textFieldGenero.setForeground(Color.BLACK);
		textFieldGenero.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldGenero.setColumns(10);
		textFieldGenero.setBounds(108, 166, 356, 25);
		contentPane.add(textFieldGenero);
		
		textFieldQuantia = new JTextField();
		textFieldQuantia.setText("");
		textFieldQuantia.setForeground(Color.BLACK);
		textFieldQuantia.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldQuantia.setColumns(10);
		textFieldQuantia.setBounds(108, 199, 356, 25);
		contentPane.add(textFieldQuantia);
		
		textFieldValor = new JTextField();
		textFieldValor.setText("");
		textFieldValor.setForeground(Color.BLACK);
		textFieldValor.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(108, 230, 356, 25);
		contentPane.add(textFieldValor);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 140, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setForeground(SystemColor.windowBorder);
		lblGenero.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGenero.setBounds(10, 173, 98, 14);
		contentPane.add(lblGenero);
		
		JLabel lblQuantia = new JLabel("Quantia");
		lblQuantia.setForeground(SystemColor.windowBorder);
		lblQuantia.setFont(new Font("Arial", Font.PLAIN, 18));
		lblQuantia.setBounds(10, 207, 98, 14);
		contentPane.add(lblQuantia);
		
		JLabel lblPreco = new JLabel("Valor:");
		lblPreco.setForeground(SystemColor.windowBorder);
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPreco.setBounds(10, 238, 98, 14);
		contentPane.add(lblPreco);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setForeground(SystemColor.windowBorder);
		btnProcurar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnProcurar.setBounds(325, 40, 120, 31);
		contentPane.add(btnProcurar);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Filme achouFilme = new Filme();
				try{
					achouFilme = fachada.getInstance().procurarFilme(textFieldProcurar.getText());
					textFieldNome.setText(achouFilme.getNome());
					textFieldGenero.setText(achouFilme.getGenero());
					textFieldQuantia.setText(Integer.toString(achouFilme.getQuantia()));
					textFieldValor.setText(Double.toString(achouFilme.getValor()));
					textFieldProcurar.setText("Insira o nome");
				}
				catch(FilmeNaoEncontradoException fnee){
					JOptionPane.showMessageDialog(null, fnee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(SystemColor.windowBorder);
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCadastrar.setBounds(501, 40, 120, 31);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme filme = new Filme();
				int resposta;
				String valor, quantia;
				try{
					resposta = JOptionPane.showConfirmDialog(null, "Confirmar cadastro");
					if(resposta == 0){
						filme.setNome(textFieldNome.getText());
						filme.setGenero(textFieldGenero.getText());
						
						quantia = textFieldQuantia.getText();
						valor = textFieldValor.getText();
						
						if(quantia.equals("") || valor.equals("")){
							CampoVazioException cve = new CampoVazioException();
							throw cve;
						}
						filme.setQuantia(Integer.parseInt(quantia));
						filme.setValor(Double.parseDouble(valor));
						fachada.getInstance().cadastrarFilme(filme);
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
						textFieldNome.setText("");
						textFieldGenero.setText("");
						textFieldQuantia.setText("");
						textFieldValor.setText("");
						textFieldProcurar.setText("Insira o nome");
					}
				}
				catch(FilmeExistenteException fee){
					JOptionPane.showMessageDialog(null, fee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(SystemColor.windowBorder);
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAtualizar.setBounds(501, 131, 120, 31);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme filme = new Filme();
				int resposta;
				String quantia, valor;
				try{
					resposta = JOptionPane.showConfirmDialog(null,"Confirmar atualização do filme?");
					if(resposta == 0){
						filme.setNome(textFieldNome.getText());
						filme.setGenero(textFieldGenero.getText());
						
						quantia = textFieldQuantia.getText();
						valor = textFieldValor.getText();
						
						if(quantia.equals("") || valor.equals("")){
							CampoVazioException cve = new CampoVazioException();
							throw cve;
						}
						filme.setQuantia(Integer.parseInt(textFieldQuantia.getText()));
						filme.setValor(Double.parseDouble(textFieldValor.getText()));
						fachada.getInstance().atualizarFilme(filme);
						JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso");
						textFieldNome.setText("");
						textFieldGenero.setText("");
						textFieldQuantia.setText("");
						textFieldValor.setText("");
						textFieldProcurar.setText("Insira o nome");
					}
				}
				catch(FilmeNaoEncontradoException fnee){
					JOptionPane.showMessageDialog(null, fnee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(SystemColor.windowBorder);
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRemover.setBounds(501, 178, 120, 31);
		contentPane.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta;
				try{
					resposta = JOptionPane.showConfirmDialog(null,"Confirmar remoção de " + textFieldNome.getText());
					if(resposta == 0){
						fachada.getInstance().removerFilme(textFieldNome.getText());
						JOptionPane.showMessageDialog(null, "Filme removido com sucesso");
						textFieldNome.setText("");
						textFieldGenero.setText("");
						textFieldQuantia.setText("");
						textFieldValor.setText("");
						textFieldProcurar.setText("Insira o nome");
					}
				}
				catch(FilmeNaoEncontradoException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage());
				}
				catch(NomeVazioException nve){
					JOptionPane.showMessageDialog(null, nve.getMessage());
				}
			}
		});
				
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(SystemColor.windowBorder);
		btnSair.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSair.setBounds(501, 224, 120, 31);
		contentPane.add(btnSair);	
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldGenero.setText("");
				textFieldQuantia.setText("");
				textFieldValor.setText("");
				textFieldProcurar.setText("Insira o nome");
                telaPrincipal.getInstance().setVisible(true);
                dispose();
			}
		});
	}
}
