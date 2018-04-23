package by.edu.grsu.jkh.table;
import java.util.ArrayList; 
import java.util.List; 	
import by.edu.grsu.jkh.datamodel.*;

public class ApplicationTable extends AbstractTable<Application>{
	private List<Application> rows; 
	@Override 
	public List<Application> getRows() { 
	if (rows == null) { 
	rows = new ArrayList<Application>(); 
	} 
	return rows; 
	} 

	@Override 
	public void setRows(List<Application> rows) { 
	this.rows = rows; 
	} 
}
