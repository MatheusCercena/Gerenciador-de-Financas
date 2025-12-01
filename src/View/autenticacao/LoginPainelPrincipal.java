package View.autenticacao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.Serial;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import View.estilos.CoresDoProjeto;
import View.estilos.FontesDoProjeto;
import View.estilos.IconesDoProjeto;
import View.utils.CustomGBC;
import View.utils.JPasswordFieldComIcone;
import View.utils.JTextFieldComIcone;

public class LoginPainelPrincipal extends JPanel {
	@Serial
    private static final long serialVersionUID = 1L;
		
	private JLabel titulo;
	private JLabel emailLabel;
	private JTextFieldComIcone emailCaixaTexto;
	private JLabel senhaLabel;
	private JPasswordFieldComIcone senhaCaixaTexto;
	private JButton entrarButton;
	private JLabel cadastrarLabel;

	public LoginPainelPrincipal() {
		this.setLayout(new GridBagLayout());
		this.setBackground(CoresDoProjeto.FUNDO);
		iniciarComponentes();
		construirLayout();
	}

	private void iniciarComponentes() {		
		titulo = new JLabel("Bem Vindo!");
		titulo.setFont(FontesDoProjeto.TITULO);
		titulo.setForeground(CoresDoProjeto.TEXTO);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		emailLabel = new JLabel("Digite seu email: ");
		emailLabel.setFont(FontesDoProjeto.TEXTO);
		emailLabel.setForeground(CoresDoProjeto.TEXTO);

		emailCaixaTexto = new JTextFieldComIcone(IconesDoProjeto.EMAIL);
		emailCaixaTexto.setFont(FontesDoProjeto.CAMPOS);
		emailCaixaTexto.setForeground(CoresDoProjeto.TEXTO);
		emailCaixaTexto.setBorder(BorderFactory.createLineBorder(CoresDoProjeto.TEXTO, 0, true));
		
		senhaLabel = new JLabel("Senha: ");
		senhaLabel.setFont(FontesDoProjeto.TEXTO);
		senhaLabel.setForeground(CoresDoProjeto.TEXTO);
	
		senhaCaixaTexto = new JPasswordFieldComIcone(IconesDoProjeto.CADEADO);
		senhaCaixaTexto.setBorder(BorderFactory.createLineBorder(CoresDoProjeto.TEXTO, 0, true));
		senhaCaixaTexto.setFont(FontesDoProjeto.CAMPOS);
		senhaCaixaTexto.setForeground(CoresDoProjeto.TEXTO);

		entrarButton = new JButton("Entrar");
		entrarButton.setFont(FontesDoProjeto.TEXTO);
		entrarButton.setForeground(Color.WHITE);
		entrarButton.setBackground(CoresDoProjeto.ESCURO);
		entrarButton.setFocusPainted(false);

		cadastrarLabel = new JLabel("Não tem login? Cadastre-se");
		cadastrarLabel.setFont(FontesDoProjeto.AUXILIAR);
		cadastrarLabel.setForeground(Color.BLACK);
		cadastrarLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cadastrarLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Map<TextAttribute, Object> atributos = Map.of(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				cadastrarLabel.setFont(FontesDoProjeto.AUXILIAR.deriveFont(atributos));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cadastrarLabel.setFont(FontesDoProjeto.AUXILIAR);
			}
		});
	}

	private void construirLayout() {
		adicionarComp(titulo, new CustomGBC(0, 0, 0).centralizar());
		adicionarComp(emailLabel, new CustomGBC(0, 1, 0));
		adicionarComp(emailCaixaTexto, new CustomGBC(0, 2, 0).preencherH());
		adicionarComp(senhaLabel, new CustomGBC(0, 3, 0));
		adicionarComp(senhaCaixaTexto, new CustomGBC(0, 4, 0).preencherH());
		adicionarComp(entrarButton, new CustomGBC(0, 5, 0).centralizar());
		adicionarComp(cadastrarLabel, new CustomGBC(0, 6, 0).centralizar());
	}

	private void adicionarComp(Component comp, CustomGBC gbc) {
		this.add(comp, gbc);
	}
}
