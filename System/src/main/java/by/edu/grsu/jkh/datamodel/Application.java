package by.edu.grsu.jkh.datamodel;

public class Application extends AbstractModel{
 private String workType;
 private String scale;
 private boolean isMet;
 private int leadTime;
 private Expediter expediter;
 
 public Expediter getBrigade() {
		return expediter;
	}

public void setBrigade(Expediter expediter) {
		this.expediter = expediter;
	}
public String getWorkType() {
		return workType;
	}
 
public void setWorkType(String workType) {
		this.workType = workType;
	}

public String getScale() {
	return workType;
}

public void setScale(String scale) {
	this.scale = scale;
}

public int getLeadTime() {
	return leadTime;
}

public void setLeadTime(int leadTime) {
	this.leadTime = leadTime;
}	
	
	@Override 
	public boolean equals(Object obj) { 
	return super.equals(obj); 
	} 

	@Override 
	public int hashCode() { 
	return super.hashCode(); 
	} 

	@Override 
	public String toString() { 
	return super.toString(); 
	}
}
