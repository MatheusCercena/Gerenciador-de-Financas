package View.autenticacao;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginPainelSuperior extends JPanel {
	private static final ImageIcon logo = new ImageIcon(
			"C:\\Users\\Certheus\\OneDrive\\Documentos\\GitHub\\APS III Fase\\Gerenciador-de-Financas\\src\\View\\resources\\logo_cortada.png");

	LoginPainelSuperior() {
		this.setBackground(new Color(0x7C8C64));
		this.setLayout(null);
		JLabel logoLabel = new JLabel(logo);
		logoLabel.setBounds(0, 7, 240, 128);
		this.add(logoLabel);
		this.setMaximumSize(new Dimension(480, 135));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(480, 135);
	}

	@Override
	public Dimension getMaximumSize() {
		return new Dimension(Integer.MAX_VALUE, 135);
	}

}
