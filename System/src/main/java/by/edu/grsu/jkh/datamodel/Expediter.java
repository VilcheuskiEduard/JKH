package by.edu.grsu.jkh.datamodel;

public class Expediter extends AbstractModel {
	private String expediterFirstName;
	private String expediterLastName;
	
	public String getExpediterFirstName() {
		return expediterFirstName;
	}
	public void setExpediterFirstName (String expediterFirstName) {
		this.expediterFirstName = expediterFirstName;
	}

	public String getExpediterLastName() {
		return expediterLastName;
	}
	public void setExpediterLastName(String expediterLastName) {
		this.expediterLastName = expediterLastName;
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
