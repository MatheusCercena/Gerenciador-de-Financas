package View.utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.Serial;

import javax.swing.Icon;
import javax.swing.JTextField;

public class JTextFieldComIcone extends JTextField {
	@Serial
    private static final long serialVersionUID = 1L;
	private final Icon icone;

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
            int padding = 28;
            int deslocamento = icone.getIconWidth() + padding;
			return new Insets(base.top, base.left + deslocamento, base.bottom, base.right);
		}		
		return base;
	}
}
