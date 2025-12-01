package View.janelaPrincipal;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.Serial;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import View.estilos.CoresDoProjeto;
import View.estilos.FontesDoProjeto;
import View.utils.CustomGBC;
import model.FiltrosPorData;

public class ConteudoCentral extends JPanel {
	@Serial
    private static final long serialVersionUID = 1L;
	
	private JLabel lblBalanco = new JLabel("Transações: ");
	private final JLabel lblComboBox = new JLabel("Selecione a data que deseja filtrar");
	private final JComboBox<FiltrosPorData> comboBox = new JComboBox<FiltrosPorData>();
	private JLabel lblSaldo = new JLabel("Saldo: ");
	private JTable tabelaTransacoes = new TabelaTransacao();
	private JScrollPane scrollTabelaTransacoes;

	public ConteudoCentral() {
		this.setLayout(new GridBagLayout());
		this.setBackground(CoresDoProjeto.FUNDO);
		this.setForeground(CoresDoProjeto.TEXTO);
		this.setBorder(new EmptyBorder(10, 10, 30, 10));

		iniciarComponentes();
		construirLayout();

	}
	
	private void iniciarComponentes() {
		lblBalanco.setFont(FontesDoProjeto.TITULO);

		lblComboBox.setFont(FontesDoProjeto.AUXILIAR);
		lblComboBox.setHorizontalAlignment(JLabel.RIGHT);

		comboBox.setModel(new DefaultComboBoxModel<>(FiltrosPorData.values()));
		comboBox.setMinimumSize(new Dimension(265, 40));
		comboBox.setMaximumSize(new Dimension(265, 40));
		comboBox.setFont(FontesDoProjeto.CAMPOS);

		lblSaldo.setFont(FontesDoProjeto.TEXTO);
		
		scrollTabelaTransacoes = new JScrollPane(tabelaTransacoes);
		scrollTabelaTransacoes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTabelaTransacoes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    }
	
	private void construirLayout() {
		adicionarComp(lblBalanco, new CustomGBC(0, 0, 1).alturaFixa());
		adicionarComp(lblComboBox, new CustomGBC(1, 0, 1).alinharDireita().alturaFixa());

		adicionarComp(lblSaldo, new CustomGBC(0, 1, 1).alturaFixa());
		adicionarComp(comboBox, new CustomGBC(1, 1, 1).alinharDireita().alturaFixa());
		adicionarComp(scrollTabelaTransacoes, new CustomGBC(0, 2, 2).expandir());

    }
	
	private void adicionarComp(Component comp, CustomGBC gbc) {
		this.add(comp, gbc);
	}

}
