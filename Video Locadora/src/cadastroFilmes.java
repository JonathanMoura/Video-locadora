import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastroFilmes extends JFrame {

	private JPanel contentPane;
	private static JFrame cadastroFilmesInstance;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
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
		setBounds(100, 100, 353, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(88, 60, 56, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 85, 56, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 36, 118, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(88, 14, 118, 20);
		contentPane.add(textField_3);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(10, 39, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 63, 75, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblValor = new JLabel("Valor (R$):");
		lblValor.setBounds(10, 88, 68, 14);
		contentPane.add(lblValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadastroFilmes.this.setVisible(false);
				telaFilmes.getInstance().setVisible(true);
			}
		});

		btnCadastrar.setBounds(215, 13, 109, 92);
		contentPane.add(btnCadastrar);
	}

}
