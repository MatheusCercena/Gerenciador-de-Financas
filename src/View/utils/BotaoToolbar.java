package View.utils;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.estilos.FontesDoProjeto;

public class BotaoToolbar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel iconeLabel;
    private JLabel textoLabel;
    
    public BotaoToolbar(ImageIcon icone, String texto) {
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);

        iconeLabel = new JLabel(icone);
        iconeLabel.setAlignmentX(CENTER_ALIGNMENT);
        iconeLabel.setFont(FontesDoProjeto.AUXILIAR);

        textoLabel = new JLabel(texto);
        textoLabel.setAlignmentX(CENTER_ALIGNMENT);
        textoLabel.setFont(FontesDoProjeto.AUXILIAR);

        this.add(iconeLabel);
        this.add(Box.createVerticalStrut(4));
        this.add(textoLabel);
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    }
    
}
