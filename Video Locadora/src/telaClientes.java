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

import negocio.Cliente;
import negocio.Fachada;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

public class telaClientes extends JFrame {

	private JPanel contentPane;
	private static JFrame telaClientesInstance;
	private JTextField textFieldCPF;
	private Fachada fachada;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel icone = new JLabel("Icone");
		icone.setBounds(245, 11, 76, 48);
		contentPane.add(icone);
		ImageIcon clientes = new ImageIcon(telaClientes.class.getResource("/icones/clientes.png"));
		Image imag = clientes.getImage().getScaledInstance(icone.getWidth(), icone.getHeight(), Image.SCALE_DEFAULT);
		icone.setIcon(new ImageIcon(imag));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 348, 214);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(10, 61, 215, 153);
		panel.add(panel_1);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setText("Insira o CPF do cliente");
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(10, 11, 196, 20);
		panel_1.add(textFieldCPF);
				
		JLabel lblTelaClientes = new JLabel("Clientes");
		lblTelaClientes.setForeground(SystemColor.windowBorder);
		lblTelaClientes.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelaClientes.setBounds(86, 11, 65, 14);
		panel.add(lblTelaClientes);
		
		JTextArea textDadosCliente = new JTextArea();
		textDadosCliente.setBounds(10, 42, 196, 100);
		panel_1.add(textDadosCliente);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(229, 143, 104, 23);
		panel.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fachada.getInstance().removerCliente(textFieldCPF.getText());
				int resposta = JOptionPane.showConfirmDialog(null,"Confirmar remoção do cliente?");
				if(resposta == 0)	
					JOptionPane.showMessageDialog(null, "Cliente removido");
			}
		});
				
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(229, 71, 104, 23);
		panel.add(btnProcurar);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente achouCliente = new Cliente();
				achouCliente = fachada.getInstance().procurarCliente(textFieldCPF.getText());
				
				textDadosCliente.append(achouCliente.toString());
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(229, 109, 104, 23);
		panel.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaClientes.this.setVisible(false);
				atualizarCliente.getInstance().setVisible(true);
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(229, 180, 104, 23);
		panel.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				telaPrincipal.getInstance().setVisible(true);
				dispose();
			}
		});		
				
		JButton btnCadastrar = new JButton("Cadastrar novo cliente");
		btnCadastrar.setBounds(22, 36, 194, 23);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaClientes.this.setVisible(false);
				cadastroClientes.getInstance().setVisible(true);
			}
		});
	}
}
