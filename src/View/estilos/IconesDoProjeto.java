package View.estilos;

import java.awt.Image;

import javax.swing.ImageIcon;

import View.autenticacao.LoginPainelPrincipal;
import View.autenticacao.LoginPainelSuperior;

public class IconesDoProjeto {

	public static final ImageIcon EMAIL = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/email.png")).getImage().getScaledInstance(36, 28, Image.SCALE_SMOOTH));
	public static final ImageIcon CADEADO = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/cadeado.png")).getImage().getScaledInstance(30, 28, Image.SCALE_SMOOTH));
	public static final ImageIcon LOGO_CORTADA = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/logo_cortada.png")).getImage().getScaledInstance(199, 106, Image.SCALE_SMOOTH));
	public static final ImageIcon LOGO = new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/logo_mmex.png"));

	public static final ImageIcon IMPORTAR = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/importar.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
	public static final ImageIcon EXPORTAR = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/exportar.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
	public static final ImageIcon CADASTRAR = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/cadastrar.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
	public static final ImageIcon CATEGORIA = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/cadastrar.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
	public static final ImageIcon ORIGEM = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/origem.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
	public static final ImageIcon CONTA = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/conta.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
	public static final ImageIcon SAIR = new ImageIcon(new ImageIcon(IconesDoProjeto.class.getResource("/View/resources/sair.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));

	private IconesDoProjeto() {
	}
}
