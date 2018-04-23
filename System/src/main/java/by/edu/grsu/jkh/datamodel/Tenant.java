package by.edu.grsu.jkh.datamodel;

public class Tenant extends AbstractModel{
	private String tenantFirstName;
	private String tenantLastName;
	
	public String getTenantFirstName() {
		return tenantFirstName;
	}
	public void setTenantFirstName (String tenantFirstName) {
		this.tenantFirstName = tenantFirstName;
	}

	public String getTenantLastName() {
		return tenantLastName;
	}
	public void setTenantLastName(String tenantLastName) {
		this.tenantLastName = tenantLastName;
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
