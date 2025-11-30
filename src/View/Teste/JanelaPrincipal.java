package View.Teste;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import View.autenticacao.LoginPainelSuperior;
import View.estilos.CoresDoProjeto;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import model.FiltrosPorData;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class JanelaPrincipal {
	private static final ImageIcon icon = new ImageIcon(LoginPainelSuperior.class.getResource("/View/resources/logo_mmex.png"));
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Gerenciador de Finanças");
		frame.setSize(1980, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(1280, 720));
		frame.setIconImage(icon.getImage());
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel toolbar = new JPanel();
		toolbar.setBackground(CoresDoProjeto.ESCURO);
		FlowLayout flowLayout = (FlowLayout) toolbar.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(toolbar, BorderLayout.NORTH);
		
		JPanel lateralBalanco = new JPanel();
		lateralBalanco.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lateralBalanco.setPreferredSize(new Dimension(350, 0));
		lateralBalanco.setMaximumSize(new Dimension(400, 32767));
		frame.getContentPane().add(lateralBalanco, BorderLayout.WEST);
		lateralBalanco.setLayout(new BoxLayout(lateralBalanco, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Balanço");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lateralBalanco.add(lblNewLabel);
		
		JComboBox<FiltrosPorData> comboBox = new JComboBox<FiltrosPorData>();
		comboBox.setMinimumSize(new Dimension(300, 50));
		comboBox.setMaximumSize(new Dimension(300, 50));
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboBox.setToolTipText("Selecione a data que deseja filtrar");
		comboBox.setPreferredSize(new Dimension(300, 50));
		lateralBalanco.add(comboBox);
		
		Component verticalGlue = Box.createVerticalGlue();
		lateralBalanco.add(verticalGlue);
				
		JPanel lateralTransacao = new JPanel();
		lateralTransacao.setBorder(new MatteBorder(0, 4, 0, 0, (Color) CoresDoProjeto.ESCURO));
		lateralTransacao.setBackground(CoresDoProjeto.FUNDO);
		frame.getContentPane().add(lateralTransacao, BorderLayout.EAST);
		lateralTransacao.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 15));
		
		JPanel tabelaTransacoes = new JPanel();
		tabelaTransacoes.setBorder(new EmptyBorder(10, 15, 0, 15));
		tabelaTransacoes.setBackground(CoresDoProjeto.FUNDO);
		frame.getContentPane().add(tabelaTransacoes, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(2500);
		table.getColumnModel().getColumn(6).setMinWidth(50);
		tabelaTransacoes.setLayout(new BoxLayout(tabelaTransacoes, BoxLayout.Y_AXIS));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));

		JScrollPane scrollPane = new JScrollPane(table);

		tabelaTransacoes.add(scrollPane);

	}

}
