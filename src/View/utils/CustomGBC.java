package View.utils;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.Serial;

/*
 * Cria um GridBagConstraints com altura e largura das colunas expandíveis, sem preenchimento padrao e com ancoragem padrão no lado esquerdo. Usar os métodos para alterar as propriedades que não se encaixem no padrão.
 * */
public class CustomGBC extends GridBagConstraints {
	@Serial
    private static final long serialVersionUID = 1L;

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
	
	public CustomGBC larguraFixa() {
		this.weightx = 0.0;
		return this;
	}

	public CustomGBC larguraVariavel() {
		this.weightx = 1.0;
		return this;
	}

	public CustomGBC alturaFixa() {
		this.weighty = 0.0;
		return this;
	}
	
	public CustomGBC alturaVariavel() {
		this.weighty = 1.0;
		return this;
	}


	public CustomGBC preencherH() {
		this.fill = GridBagConstraints.HORIZONTAL;
		return this;
	}
	
	public CustomGBC preencherV() {
		this.fill = GridBagConstraints.VERTICAL;
		return this;
	}


	public CustomGBC centralizar() {
		this.anchor = GridBagConstraints.CENTER;
		return this;
	}

	public CustomGBC alinharTopo() {
		this.anchor = GridBagConstraints.PAGE_START;
		return this;
	}

	public CustomGBC alinharBase() {
		this.anchor = GridBagConstraints.PAGE_END;
		return this;
	}

	
	public CustomGBC alinharDireita() {
		this.anchor = GridBagConstraints.NORTHEAST;
		return this;
	}

	
	public CustomGBC expandir() {
		this.fill = GridBagConstraints.BOTH;
		return this;
	}

	

}
