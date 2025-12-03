package View.utils;

import java.io.Serial;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class CampoValor extends JFormattedTextField{
	@Serial
    private static final long serialVersionUID = 1L;

    public CampoValor() {
		super();
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);

        NumberFormatter formatter = new NumberFormatter(nf);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0.0);
        formatter.setOverwriteMode(false);

        this.setFormatterFactory(new DefaultFormatterFactory(formatter));
        this.setValue(0.00);
	}
	
    public double getValor() {
    	Number value = (Number) getValue();
        return value.doubleValue();
    }
	
}
