package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.dataaccess.AbstractDao;
import by.edu.grsu.jkh.datamodel.Expediter;
import by.edu.grsu.jkh.table.ExpediterTable;

import java.io.Serializable;
import java.util.List;

public class ExpediterDao extends AbstractDao<ExpediterTable,Expediter> implements Serializable {
  public ExpediterDao(final String rootFolderPath) {
    super(rootFolderPath);
  }

  @Override
  public void saveNew(Expediter newExpediter) {
    // set ID
    newExpediter.setId(getNextId());
    // get existing data
    final ExpediterTable expediterTable = deserializeFromXml();
    // add new row
    expediterTable.getRows().add(newExpediter);
    // save data
    serializeToXml(expediterTable);
    //
  }

  @Override
  public void update(Expediter entity) {
    // get existing data
    final ExpediterTable expediterTable = deserializeFromXml();
    // find by ID
    for (final Expediter row : expediterTable.getRows()) {
      if (row.getId().equals(entity.getId())) {
        // found!!!
        // copy data

       row.setExpediterFirstName(entity.getExpediterFirstName());
       row.setExpediterLastName(entity.getExpediterLastName());
        break;
      }
    }
    // save updated table
    serializeToXml(expediterTable);
  }

  @Override
  public Expediter get(Long id) {
    // get existing data
    final ExpediterTable expediterTable = deserializeFromXml();
    // find by ID
    for (final Expediter row : expediterTable.getRows()) {
      if (row.getId().equals(id)) {
        return row;
      }
    }
    return null;
  }

  @Override
  public List<Expediter> getAll() {
    // get existing data
    final ExpediterTable expediterTable = deserializeFromXml();
    return expediterTable.getRows();
  }

  @Override
  public void delete(Long id) {
    // get existing data
    final ExpediterTable expediterTable = deserializeFromXml();
    // find by ID
    Expediter toBeDeleted = null;
    for (final Expediter row : expediterTable.getRows()) {
      if (row.getId().equals(id)) {
        // found!!!
        toBeDeleted = row;
        break;
      }
    }
    // remove from list
    expediterTable.getRows().remove(toBeDeleted);
    // save updated table
    serializeToXml(expediterTable);
  }

  @Override
  protected Class<ExpediterTable> getTableClass() {
    return ExpediterTable.class;
  }

}
