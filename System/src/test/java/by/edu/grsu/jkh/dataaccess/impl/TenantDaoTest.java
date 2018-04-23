package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.datamodel.Tenant;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TenantDaoTest {

  private static final String TEST_XML_FOLDER = "testXmlFolder";
  private static TenantDao tenantDao;

  @BeforeClass
  public static void createDao() {
    tenantDao = new TenantDao(TEST_XML_FOLDER);
  }


  @AfterClass
  public static void deleteTestXmlData() {
    //	 write code to clean up test results from FS

  }

  @Test
  public void testAdd() {
    System.out.println("Start 'save' test for Tenant");
    final Tenant newTenant = saveNewTenant();
    Assert.assertNotNull(tenantDao.get(newTenant.getId()));
  }

  @Test
  public void testDelete() {
    System.out.println("Start 'delete' test for Tenant");
    final Tenant newTenant = saveNewTenant();
    tenantDao.delete(newTenant.getId());
    Assert.assertNull(tenantDao.get(newTenant.getId()));
  }

  @Test
  public void testGetAll() {
    System.out.println("Start 'getAll' test for Tenant");
    final int initialRowsCount = tenantDao.getAll().size();
    saveNewTenant();
    Assert.assertEquals(tenantDao.getAll().size(), initialRowsCount + 1);
  }

  private Tenant saveNewTenant() {
    final Tenant newTenant = new Tenant();
    /*newCircle.setRadius(10d);
    newCircle.setColour("red");
    newCircle.setCreated(new Date());
    circleDao.saveNew(newCircle);*/
   newTenant.setTenantLastName("name");
   newTenant.setTenantFirstName("name");
   tenantDao.saveNew(newTenant);
    return newTenant;
  }
}
