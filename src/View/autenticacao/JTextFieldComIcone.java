package View.autenticacao;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JTextField;

public class JTextFieldComIcone extends JTextField {
	private static final long serialVersionUID = 1L;
	private final Icon icone;
    private final int padding = 25;
    
	public JTextFieldComIcone(Icon icone) {
		this.icone = icone;
		this.setPreferredSize(new Dimension(0, 55));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (icone != null) {
			int y = (getHeight() - icone.getIconHeight()) /2;
			icone.paintIcon(this, g, y, y);
		}
	}

	@Override
	public Insets getInsets() {
		Insets base = super.getInsets();
		
		if (icone != null) {
			int deslocamento = icone.getIconWidth() + padding;
			return new Insets(base.top, base.left + deslocamento, base.bottom, base.right);
		}		
		return base;
	}
}
