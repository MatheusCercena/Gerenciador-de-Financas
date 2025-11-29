package View.autenticacao;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class LoginFrame extends JFrame {
	private static final ImageIcon icon = new ImageIcon(
			"C:\\Users\\Certheus\\OneDrive\\Documentos\\GitHub\\APS III Fase\\Gerenciador-de-Financas\\src\\View\\resources\\logo_mmex.png");

	LoginFrame() {
		this.setTitle("Gerenciador de Finanças");
		this.setSize(360, 640);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setMaximumSize(new Dimension(480, 720));
		this.setIconImage(icon.getImage());
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setVisible(true);

	}
}
