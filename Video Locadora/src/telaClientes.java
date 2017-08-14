import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.*;
import negocio.Cliente;
import negocio.Fachada;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class telaClientes extends JFrame {

	private JPanel contentPane;
	private static JFrame telaClientesInstance;
	private JTextField textFieldProcurar;
	private Fachada fachada;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private JTextField textFieldEndereco;
	private JTextField textFieldTelefone;
	
	public static JFrame getInstance(){
		if(telaClientes.telaClientesInstance == null)
			telaClientes.telaClientesInstance = new telaClientes();
		
		return telaClientes.telaClientesInstance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaClientes frame = new telaClientes();
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
	public telaClientes() {
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("Banco de dados - Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setForeground(SystemColor.desktop);
		textFieldNome.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldNome.setBounds(108, 106, 356, 25);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setText("");
		textFieldCPF.setForeground(Color.BLACK);
		textFieldCPF.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(108, 139, 356, 25);
		contentPane.add(textFieldCPF);
		
		textFieldRG = new JTextField();
		textFieldRG.setText("");
		textFieldRG.setForeground(Color.BLACK);
		textFieldRG.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldRG.setColumns(10);
		textFieldRG.setBounds(108, 172, 356, 25);
		contentPane.add(textFieldRG);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setText("");
		textFieldEndereco.setForeground(Color.BLACK);
		textFieldEndereco.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(108, 203, 356, 25);
		contentPane.add(textFieldEndereco);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setText("");
		textFieldTelefone.setForeground(Color.BLACK);
		textFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(108, 235, 356, 25);
		contentPane.add(textFieldTelefone);
		
		textFieldProcurar = new JTextField();
		textFieldProcurar.setForeground(SystemColor.windowBorder);
		textFieldProcurar.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldProcurar.setBounds(108, 41, 179, 29);
		contentPane.add(textFieldProcurar);
		textFieldProcurar.setText("Insira o CPF");
		textFieldProcurar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 113, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(SystemColor.windowBorder);
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCpf.setBounds(10, 146, 98, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setForeground(SystemColor.windowBorder);
		lblRg.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRg.setBounds(10, 180, 98, 14);
		contentPane.add(lblRg);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(SystemColor.windowBorder);
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEndereo.setBounds(10, 211, 98, 14);
		contentPane.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(SystemColor.windowBorder);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTelefone.setBounds(10, 241, 98, 14);
		contentPane.add(lblTelefone);
		
		JLabel iconeCliente = new JLabel("Icone");
		iconeCliente.setBounds(10, 11, 60, 60);
		contentPane.add(iconeCliente);
		ImageIcon clientes = new ImageIcon(telaPrincipal.class.getResource("/icones/clientes.png"));
		Image imag2 = clientes.getImage().getScaledInstance(iconeCliente.getWidth(), iconeCliente.getHeight(), Image.SCALE_DEFAULT);
		iconeCliente.setIcon(new ImageIcon(imag2));
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setForeground(SystemColor.windowBorder);
		btnProcurar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnProcurar.setBounds(325, 40, 120, 31);
		contentPane.add(btnProcurar);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente achouCliente = new Cliente();
				try{
					achouCliente = fachada.getInstance().procurarCliente(textFieldProcurar.getText());
					textFieldNome.setText(achouCliente.getNome());
					textFieldCPF.setText(achouCliente.getCPF());
					textFieldRG.setText(achouCliente.getRG());
					textFieldEndereco.setText(achouCliente.getEndereco());
					textFieldTelefone.setText(achouCliente.getTelefone());
					textFieldProcurar.setText("Insira o CPF");
				}
				catch(ClienteNaoEncontradoException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage());
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
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				int resposta;
				try{
					resposta = JOptionPane.showConfirmDialog(null, "Confirmar cadastro");
					if(resposta == 0){
						cliente.setNome(textFieldNome.getText());
						cliente.setCPF(textFieldCPF.getText());
						cliente.setRG(textFieldRG.getText());
						cliente.setEndereco(textFieldEndereco.getText());
						cliente.setTelefone(textFieldTelefone.getText());
						fachada.getInstance().cadastrarCliente(cliente);
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
						textFieldNome.setText("");
						textFieldCPF.setText("");
						textFieldRG.setText("");
						textFieldEndereco.setText("");
						textFieldTelefone.setText("");
						textFieldProcurar.setText("Insira o CPF");
					}
				}
				catch(ClienteExistenteException cee){
					JOptionPane.showMessageDialog(null, cee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(SystemColor.windowBorder);
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAtualizar.setBounds(501, 105, 120, 31);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta;
				Cliente cliente = new Cliente();
				try{
					resposta = JOptionPane.showConfirmDialog(null,"Confirmar atualização do cliente?");
					if(resposta == 0){
						cliente.setNome(textFieldNome.getText());
						cliente.setCPF(textFieldCPF.getText());
						cliente.setRG(textFieldRG.getText());
						cliente.setEndereco(textFieldEndereco.getText());
						cliente.setTelefone(textFieldTelefone.getText());
						fachada.getInstance().atualizarCliente(cliente);
						JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
						textFieldNome.setText("");
						textFieldCPF.setText("");
						textFieldRG.setText("");
						textFieldEndereco.setText("");
						textFieldTelefone.setText("");
						textFieldProcurar.setText("Insira o CPF");
					}
				}
				catch(ClienteNaoEncontradoException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage());
				}
				catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(SystemColor.windowBorder);
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRemover.setBounds(501, 147, 120, 31);
		contentPane.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta;
				try{
					resposta = JOptionPane.showConfirmDialog(null,"Confirmar remoção de " + textFieldNome.getText());
					if(resposta == 0){
						fachada.getInstance().removerCliente(textFieldCPF.getText());
						JOptionPane.showMessageDialog(null, "Cliente removido");
						textFieldProcurar.setText("Insira o CPF");
					}
				}
				catch(ClienteNaoEncontradoException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage());
				}
				catch(CPFVazioException cpfve){
					JOptionPane.showMessageDialog(null, cpfve.getMessage());
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
				telaPrincipal.getInstance().setVisible(true);
				dispose();
			}
		});		
	}
}
