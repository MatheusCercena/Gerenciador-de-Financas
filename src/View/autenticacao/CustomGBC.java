package View.autenticacao;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CustomGBC extends GridBagConstraints {
	// private GridBagConstraints gbc = new GridBagConstraints();

	public CustomGBC(int x, int y, int largura) {
		this.insets = new Insets(5, 25, 5, 25);
		this.weightx = 1.0;
		this.weighty = 1.0;
		this.gridx = x;
		this.gridy = y;
		this.gridwidth = largura;
		this.fill = GridBagConstraints.NONE;
		this.anchor = GridBagConstraints.LINE_START;
	}

	public CustomGBC preencherH() {
		this.fill = GridBagConstraints.HORIZONTAL;
		return this;
	}

	public CustomGBC centralizar() {
		this.anchor = GridBagConstraints.CENTER;
		return this;
	}

	public CustomGBC margensV(int cima, int baixo) {
		this.insets = new Insets(cima, 25, baixo, 25);
		return this;
	}

	public CustomGBC alinharTopo() {
		this.anchor = GridBagConstraints.PAGE_START;
		return this;
	}

}
