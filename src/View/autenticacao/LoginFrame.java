package View.autenticacao;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import View.estilos.IconesDoProjeto;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	LoginFrame() {
		this.setTitle("Gerenciador de Finanças");
		this.setSize(360, 640);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setMaximumSize(new Dimension(360, 640));
		this.setIconImage(IconesDoProjeto.LOGO.getImage());
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setLocationRelativeTo(null);
	}
}
