package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.dataaccess.AbstractDao;
import by.edu.grsu.jkh.datamodel.Tenant;
import by.edu.grsu.jkh.table.TenantTable;

import java.io.Serializable;
import java.util.List;

public class TenantDao extends AbstractDao<TenantTable,Tenant> implements Serializable {
  public TenantDao(final String rootFolderPath) {
    super(rootFolderPath);
  }

  @Override
  public void saveNew(Tenant newTenant) {
    // set ID
    newTenant.setId(getNextId());
    // get existing data
    final TenantTable tenantTable = deserializeFromXml();
    // add new row
    tenantTable.getRows().add(newTenant);
    // save data
    serializeToXml(tenantTable);
    //
  }

  @Override
  public void update(Tenant entity) {
    // get existing data
    final TenantTable tenantTable = deserializeFromXml();
    // find by ID
    for (final Tenant row : tenantTable.getRows()) {
      if (row.getId().equals(entity.getId())) {
        // found!!!
        // copy data
        row.setTenantFirstName(entity.getTenantFirstName());
        row.setTenantLastName(entity.getTenantLastName());
        break;
      }
    }
    // save updated table
    serializeToXml(tenantTable);
  }

  @Override
  public Tenant get(Long id) {
    // get existing data
    final TenantTable tenantTable = deserializeFromXml();
    // find by ID
    for (final Tenant row : tenantTable.getRows()) {
      if (row.getId().equals(id)) {
        return row;
      }
    }
    return null;
  }

  @Override
  public List<Tenant> getAll() {
    // get existing data
    final TenantTable tenantTable = deserializeFromXml();
    return tenantTable.getRows();
  }

  @Override
  public void delete(Long id) {
    // get existing data
    final TenantTable tenantTable = deserializeFromXml();
    // find by ID
    Tenant toBeDeleted = null;
    for (final Tenant row : tenantTable.getRows()) {
      if (row.getId().equals(id)) {
        // found!!!
        toBeDeleted = row;
        break;
      }
    }
    // remove from list
    tenantTable.getRows().remove(toBeDeleted);
    // save updated table
    serializeToXml(tenantTable);
  }

  @Override
  protected Class<TenantTable> getTableClass() {
    return TenantTable.class;
  }

}
