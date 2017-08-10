import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class telaFilmes extends JFrame {

	private JPanel contentPane;
	private static JFrame telaFilmesInstance;

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
		setBounds(100, 100, 199, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroFilmes.getInstance().setVisible(true);
				telaFilmes.this.setVisible(false);
			}
		});
		btnCadastrar.setBounds(37, 42, 104, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(37, 76, 104, 23);
		contentPane.add(btnProcurar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(37, 110, 104, 23);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(37, 144, 104, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(37, 179, 104, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaFilmes.this.setVisible(false);
			}
		});
		contentPane.add(btnSair);
		
		JLabel lblTelaFilmes = new JLabel("Filmes");
		lblTelaFilmes.setBounds(77, 11, 46, 14);
		contentPane.add(lblTelaFilmes);
	}

}
