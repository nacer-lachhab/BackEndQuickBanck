package backEndQuickBank.treadAPI.util;

import org.springframework.stereotype.Component;

@Component
public class TreadUtil {

	public static final String unit = "MAD";
	
	private String date;
	private double value;
	
	public TreadUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TreadUtil(String date) {
		super();
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}
