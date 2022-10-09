package backEndQuickBank.treadAPI.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import backEndQuickBank.treadAPI.util.TreadUtil;



@Service
public class TreadHistoriqueValues {
	
	private List<TreadUtil> treadValues = new ArrayList<>();

	public List<TreadUtil> getTreadValues() {
		return treadValues;
	}

	public void setTreadValues(List<TreadUtil> treadValues) {
		this.treadValues = treadValues;
	}
	
	//constructors**********
	
	public TreadHistoriqueValues() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TreadHistoriqueValues(List<TreadUtil> treadValues) {
		
		this.treadValues = treadValues;
	}
	
	
	
}
