package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.datamodel.Application;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApplicationDaoTest {

  private static final String TEST_XML_FOLDER = "testXmlFolder";
  private static ApplicationDao applicationDao;

  @BeforeClass
  public static void createDao() {
    applicationDao = new ApplicationDao(TEST_XML_FOLDER);
  }


  @AfterClass
  public static void deleteTestXmlData() {
    //	 write code to clean up test results from FS

  }

  @Test
  public void testAdd() {
    System.out.println("Start 'save' test for Application");
    final Application newApplication = saveNewApplication();
    Assert.assertNotNull(applicationDao.get(newApplication.getId()));
  }

  @Test
  public void testDelete() {
    System.out.println("Start 'delete' test for Application");
    final Application newApplication = saveNewApplication();
    applicationDao.delete(newApplication.getId());
    Assert.assertNull(applicationDao.get(newApplication.getId()));
  }

  @Test
  public void testGetAll() {
    System.out.println("Start 'getAll' test for Application");
    final int initialRowsCount = applicationDao.getAll().size();
    saveNewApplication();
    Assert.assertEquals(applicationDao.getAll().size(), initialRowsCount + 1);
  }

  private Application saveNewApplication() {
    final Application newApplication = new Application();
    /*newCircle.setRadius(10d);
    newCircle.setColour("red");
    newCircle.setCreated(new Date());
    circleDao.saveNew(newCircle);*/
    newApplication.setWorkType("someWork");
    newApplication.setScale("10000");
    newApplication.setLeadTime(100);
    applicationDao.saveNew(newApplication);
    return newApplication;
  }

}
