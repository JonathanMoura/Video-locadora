import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.*;
import negocio.Cliente;
import negocio.Filme;
import negocio.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class telaLocacao extends JFrame {

	private JPanel contentPane;
	private static telaLocacao instance;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textFieldProcurar;
	private JTextField textFieldEntrega;
	private JTextField textFieldNomeFilme;
	private JTextField textFieldValor;
	private Fachada fachada;
	private JTextField textFieldValorTotal;
	
	public static JFrame getInstance(){
		if(instance == null)
			instance = new telaLocacao();
		
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaLocacao frame = new telaLocacao();
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
	public telaLocacao() {
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("Banco de dados - Alugueis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon filmes = new ImageIcon(telaFilmes.class.getResource("/icones/filmes.png"));
		
		textFieldValor = new JTextField();
		textFieldValor.setForeground(Color.BLACK);
		textFieldValor.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(482, 28, 98, 29);
		contentPane.add(textFieldValor);
		
		textFieldProcurar = new JTextField();
		textFieldProcurar.setForeground(SystemColor.windowBorder);
		textFieldProcurar.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldProcurar.setBounds(108, 149, 179, 29);
		contentPane.add(textFieldProcurar);
		textFieldProcurar.setText("Insira o CPF");
		textFieldProcurar.setColumns(10);
		
		textFieldNomeFilme = new JTextField();
		textFieldNomeFilme.setForeground(Color.BLACK);
		textFieldNomeFilme.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldNomeFilme.setColumns(10);
		textFieldNomeFilme.setBounds(108, 194, 179, 25);
		contentPane.add(textFieldNomeFilme);
		
		textFieldEntrega = new JTextField();
		textFieldEntrega.setForeground(Color.BLACK);
		textFieldEntrega.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldEntrega.setColumns(10);
		textFieldEntrega.setBounds(108, 234, 179, 25);
		contentPane.add(textFieldEntrega);
		
		textFieldValorTotal = new JTextField();
		textFieldValorTotal.setText("0.0");
		textFieldValorTotal.setForeground(Color.BLACK);
		textFieldValorTotal.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldValorTotal.setColumns(10);
		textFieldValorTotal.setBounds(482, 76, 98, 29);
		contentPane.add(textFieldValorTotal);
		
		JLabel iconeLocacao = new JLabel("New label");
		iconeLocacao.setBounds(10, 11, 60, 60);
		contentPane.add(iconeLocacao);
		ImageIcon alugueis = new ImageIcon(telaPrincipal.class.getResource("/icones/alugueis.png"));
		Image imag2 = alugueis.getImage().getScaledInstance(iconeLocacao.getWidth(), iconeLocacao.getHeight(), Image.SCALE_DEFAULT);
		iconeLocacao.setIcon(new ImageIcon(imag2));
		
		JLabel lblValorTotalA = new JLabel("Valor total:");
		lblValorTotalA.setForeground(SystemColor.windowBorder);
		lblValorTotalA.setFont(new Font("Arial", Font.PLAIN, 18));
		lblValorTotalA.setBounds(330, 91, 120, 14);
		contentPane.add(lblValorTotalA);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(SystemColor.windowBorder);
		lblValor.setFont(new Font("Arial", Font.PLAIN, 18));
		lblValor.setBounds(330, 43, 120, 14);
		contentPane.add(lblValor);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setForeground(SystemColor.windowBorder);
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCliente.setBounds(10, 158, 98, 14);
		contentPane.add(lblCliente);
		
		JLabel lblFilme = new JLabel("Filme:");
		lblFilme.setForeground(SystemColor.windowBorder);
		lblFilme.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFilme.setBounds(10, 200, 98, 14);
		contentPane.add(lblFilme);
		
		JLabel lblDataDeEntrega = new JLabel("Entrega:");
		lblDataDeEntrega.setForeground(SystemColor.windowBorder);
		lblDataDeEntrega.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDataDeEntrega.setBounds(10, 238, 98, 19);
		contentPane.add(lblDataDeEntrega);
				
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setForeground(SystemColor.windowBorder);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setBounds(108, 25, 179, 29);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nomeFilme;
				String[] filmeAlugado;
				String [] dataEntrega;
				Filme filme = new Filme();
				Cliente achouCliente = new Cliente();
				try{
					nomeFilme = comboBox.getSelectedItem()+"";
					textFieldNomeFilme.setText(nomeFilme);
					filme = fachada.getInstance().procurarFilme(nomeFilme);
					textFieldValor.setText("R$"+Double.toString(filme.getValor()));
					achouCliente = fachada.getInstance().procurarCliente(textFieldProcurar.getText());
					filmeAlugado = achouCliente.getFilmeAlugado();
					if(filmeAlugado[0] == null){
						SemAluguelException sae = new SemAluguelException();
						throw sae;
					}
					dataEntrega = achouCliente.getDataEntrega();
					for(int i = 0; i < filmeAlugado.length; i++){
						if(filmeAlugado[i].equals(nomeFilme)){
							textFieldEntrega.setText(dataEntrega[i]);
							break;
						}
					}
				}
				catch(ClienteNaoEncontradoException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage());
				}
				catch(SemAluguelException sae){
					JOptionPane.showMessageDialog(null, sae.getMessage());
				}
				catch(FilmeNaoEncontradoException fnee){
					JOptionPane.showMessageDialog(null, fnee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
			
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setForeground(SystemColor.windowBorder);
		btnProcurar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnProcurar.setBounds(330, 148, 120, 31);
		contentPane.add(btnProcurar);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Cliente achouCliente = new Cliente();
				Filme filme = new Filme();
				String[] nomeFilme;
				String[] dataEntrega;
				String filmeAlugado;
				double valorTotal = 0;
				comboBox.removeAllItems();
				try{
					achouCliente = fachada.getInstance().procurarCliente(textFieldProcurar.getText());
					nomeFilme = achouCliente.getFilmeAlugado();
					
					if(nomeFilme[0] == null){
						SemAluguelException sae = new SemAluguelException();
						throw sae;
					}
					dataEntrega = achouCliente.getDataEntrega();
					for(int i = 0; i < nomeFilme.length; i++){
						if(nomeFilme[i] == null)
							break;
						comboBox.addItem(nomeFilme[i]);
						filme = fachada.getInstance().procurarFilme(nomeFilme[i]);
						valorTotal += filme.getValor();
					}
					filmeAlugado = comboBox.getSelectedItem()+"";
					textFieldNomeFilme.setText(filmeAlugado);
					for(int i = 0; i < nomeFilme.length; i++){
						if(nomeFilme[i] == null)
							break;
						else if(nomeFilme[i].equals(filmeAlugado)){
								textFieldEntrega.setText(dataEntrega[i]);
								break;
						}
					}
					filme = fachada.getInstance().procurarFilme(filmeAlugado);
					textFieldValor.setText("R$"+Double.toString(filme.getValor()));
					textFieldValorTotal.setText("R$"+Double.toString(valorTotal));
				}
				catch(SemAluguelException sae){
					JOptionPane.showMessageDialog(null, sae.getMessage());
				}
				catch(FilmeNaoEncontradoException fnee){
					JOptionPane.showMessageDialog(null, fnee.getMessage());
				}
				catch(ClienteNaoEncontradoException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
		
		JButton btnLocar = new JButton("Locar");
		btnLocar.setForeground(SystemColor.windowBorder);
		btnLocar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnLocar.setBounds(330, 190, 120, 31);
		contentPane.add(btnLocar);
		btnLocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme filme = new Filme();
				Cliente cliente = new Cliente();
				int resposta;
				String nomeFilme, CPF, data;
				try{
					resposta = JOptionPane.showConfirmDialog(null, "Confirmar aluguel?");
					if(resposta == 0){
						nomeFilme = textFieldNomeFilme.getText();
						CPF = textFieldProcurar.getText();
						data = textFieldEntrega.getText();
						
						if(data.equals("")){
							CampoVazioException cve = new CampoVazioException();
							throw cve;
						}
						filme = fachada.getInstance().procurarFilme(nomeFilme);
						cliente = fachada.getInstance().procurarCliente(CPF);
						cliente.alugarFilme(nomeFilme, data);
						fachada.getInstance().atualizarCliente(cliente);
						JOptionPane.showMessageDialog(null, "Aluguel efetuado com sucesso");
						textFieldNomeFilme.setText("");
						textFieldEntrega.setText("");
					}
				}
				catch(ClienteNaoEncontradoException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage());
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
		btnRemover.setBounds(482, 190, 120, 31);
		contentPane.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				int resposta;
				String CPF, filmeAlugado;
				String[] nomeFilme;
				double valorTotal = 0;
				Filme filme = new Filme();
				try{
					CPF = textFieldProcurar.getText();
					filmeAlugado = textFieldNomeFilme.getText();
					if(filmeAlugado.equals("")){
						CampoVazioException cve = new CampoVazioException();
						throw cve;
					}
					cliente = fachada.getInstance().procurarCliente(CPF);
					cliente.removerFilmeAlugado(filmeAlugado);
					resposta = JOptionPane.showConfirmDialog(null,"Confirmar remo��o de " + textFieldNomeFilme.getText());
					if(resposta == 0){
						fachada.getInstance().atualizarCliente(cliente);
						JOptionPane.showMessageDialog(null, "Filme removido com sucesso");
						
						textFieldNomeFilme.setText("");
						textFieldEntrega.setText("");
						textFieldValor.setText("");
						nomeFilme = cliente.getFilmeAlugado();
						comboBox.removeAllItems();
						for(int i = 0; i < nomeFilme.length; i++){
							if(nomeFilme[i] == null)
								break;
							comboBox.addItem(nomeFilme[i]);
							filme = fachada.getInstance().procurarFilme(nomeFilme[i]);
							valorTotal += filme.getValor();
						}
						textFieldValorTotal.setText(Double.toString(valorTotal));
					}
				}
				catch(FilmeNaoEncontradoException fnee){
					JOptionPane.showMessageDialog(null, fnee.getMessage());
				}
				catch(ClienteNaoEncontradoException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
				
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(SystemColor.windowBorder);
		btnSair.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSair.setBounds(482, 232, 120, 31);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldProcurar.setText("");
				textFieldValor.setText("");
				textFieldNomeFilme.setText("");
				textFieldEntrega.setText("");
				textFieldValorTotal.setText("");
				comboBox.removeAllItems();
                telaPrincipal.getInstance().setVisible(true);
                dispose();
			}
		});		
	}
}
