import java.awt.BorderLayout;
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

public class telaFilmes extends JFrame {

	private JPanel contentPane;
	private static JFrame telaFilmesInstance;
	private JTextField textFieldNome;
	private Fachada fachada;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel icone = new JLabel("Icone");
		icone.setBounds(245, 11, 76, 48);
		contentPane.add(icone);
		ImageIcon filmes = new ImageIcon(telaFilmes.class.getResource("/icones/filmes.png"));
		Image imag = filmes.getImage().getScaledInstance(icone.getWidth(), icone.getHeight(), Image.SCALE_DEFAULT);
		icone.setIcon(new ImageIcon(imag));
		
		JLabel lblTelaFilmes = new JLabel("Filmes");
		lblTelaFilmes.setForeground(SystemColor.windowBorder);
		lblTelaFilmes.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelaFilmes.setBounds(89, 11, 63, 14);
		contentPane.add(lblTelaFilmes);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 61, 215, 153);
		contentPane.add(panel);
		
		textFieldNome = new JTextField();
		textFieldNome.setText("Insira o nome do filme");
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(10, 11, 196, 20);
		panel.add(textFieldNome);
		
		JTextArea textDadosFilme = new JTextArea();
		textDadosFilme.setBounds(10, 42, 196, 100);
		panel.add(textDadosFilme);
		
		JButton btnCadastrar = new JButton("Cadastrar novo filme");
		btnCadastrar.setBounds(21, 36, 193, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroFilmes.getInstance().setVisible(true);
				dispose();
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(229, 143, 104, 23);
		contentPane.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fachada.getInstance().removerFilme(textFieldNome.getText());
				int resposta = JOptionPane.showConfirmDialog(null, "Confirmar remoção?");
				if(resposta == 0)
					JOptionPane.showMessageDialog(null, "Filme removido com sucesso");
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(229, 109, 104, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarFilme.getInstance().setVisible(true);
				dispose();
			}
		});
								
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(229, 71, 104, 23);
		contentPane.add(btnProcurar);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Filme filme = new Filme();
				String nome;
				try{
					nome = textFieldNome.getText();
					filme = fachada.getInstance().procurarFilme(nome);
					textDadosFilme.append(filme.toString());
				}
				catch(NullPointerException npe){
					JOptionPane.showMessageDialog(null, "Insira o nome do filme");
				}
				/*catch(FilmeNaoEncontrado fnee){
					JOptionPane.showMessageDialog(null, fnee.getMessage);
				}*/
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(229, 177, 104, 23);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                telaPrincipal.getInstance().setVisible(true);
                dispose();
			}
		});
	}
}
