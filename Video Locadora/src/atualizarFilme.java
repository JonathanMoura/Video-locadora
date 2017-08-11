import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class atualizarFilme extends JFrame {

	private JPanel contentPane;
	private static JFrame atualizarFilmeInstance;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
