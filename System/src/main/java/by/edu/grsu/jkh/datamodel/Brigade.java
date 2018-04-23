package by.edu.grsu.jkh.datamodel;

public class Brigade extends AbstractModel{
private int personsNumbers;
private String brigadeName;


public String getBrigadeName() {
	return brigadeName;
}
public void setBrigadeName (String brigadeName) {
	this.brigadeName = brigadeName;
}

public int getPersonsNumbers() {
	return personsNumbers;
}
public void setPersonsNumbers(int personsNumbers) {
	this.personsNumbers = personsNumbers;
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
