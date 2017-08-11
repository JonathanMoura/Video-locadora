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

public class cadastroClientes extends JFrame {

	private JPanel contentPane;
	private static JFrame cadastroClientesInstance;
	private JTextField textFieldRG;
	private JTextField textFieldEndereco;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private RepositorioClientesLista repositorio = new RepositorioClientesLista();
	
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
		setBounds(100, 100, 455, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(88, 60, 99, 20);
		contentPane.add(textFieldRG);
		textFieldRG.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(88, 85, 194, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(88, 36, 99, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(88, 14, 194, 20);
		contentPane.add(textFieldNome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(10, 39, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblRG = new JLabel("RG");
		lblRG.setBounds(10, 63, 75, 14);
		contentPane.add(lblRG);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(10, 88, 68, 14);
		contentPane.add(lblEndereco);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(textFieldNome.getText());
				cliente.setCPF(textFieldCPF.getText());
				cliente.setRG(textFieldRG.getText());
				cliente.setEndereco(textFieldEndereco.getText());
				cliente.setTelefone(textFieldTelefone.getText());
				repositorio.inserir(cliente);
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
				textFieldNome.setText("");
				textFieldCPF.setText("");
				textFieldRG.setText("");
				textFieldEndereco.setText("");
				textFieldTelefone.setText("");
				cadastroClientes.this.setVisible(false);
				telaClientes.getInstance().setVisible(true);
			}
		});

		btnCadastrar.setBounds(307, 13, 109, 79);
		contentPane.add(btnCadastrar);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 112, 46, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(88, 109, 99, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroClientes.this.setVisible(false);
				telaClientes.getInstance().setVisible(true);
			}
		});
		btnCancelar.setBounds(307, 108, 109, 23);
		contentPane.add(btnCancelar);
	}
}
