package View.janelaPrincipal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import View.estilos.CoresDoProjeto;
import View.estilos.FontesDoProjeto;
import View.utils.CampoDataSpinner;
import View.utils.CampoValor;
import View.utils.CustomGBC;
import model.Tipo;

public class LateralTransacao extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel titulo;
	private JLabel lblTipo;
	private JComboBox<Tipo> campoTipo;
	private JLabel lblData;
	private CampoDataSpinner campoData;
	private JLabel lblCategoria;
	private JComboBox<String> campoCategoria;
	private JLabel lblOrigem;
	private JComboBox<String> campoOrigem;
	private JLabel lblValor;
	private CampoValor campoValor;
	private JLabel lblObservacoes;
	private JTextArea campoObservacoes;
	private JScrollPane scrollCampoObservacoes;

	public LateralTransacao() {
		this.setAlignmentY(Component.TOP_ALIGNMENT);
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setBorder(new MatteBorder(0, 4, 0, 0, (Color) CoresDoProjeto.ESCURO));
		this.setBackground(CoresDoProjeto.FUNDO);
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(10, 10, 30, 10));

		iniciarComponentes();
		construirLayout();
	}
	
	private void iniciarComponentes() {
		titulo = new JLabel("Dados da transação");
		titulo.setFont(FontesDoProjeto.TITULO);
		titulo.setForeground(CoresDoProjeto.TEXTO);
		titulo.setHorizontalAlignment(SwingConstants.LEFT);

		lblTipo = new JLabel("Tipo da Transação: ");
		lblTipo.setFont(FontesDoProjeto.TEXTO);
		lblTipo.setForeground(CoresDoProjeto.TEXTO);

		campoTipo = new JComboBox<Tipo>();
		campoTipo.setFont(FontesDoProjeto.TEXTO);
		campoTipo.setForeground(CoresDoProjeto.TEXTO);
		
		lblData = new JLabel("Data: ");
		lblData.setFont(FontesDoProjeto.TEXTO);
		lblData.setForeground(CoresDoProjeto.TEXTO);
	
		campoData = new CampoDataSpinner();
		campoData.setFont(FontesDoProjeto.TEXTO);
		campoData.setForeground(CoresDoProjeto.TEXTO);

		lblCategoria = new JLabel("Categoria: ");
		lblCategoria.setFont(FontesDoProjeto.TEXTO);
		lblCategoria.setForeground(CoresDoProjeto.TEXTO);
		
		campoCategoria = new JComboBox<String>();
		campoCategoria.setFont(FontesDoProjeto.TEXTO);
		campoCategoria.setForeground(CoresDoProjeto.TEXTO);

		lblOrigem = new JLabel("Origem: ");
		lblOrigem.setFont(FontesDoProjeto.TEXTO);
		lblOrigem.setForeground(CoresDoProjeto.TEXTO);
		
		campoOrigem = new JComboBox<String>();
		campoOrigem.setFont(FontesDoProjeto.TEXTO);
		campoOrigem.setForeground(CoresDoProjeto.TEXTO);

		lblValor = new JLabel("Valor: ");
		lblValor.setFont(FontesDoProjeto.TEXTO);
		lblValor.setForeground(CoresDoProjeto.TEXTO);
		
		campoValor = new CampoValor();
		campoValor.setFont(FontesDoProjeto.TEXTO);
		campoValor.setForeground(CoresDoProjeto.TEXTO);
		
		lblObservacoes = new JLabel("Observações: ");
		lblObservacoes.setFont(FontesDoProjeto.TEXTO);
		lblObservacoes.setForeground(CoresDoProjeto.TEXTO);
		
		campoObservacoes = new JTextArea();
		campoObservacoes.setFont(FontesDoProjeto.TEXTO);
		campoObservacoes.setForeground(CoresDoProjeto.TEXTO);
		campoObservacoes.setLineWrap(true);
		campoObservacoes.setBorder(UIManager.getBorder("TextField.border"));
		campoObservacoes.setWrapStyleWord(true);
		
		scrollCampoObservacoes = new JScrollPane(campoObservacoes);
		scrollCampoObservacoes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}

	private void construirLayout() {
		adicionarComp(titulo, new CustomGBC(0, 0, 1).alturaFixa());
		adicionarComp(lblTipo, new CustomGBC(0, 1, 1).alturaFixa());
		adicionarComp(campoTipo, new CustomGBC(0, 2, 1).preencherH().alturaFixa());
		adicionarComp(lblData, new CustomGBC(0, 3, 1).alturaFixa());
		adicionarComp(campoData, new CustomGBC(0, 4, 1).preencherH().alturaFixa());
		adicionarComp(lblCategoria, new CustomGBC(0, 5, 1).alturaFixa());
		adicionarComp(campoCategoria, new CustomGBC(0, 6, 1).preencherH().alturaFixa());
		adicionarComp(lblOrigem, new CustomGBC(0, 7, 1).alturaFixa());
		adicionarComp(campoOrigem, new CustomGBC(0, 8, 1).preencherH().alturaFixa());
		adicionarComp(lblValor, new CustomGBC(0, 9, 1).alturaFixa());
		adicionarComp(campoValor, new CustomGBC(0, 10, 1).preencherH().alturaFixa());
		adicionarComp(lblObservacoes, new CustomGBC(0, 11, 1).alturaFixa());
		adicionarComp(scrollCampoObservacoes, new CustomGBC(0, 12, 1).expandir());
	}

	private void adicionarComp(Component comp, CustomGBC gbc) {
		this.add(comp, gbc);
	}	

}
