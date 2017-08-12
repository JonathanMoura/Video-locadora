import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Fachada;
import negocio.Filme;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class atualizarFilme extends JFrame {

	private JPanel contentPane;
	private static JFrame atualizarFilmeInstance;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;
	private JTextField textFieldGenero;
	private JTextField textFieldNome;
	private Fachada fachada;

	public static JFrame getInstance(){
        if(atualizarFilme.atualizarFilmeInstance == null)
            atualizarFilme.atualizarFilmeInstance = new atualizarFilme();
         
        return atualizarFilme.atualizarFilmeInstance;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atualizarFilme frame = new atualizarFilme();
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
	public atualizarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(27, 0, 312, 118);
		contentPane.add(panel);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(88, 60, 56, 20);
		panel.add(textFieldQuantidade);
		
		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(88, 85, 56, 20);
		panel.add(textFieldValor);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setColumns(10);
		textFieldGenero.setBounds(88, 36, 118, 20);
		panel.add(textFieldGenero);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(88, 14, 200, 20);
		panel.add(textFieldNome);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 14, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Genero:");
		label_1.setBounds(10, 39, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Quantidade:");
		label_2.setBounds(10, 63, 75, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Valor (R$):");
		label_3.setBounds(10, 88, 68, 14);
		panel.add(label_3);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(38, 148, 109, 60);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme filme = new Filme();
				filme.setNome(textFieldNome.getText());
				filme.setGenero(textFieldGenero.getText());
				filme.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
				filme.setValor(Double.parseDouble(textFieldValor.getText()));
				fachada.getInstance().atualizarFilme(filme);
				JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso");
				textFieldNome.setText("");
				textFieldGenero.setText("");
				textFieldQuantidade.setText("");
				textFieldValor.setText("");
				telaFilmes.getInstance().setVisible(true);
				dispose();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(204, 148, 109, 60);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaFilmes.getInstance().setVisible(true);
				dispose();
			}
		});		
	}
}
