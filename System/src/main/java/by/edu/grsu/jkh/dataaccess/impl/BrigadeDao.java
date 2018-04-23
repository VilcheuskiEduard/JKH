package by.edu.grsu.jkh.dataaccess.impl;
import by.edu.grsu.jkh.dataaccess.AbstractDao; 
import by.edu.grsu.jkh.datamodel.Brigade; 
import by.edu.grsu.jkh.table.BrigadeTable; 

import java.io.Serializable; 
import java.util.List; 

public class BrigadeDao extends AbstractDao<BrigadeTable, Brigade> implements Serializable { 
public BrigadeDao(final String rootFolderPath) { 
super(rootFolderPath); 
} 

@Override 
public void saveNew(Brigade newBrigade) { 
// set ID 
newBrigade.setId(getNextId()); 
// get existing data 
final BrigadeTable brigadeTable = deserializeFromXml();
// add new row 
brigadeTable.getRows().add(newBrigade);
// save data 
serializeToXml(brigadeTable);
// 
} 

@Override 
public void update(Brigade entity) { 
// get existing data 
final BrigadeTable brigadeTable = deserializeFromXml();
// find by ID 
for (final Brigade row : brigadeTable.getRows()) {
if (row.getId().equals(entity.getId())) { 
// found!!! 
// copy data 
row.setBrigadeName(entity.getBrigadeName());
row.setPersonsNumbers(entity.getPersonsNumbers());
	break; 
} 
} 
// save updated table 
serializeToXml(brigadeTable);
} 

@Override 
public Brigade get(Long id) { 
// get existing data 
final BrigadeTable brigadeTable = deserializeFromXml();
// find by ID 
for (final Brigade row : brigadeTable.getRows()) {
if (row.getId().equals(id)) { 
return row; 
} 
} 
return null; 
} 

@Override 
public List<Brigade> getAll() { 
// get existing data 
final BrigadeTable brigadeTable = deserializeFromXml();
return brigadeTable.getRows();
} 

@Override 
public void delete(Long id) { 
// get existing data 
final BrigadeTable brigadeTable = deserializeFromXml();
// find by ID 
Brigade toBeDeleted = null; 
for (final Brigade row : brigadeTable.getRows()) {
if (row.getId().equals(id)) { 
// found!!! 
toBeDeleted = row; 
break; 
} 
} 
// remove from list 
brigadeTable.getRows().remove(toBeDeleted);
// save updated table 
serializeToXml(brigadeTable);
} 

@Override 
protected Class<BrigadeTable> getTableClass() { 
return BrigadeTable.class; 
} 

}