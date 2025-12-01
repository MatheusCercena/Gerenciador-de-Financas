package View.janelaPrincipal;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import View.estilos.FontesDoProjeto;

public class TabelaTransacao extends JTable{
	private static final long serialVersionUID = 1L;
	
	public TabelaTransacao() {		
		this.setModel(new DefaultTableModel(
			new Object[][] {
				{0, "Despesa", 01/11/2025, "Alimentação", "Supermercado Alfa", 350.40, "Compra Mensal"},
				{1, "Receita", 05/11/2025, "Salário", "Empresa Ficticia", 4500.00, "Pagamento Ref. a Outubro"},
				{2, "Despesa", 06/11/2025, "Moradia", "Imobiliaria NãoReal", 1800.00, "Aluguel"},
				{3, "Despesa", 10/11/2025, "Eletrônicos", "Loja Falsa", 300.00, "Notebook"},
			},
			new String[] {
				"ID", "Tipo", "Data", "Categoria", "Origem", "Valor", "Observa\u00E7\u00F5es"
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
}
