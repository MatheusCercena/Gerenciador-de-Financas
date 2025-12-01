package View.utils;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class CampoValor extends JFormattedTextField{
	private static final long serialVersionUID = 1L;
	private NumberFormat nf;
	private NumberFormatter formatter;
	
	public CampoValor() {
		super();
		nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
        
		formatter = new NumberFormatter(nf);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0.0);
        formatter.setOverwriteMode(false);

        this.setFormatterFactory(new DefaultFormatterFactory(formatter));
        this.setValue(0.00);
	}
	
    public double getDouble() {
    	Number value = (Number) getValue();
        return value.doubleValue();
    }
	
}
