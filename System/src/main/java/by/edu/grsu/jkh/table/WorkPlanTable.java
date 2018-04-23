package by.edu.grsu.jkh.table;
import java.util.ArrayList; 
import java.util.List; 	
import by.edu.grsu.jkh.datamodel.*;

public class WorkPlanTable extends AbstractTable<WorkPlan>{
	private List<WorkPlan> rows; 
	@Override 
	public List<WorkPlan> getRows() { 
	if (rows == null) { 
	rows = new ArrayList<WorkPlan>(); 
	} 
	return rows; 
	} 

	@Override 
	public void setRows(List<WorkPlan> rows) { 
	this.rows = rows; 
	} 
}
