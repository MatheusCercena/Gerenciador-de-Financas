package View.autenticacao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPainelPrincipal extends JPanel {
	private final Color COR_FUNDO = new Color(0xDCE5DE);
	private final Color COR_TEXTO = new Color(0x4C593F);
	private final Color COR_BOTAO = new Color(0x7C8C64);

	private final Font fonteTitulo = new Font("Segoe UI", Font.BOLD, 26);
	private final Font fonteTexto = new Font("Segoe UI", Font.PLAIN, 20);
	private final Font fonteAuxiliar = new Font("Segoe UI", Font.PLAIN, 14);

	private JLabel titulo;
	private JLabel emailLabel;
	private JTextField emailCaixaTexto;
	private JLabel senhaLabel;
	private JPasswordField senhaCaixaTexto;
	private JButton entrarButton;
	private JLabel cadastrarLabel;

	public LoginPainelPrincipal() {
		this.setLayout(new GridBagLayout());
		this.setBackground(COR_FUNDO);
		iniciarComponentes();
		construirLayout();

	}

	private void iniciarComponentes() {

		titulo = new JLabel("Bem Vindo!");
		titulo.setFont(fonteTitulo);
		titulo.setForeground(COR_TEXTO);

		emailLabel = new JLabel("Digite seu email: ");
		emailLabel.setFont(fonteTexto);
		emailLabel.setForeground(COR_TEXTO);

		emailCaixaTexto = new JTextField(50);
		emailCaixaTexto.setFont(fonteTexto);
		emailCaixaTexto.setForeground(COR_TEXTO);
		emailCaixaTexto.setBorder(BorderFactory.createLineBorder(COR_TEXTO, 0, true));

		senhaLabel = new JLabel("Senha: ");
		senhaLabel.setFont(fonteTexto);
		senhaLabel.setForeground(COR_TEXTO);

		senhaCaixaTexto = new JPasswordField(8);
		senhaCaixaTexto.setFont(fonteTexto);
		senhaCaixaTexto.setForeground(COR_TEXTO);
		senhaCaixaTexto.setBorder(BorderFactory.createLineBorder(COR_TEXTO, 0, true));

		entrarButton = new JButton("Entrar");
		entrarButton.setFont(fonteTexto);
		entrarButton.setForeground(Color.WHITE);
		entrarButton.setBackground(COR_BOTAO);
		entrarButton.setFocusPainted(false);

		cadastrarLabel = new JLabel("Não tem login? Cadastre-se");
		cadastrarLabel.setFont(fonteAuxiliar);
		cadastrarLabel.setForeground(Color.BLACK);
		cadastrarLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cadastrarLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Map<TextAttribute, Object> atributos = Map.of(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				cadastrarLabel.setFont(fonteAuxiliar.deriveFont(atributos));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cadastrarLabel.setFont(fonteAuxiliar);
			}
		});
	}

	private void construirLayout() {
		adicionarComp(titulo, new CustomGBC(0, 0, 0));
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
