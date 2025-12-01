package View.autenticacao;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serial;

import javax.swing.JLabel;
import javax.swing.JPanel;

import View.estilos.IconesDoProjeto;

public class LoginPainelSuperior extends JPanel {
	@Serial
    private static final long serialVersionUID = 1L;

	LoginPainelSuperior() {
		this.setBackground(new Color(0x7C8C64));
		this.setLayout(null);
		JLabel logoLabel = new JLabel(IconesDoProjeto.LOGO_CORTADA);
		logoLabel.setBounds(0, 6, 199, 106);
		this.add(logoLabel);
		this.setMaximumSize(new Dimension(360, 112));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(360, 112);
	}

	@Override
	public Dimension getMaximumSize() {
		return new Dimension(Integer.MAX_VALUE, 112);
	}

}
