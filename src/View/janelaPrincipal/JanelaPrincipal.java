package View.janelaPrincipal;

import java.awt.EventQueue;

public class JanelaPrincipal {
	private janelaPrincipalFrame frame = new janelaPrincipalFrame();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janelaPrincipalFrame window = new janelaPrincipalFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaPrincipal() {
		initialize();
	}

	private void initialize() {
	}

}
