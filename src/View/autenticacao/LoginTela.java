package View.autenticacao;

import java.awt.EventQueue;

public class LoginTela {
	private LoginFrame frame = new LoginFrame();
	private LoginPainelSuperior painelSuperior = new LoginPainelSuperior();
	private LoginPainelPrincipal painelPrincipal = new LoginPainelPrincipal();

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTela window = new LoginTela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.
	public LoginTela() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame.add(painelSuperior);
		frame.add(painelPrincipal);
	}
}
