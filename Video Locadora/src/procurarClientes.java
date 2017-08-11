import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dados.RepositorioClientesLista;
import negocio.Cliente;

public class procurarClientes extends JFrame {

	private JPanel contentPane;
	private static procurarClientes procurarClientesInstance = new procurarClientes();
	private JTextField textFieldCliente;
	
	public static JFrame getInstance(){
		if(procurarClientesInstance == null)
			procurarClientesInstance = new procurarClientes();
		
		return procurarClientesInstance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					procurarClientes frame = new procurarClientes();
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
	public procurarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 239, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setBounds(10, 11, 196, 20);
		contentPane.add(textFieldCliente);
		textFieldCliente.setColumns(10);
		
		JTextArea textAreaDados = new JTextArea();
		textAreaDados.setBounds(10, 81, 196, 100);
		contentPane.add(textAreaDados);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldCliente.equals(""))
					JOptionPane.showMessageDialog(null, "Insira o CPF do cliente");
				else{
					Cliente achouCliente = RepositorioClientesLista.getInstance().procurar(textFieldCliente.getText()); 
					if(achouCliente == null)
						JOptionPane.showMessageDialog(null, "Cliente não encontrado");
					else
						textAreaDados.append(achouCliente.toString());
				}					
			}
		});
		btnProcurar.setBounds(10, 42, 97, 23);
		contentPane.add(btnProcurar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				procurarClientes.this.setVisible(false);
				telaClientes.getInstance().setVisible(true);
			}
		});
		btnCancelar.setBounds(117, 42, 89, 23);
		contentPane.add(btnCancelar);
	}

}
