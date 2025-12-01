package View.janelaPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serial;
import java.util.List;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import View.estilos.FontesDoProjeto;
import model.Transacao;

public class TabelaTransacao extends JTable{
	@Serial
    private static final long serialVersionUID = 1L;
	
	public TabelaTransacao() {		
		this.setModel(new DefaultTableModel(
			new Object[][] {
				{0, "Despesa", 01/11/2025, "Alimentação", "Supermercado Alfa", 350.40, "Compra Mensal"},
				{1, "Receita", 05/11/2025, "Salário", "Empresa Fictícia", 4500.00, "Pagamento Ref. a Outubro"},
				{2, "Despesa", 06/11/2025, "Moradia", "Imobiliária NãoReal", 1800.00, "Aluguel"},
				{3, "Despesa", 10/11/2025, "Eletrônicos", "Loja Falsa", 300.00, "Notebook"},
			},
			new String[] {
				"ID", "Tipo", "Data", "Categoria", "Origem", "Valor", "Observações"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		this.getColumnModel().getColumn(0).setPreferredWidth(60);
		this.getColumnModel().getColumn(0).setMinWidth(40);
		
		this.getColumnModel().getColumn(1).setPreferredWidth(120);
		this.getColumnModel().getColumn(1).setMinWidth(80);
		
		this.getColumnModel().getColumn(2).setPreferredWidth(150);
		this.getColumnModel().getColumn(2).setMinWidth(100);	
		
		this.getColumnModel().getColumn(3).setPreferredWidth(225);
		this.getColumnModel().getColumn(3).setMinWidth(150);
		
		this.getColumnModel().getColumn(4).setPreferredWidth(225);
		this.getColumnModel().getColumn(4).setMinWidth(150);
		
		this.getColumnModel().getColumn(5).setPreferredWidth(90);
		this.getColumnModel().getColumn(5).setMinWidth(60);
		
		this.getColumnModel().getColumn(6).setPreferredWidth(450);
		this.getColumnModel().getColumn(6).setMinWidth(300);
		
		this.setFont(FontesDoProjeto.CAMPOS);
		this.setRowHeight(25);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));		
	}

    public void atualizarValores(List<Transacao> listaTransacao){
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        modelo.setRowCount(0);
        for (Transacao transacao : listaTransacao) {
            modelo.addRow(new Object[] {transacao.getId(), transacao.getTipo(), transacao.getCategoria(), transacao.getOrigem(), transacao.getValor(), transacao.getData()});
        }
    }

    private int pegarIdLinha() {
        int linha = this.getSelectedRow();
        if (linha != -1) {
            Object idObj = this.getValueAt(linha, 0);
            int id = (int) idObj;
            return id;
        }
        return linha;
    }


}
