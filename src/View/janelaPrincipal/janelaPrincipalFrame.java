package View.janelaPrincipal;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import View.autenticacao.LoginPainelSuperior;

public class janelaPrincipalFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final ImageIcon icon = new ImageIcon(LoginPainelSuperior.class.getResource("/View/resources/logo_mmex.png"));

	public janelaPrincipalFrame() {
		this.setTitle("Gerenciador de Finanças");
		this.setSize(1980, 1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setMinimumSize(new Dimension(1280, 720));
		this.setIconImage(icon.getImage());
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
