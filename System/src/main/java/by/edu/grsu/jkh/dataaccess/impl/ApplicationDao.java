package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.dataaccess.AbstractDao;
import by.edu.grsu.jkh.datamodel.Application;
import by.edu.grsu.jkh.table.ApplicationTable;

import java.io.Serializable;
import java.util.List;

public class ApplicationDao extends AbstractDao<ApplicationTable, Application> implements Serializable {
  public ApplicationDao(final String rootFolderPath) {
    super(rootFolderPath);
  }

  @Override
  public void saveNew(Application newApplication) {
// set ID
    newApplication.setId(getNextId());
// get existing data
    final ApplicationTable applicationTable = deserializeFromXml();
// add new row
    applicationTable.getRows().add(newApplication);
// save data
    serializeToXml(applicationTable);
//
  }

  @Override
  public void update(Application entity) {
// get existing data
    final ApplicationTable applicationTable = deserializeFromXml();
// find by ID
    for (final Application row : applicationTable.getRows()) {
      if (row.getId().equals(entity.getId())) {
// found!!!
// copy data

        row.setLeadTime(entity.getLeadTime());
        row.setScale(entity.getScale());
        row.setWorkType(entity.getWorkType());
        break;
      }
    }
// save updated table
    serializeToXml(applicationTable);
  }

  @Override
  public Application get(Long id) {
// get existing data
    final ApplicationTable applicationTable = deserializeFromXml();
// find by ID
    for (final Application row : applicationTable.getRows()) {
      if (row.getId().equals(id)) {
        return row;
      }
    }
    return null;
  }

  @Override
  public List<Application> getAll() {
// get existing data
    final ApplicationTable applicationTable = deserializeFromXml();
    return applicationTable.getRows();
  }

  @Override
  public void delete(Long id) {
// get existing data
    final ApplicationTable applicationTable = deserializeFromXml();
// find by ID
    Application toBeDeleted = null;
    for (final Application row : applicationTable.getRows()) {
      if (row.getId().equals(id)) {
// found!!!
        toBeDeleted = row;
        break;
      }
    }
// remove from list
    applicationTable.getRows().remove(toBeDeleted);
// save updated table
    serializeToXml(applicationTable);
  }

  @Override
  protected Class<ApplicationTable> getTableClass() {
    return ApplicationTable.class;
  }

}
