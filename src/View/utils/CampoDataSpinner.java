package View.utils;

import java.awt.Dimension;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;


public class CampoDataSpinner extends JSpinner {
	private static final long serialVersionUID = 1L;
	private SpinnerDateModel model;
	
	public CampoDataSpinner() {
		this.model = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
		
		this.setModel(model);
        this.setEditor(new DateEditor(this, "dd/MM/yyyy"));        
    }
    
    public LocalDate getLocalDate() {
        Date valor = (Date) this.getValue();
        return valor.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setLocalDate(LocalDate data) {
        Date d = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.setValue(d);
    }
    
}
