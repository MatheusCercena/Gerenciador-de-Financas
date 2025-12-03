package View.janelaPrincipal;

import java.awt.Color;
import java.io.Serial;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowSorter.SortKey;

import View.estilos.FontesDoProjeto;
import controller.TransacaoDao;
import model.Transacao;

public class TabelaTransacao extends JTable{
	@Serial
    private static final long serialVersionUID = 1L;
    private TableRowSorter<TableModel> sorter;

	public TabelaTransacao() {
		this.setModel(new DefaultTableModel(
			new Object[][] {},
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

        sorter = new TableRowSorter<>(this.getModel());
        this.setRowSorter(sorter);
        sorter.setSortsOnUpdates(true);
        List<SortKey> sortKeys = new ArrayList<>();

        RowSorter.SortKey sortKey = new RowSorter.SortKey(0, SortOrder.DESCENDING);

        sortKeys.add(sortKey);
        sorter.setSortKeys(sortKeys);
        sorter.sort();

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

        TransacaoDao transacao = new TransacaoDao();

        this.atualizarValores(transacao.listar());
	}



    public void atualizarValores(List<Transacao> listaTransacao){
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        modelo.setRowCount(0);
        for (Transacao transacao : listaTransacao) {
            String tipoCapitalizado =  transacao.getTipo().toString().toLowerCase();
            DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR"));

            modelo.addRow(new Object[] {transacao.getId(),
                    tipoCapitalizado.substring(0, 1).toUpperCase() + tipoCapitalizado.substring(1),
                    formatoData.format(transacao.getData()),
                    transacao.getCategoria().getNome(),
                    transacao.getOrigem().getNome(),
                    transacao.getValor(),
                    transacao.getObservacoes()});//DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR"))
        }
    }

    public int pegarIdLinha() {
        int linha = this.getSelectedRow();
        if (linha != -1) {
            Object idObj = this.getValueAt(linha, 0);
            int id = (int) idObj;
            return id;
        }
        return linha;
    }



}
