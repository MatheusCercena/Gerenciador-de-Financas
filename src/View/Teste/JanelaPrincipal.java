package View.Teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import View.autenticacao.LoginPainelSuperior;
import View.estilos.CoresDoProjeto;
import View.estilos.FontesDoProjeto;
import model.FiltrosPorData;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		lateralBalanco.setAlignmentY(Component.TOP_ALIGNMENT);
		lateralBalanco.setAlignmentX(Component.LEFT_ALIGNMENT);
		lateralBalanco.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lateralBalanco.setPreferredSize(new Dimension(350, 0));
		lateralBalanco.setMaximumSize(new Dimension(400, 32767));
		frame.getContentPane().add(lateralBalanco, BorderLayout.WEST);
		lateralBalanco.setLayout(null);

		JComboBox<FiltrosPorData> comboBox = new JComboBox<FiltrosPorData>();
		comboBox.setBounds(28, 86, 300, 50);
		comboBox.setModel(new DefaultComboBoxModel<>(FiltrosPorData.values()));
		comboBox.setAlignmentY(Component.TOP_ALIGNMENT);
		comboBox.setMinimumSize(new Dimension(300, 50));
		comboBox.setMaximumSize(new Dimension(300, 50));
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setToolTipText("Selecione a data que deseja filtrar");
		comboBox.setPreferredSize(new Dimension(300, 50));
		lateralBalanco.add(comboBox);
		
		JLabel lblBalanco = new JLabel("Balanço");
		lblBalanco.setFont(FontesDoProjeto.TITULO);
		lblBalanco.setBounds(28, 30, 175, 45);
		lblBalanco.setPreferredSize(new Dimension(Integer.MAX_VALUE, 14));
		lblBalanco.setMaximumSize(new Dimension(Integer.MAX_VALUE, 14));
		lblBalanco.setHorizontalAlignment(SwingConstants.LEFT);
		lateralBalanco.add(lblBalanco);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 147, 300, 537);
		lateralBalanco.add(panel);
				
		JPanel lateralTransacao = new JPanel();
		lateralTransacao.setAlignmentY(Component.TOP_ALIGNMENT);
		lateralTransacao.setPreferredSize(new Dimension(350, 0));
		lateralTransacao.setAutoscrolls(true);
		lateralTransacao.setAlignmentX(Component.LEFT_ALIGNMENT);
		lateralTransacao.setMinimumSize(new Dimension(400, 0));
		lateralTransacao.setBorder(new MatteBorder(0, 4, 0, 0, (Color) CoresDoProjeto.ESCURO));
		lateralTransacao.setBackground(CoresDoProjeto.FUNDO);
		frame.getContentPane().add(lateralTransacao, BorderLayout.EAST);
		GridBagLayout gbl_lateralTransacao = new GridBagLayout();
		gbl_lateralTransacao.columnWidths = new int[] {173, 173, 0, 1};
		gbl_lateralTransacao.rowHeights = new int[]{1011, 0, 0};
		gbl_lateralTransacao.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_lateralTransacao.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		lateralTransacao.setLayout(gbl_lateralTransacao);
		
		// criar grid bag layout manualmente e aplicar ao painel
		// separar janela principal em arquivos menores
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 1;
		lateralTransacao.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setAlignmentY(Component.TOP_ALIGNMENT);
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.anchor = GridBagConstraints.NORTH;
		gbc_lblTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTipo.gridx = 0;
		gbc_lblTipo.gridy = 0;
		lateralTransacao.add(lblTipo, gbc_lblTipo);
		
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
