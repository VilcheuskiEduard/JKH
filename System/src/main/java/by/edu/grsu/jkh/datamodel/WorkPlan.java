package by.edu.grsu.jkh.datamodel;

public class WorkPlan extends AbstractModel{
private Brigade brigade;
private Application application;


public Application getApplication() {
	return application;
}

public void setApplication (Application applicaton) {
	this.application = applicaton;
}


public Brigade getBrigade() {
	return brigade;
}
public void setBrigade (Brigade brigade) {
	this.brigade = brigade;
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
