package View.estilos;

import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

import View.autenticacao.LoginPainelPrincipal;
import View.autenticacao.LoginPainelSuperior;

public class IconesDoProjeto {
	public static final ImageIcon EMAIL = carregarIcone("/View/resources/email.png", 36, 28);
	public static final ImageIcon CADEADO = carregarIcone("/View/resources/cadeado.png", 30, 28);
	public static final ImageIcon LOGO_CORTADA = carregarIcone("/View/resources/logo_cortada.png", 199, 106);
	public static final ImageIcon LOGO = new ImageIcon(Objects.requireNonNull(IconesDoProjeto.class.getResource("/View/resources/logo_mmex.png")));

	public static final ImageIcon IMPORTAR = carregarIcone("/View/resources/importar.png", 38, 38);
	public static final ImageIcon EXPORTAR = carregarIcone("/View/resources/exportar.png", 38, 38);
	public static final ImageIcon CADASTRAR = carregarIcone("/View/resources/cadastrar.png", 38, 38);
	public static final ImageIcon CATEGORIA = carregarIcone("/View/resources/categoria.png", 38, 38);
	public static final ImageIcon ORIGEM = carregarIcone("/View/resources/origem.png", 38, 38);
	public static final ImageIcon CONTA = carregarIcone("/View/resources/conta.png", 38, 38);
	public static final ImageIcon SAIR = carregarIcone("/View/resources/sair.png", 38, 38);

	private IconesDoProjeto() {
	}

    private static ImageIcon carregarIcone(String path, int w, int h) {
        var url = Objects.requireNonNull(
                IconesDoProjeto.class.getResource(path),
                "Recurso não encontrado: " + path
        );

        Image img = new ImageIcon(url).getImage()
                .getScaledInstance(w, h, Image.SCALE_SMOOTH);

        return new ImageIcon(img);
    }
}
