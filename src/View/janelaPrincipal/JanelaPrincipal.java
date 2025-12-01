package View.janelaPrincipal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.Serial;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import View.estilos.IconesDoProjeto;

public class JanelaPrincipal extends JFrame{
	@Serial
    private static final long serialVersionUID = 1L;
	
	private ToolBar toolbar = new ToolBar();
	private LateralTransacao lateralTransacao = new LateralTransacao();
	private ConteudoCentral conteudoCentral = new ConteudoCentral();
	private JSplitPane splitPaneCentral;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaPrincipal() {
		initialize();
	}

	private void initialize() {
		this.setTitle("Gerenciador de Finanças");
		this.setSize(1980, 1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setMinimumSize(new Dimension(960, 720));
		this.setIconImage(IconesDoProjeto.LOGO.getImage());
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		splitPaneCentral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, conteudoCentral, lateralTransacao);
		splitPaneCentral.setResizeWeight(0.75);
		splitPaneCentral.setBorder(null);
		splitPaneCentral.setDividerSize(8);
		splitPaneCentral.setOneTouchExpandable(true);

		this.getContentPane().add(toolbar, BorderLayout.NORTH);
		this.getContentPane().add(splitPaneCentral, BorderLayout.CENTER);
		
		this.pack();
		int total = splitPaneCentral.getWidth();
		splitPaneCentral.setDividerLocation((int) (total * 0.75));
	}

}
