package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.dataaccess.AbstractDao;
import by.edu.grsu.jkh.datamodel.WorkPlan;
import by.edu.grsu.jkh.table.WorkPlanTable;

import java.io.Serializable;
import java.util.List;

public class WorkPlanDao extends AbstractDao<WorkPlanTable,WorkPlan> implements Serializable {
  public WorkPlanDao(final String rootFolderPath) {
    super(rootFolderPath);
  }

  @Override
  public void saveNew(WorkPlan newWorkPlan) {
    // set ID
    newWorkPlan.setId(getNextId());
    // get existing data
    final WorkPlanTable workPlanTable = deserializeFromXml();
    // add new row
    workPlanTable.getRows().add(newWorkPlan);
    // save data
    serializeToXml(workPlanTable);
    //
  }

  @Override
  public void update(WorkPlan entity) {
    // get existing data
    final WorkPlanTable workPlanTable = deserializeFromXml();
    // find by ID
    for (final WorkPlan row : workPlanTable.getRows()) {
      if (row.getId().equals(entity.getId())) {
        // found!!!
        // copy data
        row.setBrigade(entity.getBrigade());
        row.setApplication(entity.getApplication());
        break;
      }
    }
    // save updated table
    serializeToXml(workPlanTable);
  }

  @Override
  public WorkPlan get(Long id) {
    // get existing data
    final WorkPlanTable workPlanTable = deserializeFromXml();
    // find by ID
    for (final WorkPlan row : workPlanTable.getRows()) {
      if (row.getId().equals(id)) {
        return row;
      }
    }
    return null;
  }

  @Override
  public List<WorkPlan> getAll() {
    // get existing data
    final WorkPlanTable workPlanTable = deserializeFromXml();
    return workPlanTable.getRows();
  }

  @Override
  public void delete(Long id) {
    // get existing data
    final WorkPlanTable workPlanTable = deserializeFromXml();
    // find by ID
    WorkPlan toBeDeleted = null;
    for (final WorkPlan row : workPlanTable.getRows()) {
      if (row.getId().equals(id)) {
        // found!!!
        toBeDeleted = row;
        break;
      }
    }
    // remove from list
    workPlanTable.getRows().remove(toBeDeleted);
    // save updated table
    serializeToXml(workPlanTable);
  }

  @Override
  protected Class<WorkPlanTable> getTableClass() {
    return WorkPlanTable.class;
  }

}
