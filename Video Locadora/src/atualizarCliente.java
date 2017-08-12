import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Cliente;
import negocio.Fachada;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class atualizarCliente extends JFrame {

	private JPanel contentPane;
	private static JFrame atualizarClienteInstance;
	private JTextField textFieldRG;
	private JTextField textFieldEndereco;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private Fachada fachada;

	public static JFrame getInstance(){
        if(atualizarCliente.atualizarClienteInstance == null)
            atualizarCliente.atualizarClienteInstance = new atualizarCliente();
         
        return atualizarCliente.atualizarClienteInstance;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atualizarCliente frame = new atualizarCliente();
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
	public atualizarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(24, 0, 295, 140);
		contentPane.add(panel);
		
		textFieldRG = new JTextField();
		textFieldRG.setColumns(10);
		textFieldRG.setBounds(88, 60, 99, 20);
		panel.add(textFieldRG);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(88, 85, 194, 20);
		panel.add(textFieldEndereco);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(88, 36, 99, 20);
		panel.add(textFieldCPF);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(88, 14, 194, 20);
		panel.add(textFieldNome);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 14, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("CPF");
		label_1.setBounds(10, 39, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("RG");
		label_2.setBounds(10, 63, 75, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Endereco");
		label_3.setBounds(10, 88, 68, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Telefone");
		label_4.setBounds(10, 112, 68, 14);
		panel.add(label_4);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(88, 109, 99, 20);
		panel.add(textFieldTelefone);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(34, 148, 109, 60);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
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
				telaClientes.getInstance().setVisible(true);
				dispose();
			}
		});
				
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(198, 148, 109, 60);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaClientes.getInstance().setVisible(true);
				dispose();
			}
		});		
	}
}
