import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dados.RepositorioClientesArray;
import dados.RepositorioClientesLista;
import negocio.Cliente;
import negocio.Fachada;
import excecoes.*;

public class cadastroClientes extends JFrame {

	private JPanel contentPane;
	private static JFrame cadastroClientesInstance;
	private JTextField textFieldRG;
	private JTextField textFieldEndereco;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private Fachada fachada = new Fachada();
	
	public static JFrame getInstance(){
		if(cadastroClientesInstance == null)
			cadastroClientesInstance = new cadastroClientes();
		
		return cadastroClientesInstance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroClientes frame = new cadastroClientes();
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
	public cadastroClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(118, 57, 99, 20);
		contentPane.add(textFieldRG);
		textFieldRG.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(118, 82, 194, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(118, 33, 99, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(118, 11, 194, 20);
		contentPane.add(textFieldNome);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(118, 106, 99, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(40, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(40, 36, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblRG = new JLabel("RG");
		lblRG.setBounds(40, 60, 75, 14);
		contentPane.add(lblRG);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(40, 85, 68, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(40, 109, 68, 14);
		contentPane.add(lblTelefone);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(40, 145, 109, 60);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				try{
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
					telaClientes.getInstance().setVisible(true);
					dispose();
				}
				catch(NullPointerException npe){
					JOptionPane.showMessageDialog(null, "Preenchar os campos vazios");
				}
				catch(ClienteExistenteException cee){
					JOptionPane.showMessageDialog(null, cee.getMessage());
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(203, 145, 109, 60);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaClientes.getInstance().setVisible(true);
				dispose();
			}
		});
	}
}
