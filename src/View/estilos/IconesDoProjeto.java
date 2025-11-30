package View.estilos;

import java.awt.Image;

import javax.swing.ImageIcon;

import View.autenticacao.LoginPainelPrincipal;
import View.autenticacao.LoginPainelSuperior;

public class IconesDoProjeto {

	public static final ImageIcon EMAIL = new ImageIcon(new ImageIcon(LoginPainelPrincipal.class.getResource("/View/resources/email.png")).getImage().getScaledInstance(36, 28, Image.SCALE_SMOOTH));
	public static final ImageIcon CADEADO = new ImageIcon(new ImageIcon(LoginPainelPrincipal.class.getResource("/View/resources/cadeado.png")).getImage().getScaledInstance(30, 28, Image.SCALE_SMOOTH));
	public static final ImageIcon LOGO_CORTADA = new ImageIcon(new ImageIcon(LoginPainelSuperior.class.getResource("/View/resources/logo_cortada.png")).getImage().getScaledInstance(199, 106, Image.SCALE_SMOOTH));
	public static final ImageIcon LOGO = new ImageIcon(LoginPainelSuperior.class.getResource("/View/resources/logo_mmex.png"));

	
	private IconesDoProjeto() {
	}
}
