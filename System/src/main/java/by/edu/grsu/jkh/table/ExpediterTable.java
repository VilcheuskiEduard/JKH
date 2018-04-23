package by.edu.grsu.jkh.table;
import java.util.ArrayList; 
import java.util.List; 	
import by.edu.grsu.jkh.datamodel.*;

public class ExpediterTable extends AbstractTable<Expediter>{
	private List<Expediter> rows; 
	@Override 
	public List<Expediter> getRows() { 
	if (rows == null) { 
	rows = new ArrayList<Expediter>(); 
	} 
	return rows; 
	} 

	@Override 
	public void setRows(List<Expediter> rows) { 
	this.rows = rows; 
	} 
}
