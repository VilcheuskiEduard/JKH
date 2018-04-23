package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.datamodel.Expediter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpediterDaoTest {
  private static final String TEST_XML_FOLDER = "testXmlFolder";
  private static ExpediterDao expediterDao;

  @BeforeClass
  public static void createDao() {
    expediterDao = new ExpediterDao(TEST_XML_FOLDER);
  }


  @AfterClass
  public static void deleteTestXmlData() {
    //	 write code to clean up test results from FS

  }

  @Test
  public void testAdd() {
    System.out.println("Start 'save' test for Expediter");
    final Expediter newApplication = saveNewExpediter();
    Assert.assertNotNull(expediterDao.get(newApplication.getId()));
  }

  @Test
  public void testDelete() {
    System.out.println("Start 'delete' test for Expediter");
    final Expediter newExpediter = saveNewExpediter();
    expediterDao.delete(newExpediter.getId());
    Assert.assertNull(expediterDao.get(newExpediter.getId()));
  }

  @Test
  public void testGetAll() {
    System.out.println("Start 'getAll' test for Expediter");
    final int initialRowsCount = expediterDao.getAll().size();
    saveNewExpediter();
    Assert.assertEquals(expediterDao.getAll().size(), initialRowsCount + 1);
  }

  private Expediter saveNewExpediter() {
    final Expediter newExpediter = new Expediter();
    /*newCircle.setRadius(10d);
    newCircle.setColour("red");
    newCircle.setCreated(new Date());
    circleDao.saveNew(newCircle);*/
    newExpediter.setExpediterLastName("Name");
    newExpediter.setExpediterFirstName("Name");
    expediterDao.saveNew(newExpediter);
    return newExpediter;
  }
}
