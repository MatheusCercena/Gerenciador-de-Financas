package View.janelaPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import View.estilos.CoresDoProjeto;
import View.estilos.IconesDoProjeto;
import View.utils.BotaoToolbar;

public class ToolBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel esquerda;
	private JPanel direita;
	
	
	private BotaoToolbar importar;
	private BotaoToolbar exportar;
	private BotaoToolbar cadastrar;
	private BotaoToolbar categoria;
	private BotaoToolbar origem;
	private BotaoToolbar conta;
	private BotaoToolbar sair;
	
	
	public ToolBar() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, 75));
		this.setBackground(CoresDoProjeto.ESCURO);
		
		
		inicializarComponentes();
		contruirLayout();
		

	}


	private ToolBar inicializarComponentes() {
		
		esquerda = new JPanel();
		esquerda.setOpaque(false);
		esquerda.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

		direita = new JPanel();
		direita.setOpaque(false);
		direita.setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 5));

		importar = new BotaoToolbar(IconesDoProjeto.IMPORTAR, "Importar");
		exportar = new BotaoToolbar(IconesDoProjeto.EXPORTAR, "Exportar");
		cadastrar = new BotaoToolbar(IconesDoProjeto.CADASTRAR, "Cadastrar");
		categoria = new BotaoToolbar(IconesDoProjeto.CATEGORIA, "Categoria");
		origem = new BotaoToolbar(IconesDoProjeto.ORIGEM, "Origem");
		conta = new BotaoToolbar(IconesDoProjeto.CONTA, "Conta");
		sair = new BotaoToolbar(IconesDoProjeto.SAIR, "Sair");
		

		return this;
	}
	
	private ToolBar contruirLayout() {
		
		esquerda.add(importar);
		esquerda.add(exportar);
		esquerda.add(cadastrar);
		esquerda.add(categoria);
		esquerda.add(origem);
		direita.add(conta);
		direita.add(sair);

		this.add(esquerda, BorderLayout.WEST);
		this.add(direita, BorderLayout.EAST);
			

		return this;
	}

}


